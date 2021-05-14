import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmailFieldTest extends TestSettings{
    @Test
    //Check if no error message is displayed after providing a valid email address
    public void validEmailIsProvided() {
        FormPage formPage = new FormPage(driver);
        formPage.enterEmail(formPage.emailvalid);
    }

    @Test
    //Check if correct error message is displayed after providing an email address without an @
    public void atSignMissingInEmail() {
        FormPage formPage = new FormPage(driver);
        formPage.enterEmail(formPage.emailNoAtSign);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(formPage.cssForEmailError)));
        Assertions.assertEquals(formPage.emailIsInvalid, formPage.getEmailFieldNotificationText(), formPage.emailIsInvalid + " notification message was not displayed");
    }

    @Test
    //Check if correct error message is displayed after providing an email address without a domain name
    public void domainMissingInEmail() {
        FormPage formPage = new FormPage(driver);
        formPage.enterEmail(formPage.emailNoDomain);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(formPage.cssForEmailError)));
        Assertions.assertEquals(formPage.emailIsInvalid, formPage.getEmailFieldNotificationText(), formPage.emailIsInvalid + " notification message was not displayed");
    }

    @Test
    //Check if correct error message is displayed if no email address is provided and submit button is pressed
    public void emailIsNotProvided() {
        FormPage formPage = new FormPage(driver);
        formPage.enterName(formPage.nameValid);
        formPage.clickSubmit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(formPage.cssForEmailError)));
        Assertions.assertEquals(formPage.fieldisRequired, formPage.getEmailFieldNotificationText(), formPage.fieldisRequired + " notification message was not displayed");
    }
}
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NameFieldTests extends TestSettings{

    @Test
    //Check if no error message is displayed after providing a valid name
    public void validNameIsProvided() {
        FormPage formPage = new FormPage(driver);
        formPage.enterName(formPage.nameValid);
        Assertions.assertFalse(driver.getPageSource().contains(formPage.htmlForNameError), formPage.htmlForNameError + " HTML code was present");
    }

    @Test
    //Check if correct error message is displayed after providing a one-character name
    public void nameIsTooShort() {
        FormPage formPage = new FormPage(driver);
        formPage.enterName(formPage.nameTooShort);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(formPage.cssForNameError)));
        Assertions.assertEquals(formPage.dataIsTooShort, formPage.getNameFieldNotificationText(), formPage.dataIsTooShort + " notification message was not displayed");
    }

    @Test
    //Check if correct error messageis displayed after providing a 70+ characters long name
    public void nameIsTooLong() {
        FormPage formPage = new FormPage(driver);
        formPage.enterName(formPage.nameTooLong);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(formPage.cssForNameError)));
        Assertions.assertEquals(formPage.dataIsTooLong, formPage.getNameFieldNotificationText(), formPage.dataIsTooLong + " notification message was not displayed");
    }

    @Test
    //Check if correct error message is displayed after leaving the name field empty and pressing the submit button
    public void nameIsNotProvided() {
        FormPage formPage = new FormPage(driver);
        formPage.enterEmail(formPage.emailvalid);
        formPage.clickSubmit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(formPage.cssForNameError)));
        Assertions.assertEquals(formPage.fieldisRequired, formPage.getNameFieldNotificationText(), formPage.fieldisRequired + " formPage.dataIsTooLong");

    }

    @Test
    //Check if correct error message is displayed after providing a name that consists solely from digits
    public void nameContainsDigits() {
        FormPage formPage = new FormPage(driver);
        formPage.enterName(formPage.nameDigits);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(formPage.cssForNameError)));
        Assertions.assertTrue(driver.getPageSource().contains(formPage.htmlForNameError),formPage.htmlForNameError + " HTML code was present");
    }
}
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SubmitButtonTests extends TestSettings{
    @Test
    //Check if submitting only required fields with correct data results in successful submit
    public void submitOnlyRequiredFields() {
        FormPage formPage = new FormPage(driver);
        formPage.enterName(formPage.nameValid);
        formPage.enterEmail(formPage.emailvalid);
        formPage.clickSubmitTwice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span")));
        Assertions.assertEquals(formPage.submitWasSuccessful, formPage.getSubmitNotificationText(), formPage.submitWasSuccessful + " notification was not displayed.");
    }
    @Test
    //Check if submitting only optional fields with correct data results in successful submit
    public void submitOnlyValidOptionalFields() {
        FormPage formPage = new FormPage(driver);
        formPage.enterSurname(formPage.nameValid);
        formPage.enterAge(formPage.ageValid);
        formPage.clickSubmitTwice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span")));
        Assertions.assertEquals(formPage.fieldisRequired, formPage.getNameFieldNotificationText(), formPage.fieldisRequired  + " notification was not displayed for name.");
        Assertions.assertEquals(formPage.fieldisRequired, formPage.getEmailFieldNotificationText(), formPage.fieldisRequired  + " notification was not displayed for email.");
    }

    @Test
    //Check if submitting all fields with correct data results in successful submit
    public void submitValidDataToAllFields() {
        FormPage formPage = new FormPage(driver);
        formPage.enterName(formPage.nameValid);
        formPage.enterSurname(formPage.nameValid);
        formPage.enterEmail(formPage.emailvalid);
        formPage.enterAge(formPage.ageValid);
        formPage.clickSubmitTwice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span")));
        Assertions.assertEquals(formPage.submitWasSuccessful, formPage.getSubmitNotificationText(), formPage.submitWasSuccessful  + " notification was not displayed.");
        Assertions.assertFalse(driver.getPageSource().contains(formPage.htmlForNameError), "Notification was displayed for name.");
        Assertions.assertFalse(driver.getPageSource().contains(formPage.htmlForEmailError), "Notification was displayed for email.");
    }

    @Test
    //Check if submitting all fields with incorrect data results in successful submit
    public void submitInvalidDataToAllFields() {
        FormPage formPage = new FormPage(driver);
        formPage.enterName(formPage.nameTooShort);
        formPage.enterSurname(formPage.nameTooLong);
        formPage.enterEmail(formPage.emailNoDomain);
        formPage.enterAge(formPage.ageLetters);
        formPage.clickSubmitTwice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[id]")));
        Assertions.assertFalse(driver.getPageSource().contains("<span>Success Submit</span>"), "Data has been submitted successfully.");
        Assertions.assertTrue(driver.getPageSource().contains(formPage.htmlForNameError), "Notification was displayed for name.");
        Assertions.assertTrue(driver.getPageSource().contains(formPage.htmlForSurnameError), "Notification was displayed for surname.");
        Assertions.assertTrue(driver.getPageSource().contains(formPage.htmlForEmailError), "Notification was displayed for email.");
        Assertions.assertTrue(driver.getPageSource().contains(formPage.htmlForAgeError), "Notification was displayed for age.");
    }
    @Test
    //Check if submitting an empty form results in successful submit
    public void submitEmptyForm() {
        FormPage formPage = new FormPage(driver);
        formPage.clickSubmitTwice();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span")));
        Assertions.assertFalse(driver.getPageSource().contains("<span>Success Submit</span>"), "Data has been submitted successfully.");
        Assertions.assertTrue(driver.getPageSource().contains(formPage.htmlForNameError), "Notification was displayed for name.");
        Assertions.assertTrue(driver.getPageSource().contains(formPage.htmlForEmailError), "Notification was displayed for email.");
    }
}
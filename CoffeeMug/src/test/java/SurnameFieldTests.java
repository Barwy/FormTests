import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SurnameFieldTests extends TestSettings {
    @Test
    //Check if no error message is displayed after providaing a valid surname
    public void validSurnameIsProvided() {
        FormPage formPage = new FormPage(driver);
        formPage.enterSurname(formPage.nameValid);
        Assertions.assertFalse(driver.getPageSource().contains(formPage.htmlForSurnameError), formPage.htmlForSurnameError + " HTML code was present");
    }

    @Test
    //Check if correct error message is displayed after providing a one-character surname
    public void surnameIsTooShort() {
        FormPage formPage = new FormPage(driver);
        formPage.enterSurname(formPage.nameTooShort);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(formPage.cssForSurnameError)));
        Assertions.assertEquals(formPage.dataIsTooShort, formPage.getSurnameFieldNotificationText(), "Incorrect notification message appeared or none was present.");
    }

    @Test
    //Check if correct error messageis displayed after providing a 70+ characters long name
    public void surnameIsTooLong() {
        FormPage formPage = new FormPage(driver);
        formPage.enterSurname(formPage.nameTooLong);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(formPage.cssForSurnameError)));
        Assertions.assertEquals(formPage.dataIsTooLong, formPage.getSurnameFieldNotificationText(), "Incorrect notification message appeared or none was present.");
    }

    @Test
    //Check if no error message is displayed after providing and removing a surname
    public void surnameIsNotProvided() {
        FormPage formPage = new FormPage(driver);
        formPage.enterSurname(formPage.nameValid);
        formPage.clearSurname();
        Assertions.assertFalse(driver.getPageSource().contains(formPage.htmlForSurnameError), "Notification message appeared.");
    }

   @Test
   //Check if correct error message is displayed after providing an invalid surname (digits)
   public void surnameContainsDigits() {
       FormPage formPage = new FormPage(driver);
       formPage.enterSurname(formPage.nameDigits);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(formPage.cssForSurnameError)));
       Assertions.assertTrue(driver.getPageSource().contains(formPage.htmlForSurnameError),"Notification message did not appear.");
   }
}
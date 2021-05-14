import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AgeFieldTests extends TestSettings{

    @Test
    //Check if no error message is displayed after a valid age is provided
    public void validAgeIsProvided() {
        FormPage formPage = new FormPage(driver);
        formPage.enterAge(formPage.ageValid);
        Assertions.assertFalse(driver.getPageSource().contains(formPage.htmlForAgeError), formPage.htmlForAgeError + " was not found in html code.");
    }

    @Test
    //Check if correct error message is displayed after a letter is provided
    public void ageWrittenWithLetters() {
        FormPage formPage = new FormPage(driver);
        formPage.enterAge(formPage.ageLetters);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(formPage.cssForAgeError)));
        Assertions.assertEquals(formPage.ageMustBeANumber, formPage.getAgeFieldNotificationText(),formPage.ageMustBeANumber + " notification message was not displayed.");
    }

    @Test
    //Check if correct error message is displayed after a negative number is provided
    public void ageIsNegativeNumber() {
        FormPage formPage = new FormPage(driver);
        formPage.enterAge(formPage.ageNegative);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(formPage.cssForAgeError)));
        Assertions.assertEquals(formPage.ageMustBeAPositiveNumber, formPage.getAgeFieldNotificationText(),formPage.ageMustBeAPositiveNumber + " notification message was not displayed.");
    }
}

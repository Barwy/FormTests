import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage extends PageObject {

    //Name and surname input strings;
    public String nameValid = "Samuel";
    public String nameTooShort = "J";
    public String nameTooLong = "aaaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffggggggggggh";
    public String nameDigits = "S4mu3l";

    //Email input strings;
    public String emailvalid = "spoof@email.com";
    public String emailNoAtSign = "spoofemail.com";
    public String emailNoDomain = "spoof@email";

    //Age input strings;
    public String ageValid = "20";
    public String ageLetters = "twenty";
    public String ageNegative = "-20";

    //CSS locators for input fields as strings;
    public String cssForNameError = "span[id='name-error']";
    public String cssForSurnameError = "span[id='surname-error']";
    public String cssForEmailError = "span[id='email-error']";
    public String cssForAgeError = "span[id='age-error']";

    //HTML code for input fields as strings;
    public String htmlForNameError = "<span id=\"name-error\">";
    public String htmlForSurnameError = "<span id=\"surname-error\">";
    public String htmlForEmailError = "<span id=\"email-error\">";
    public String htmlForAgeError = "<span id=\"age-error\">";

    //Notification strings
    public String fieldisRequired = "Required";
    public String dataIsTooLong = "Too Long!";
    public String dataIsTooShort = "Too Short!";
    public String emailIsInvalid = "Invalid email";
    public String ageMustBeANumber = "age must be a `number` type, but the final value was: `NaN` (cast from the value `\"" + ageLetters + "\"`).";
    public String ageMustBeAPositiveNumber = "age must be a positive number";
    public String submitWasSuccessful = "Success Submit";

    @FindBy(css = "input[name='name']")
        private WebElement nameField;

    @FindBy(css = "input[name='surname']")
        private WebElement surnameField;

    @FindBy(css = "input[name='email']")
        private WebElement emailField;

    @FindBy(css = "input[name='age']")
        private WebElement ageField;

    @FindBy(css = "button[type='submit']")
        private WebElement submitButton;

    @FindBy(xpath = ".//button[@type='submit']/following-sibling::span")
        private WebElement submitText;

    @FindBy(xpath = ".//input[@name='name']/following-sibling::span")
        private WebElement nameNotification;

    @FindBy(xpath = ".//input[@name='surname']/following-sibling::span")
    private WebElement surnameNotification;

    @FindBy(xpath = ".//input[@name='email']/following-sibling::span")
        private WebElement emailNotification;

    @FindBy(xpath = ".//input[@name='age']/following-sibling::span")

    private WebElement ageNotification;

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name) {
        this.nameField.sendKeys(name);
        this.ageField.click();
    }

    public void enterSurname(String surname) {
        this.surnameField.sendKeys(surname);
        this.ageField.click();
    }

    public void clearSurname() {
        this.surnameField.click();
        this.surnameField.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }

    public void enterEmail(String email) {
        this.emailField.sendKeys(email);
        this.ageField.click();
    }

    public void enterAge(String age) {
        this.ageField.sendKeys(age);
        this.emailField.click();
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void clickSubmitTwice() {
        submitButton.click();
        submitButton.click();
    }

    public String getSubmitNotificationText() {
        return submitText.getText();
    }

    public String getNameFieldNotificationText() {
        return nameNotification.getText();
    }

    public String getSurnameFieldNotificationText() {
        return surnameNotification.getText();
    }

    public String getEmailFieldNotificationText() {
        return emailNotification.getText();
    }

    public String getAgeFieldNotificationText() {
        return ageNotification.getText();
    }
}
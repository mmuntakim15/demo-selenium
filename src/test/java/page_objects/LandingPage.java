package page_objects;

import org.openqa.selenium.By;

public class LandingPage extends BasePage {

    //Locators
    private By emailTextField = By.id("email");
    private By passTextField = By.id("pass");
    private By loginButton = By.id("loginbutton");
    private By firstname = By.xpath("//input[@name='firstname']");
    private By lastname = By.xpath("//input[@name='lastname']");
    private By mobileNum = By.xpath("//input[@name='reg_email__']");
    private By newPass = By.xpath("//input[@name='reg_passwd__']");
    private By submitButton = By.xpath("//button[@name='websubmit']");
    private By genderError = By.xpath("//div[starts-with(text(),'Please choose a gender')]");
    private By messengerLink = By.linkText("Messenger");
    private By maleLocator = By.xpath("//input[@type='radio' and @value='2']");


    //Methods
    public void enterEmail(String value){
        setValue(emailTextField, value);
    }

    public void enterPassword(String value) {
        setValue(passTextField, value);
    }

    public void clickLoginButton() {
        clickOn(loginButton);
    }

    public void enterFirstName(String userFname) {
        setValue(firstname, userFname);
    }

    public void enterLastname(String userLname) {
        setValue(lastname, userLname);
    }

    public void enterMobileorEmail(String userMobileorEmail) {
        setValue(mobileNum, userMobileorEmail);
    }

    public void enterNewPassword(String userNewPassword) {
        setValue(newPass, userNewPassword);
    }

    public void clickSignUpButton() {
        clickOn(submitButton);
    }

    public String getGenderErrorMsg() {
        return getValueFromElement(genderError);
    }

    public void clickMessengerLink() {
        clickOn(messengerLink);
    }

    public void selectMaleGender() {
        clickOn(maleLocator);
    }

    public boolean isMaleSelected() {
        return isElementDisplayed(maleLocator);
    }

    public boolean isLoginButtonDisplayed() {
        return isElementDisplayed(loginButton);

    }
}

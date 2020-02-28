package page_objects;

import org.openqa.selenium.By;
import test_scripts.DriverWrapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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
    private By monthLocator = By.id("month");
    private By emailError = By.xpath("//input[text()='Please enter valid'");


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

    public void selectMonth(String monthValue) {
        String month = monthValue;
        if(monthValue.equalsIgnoreCase("current")) {
            SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
            Date now = new Date();
            month = monthFormat.format(now);
        }
        selectByTextFromDropDown(monthLocator, month);
    }

    public boolean checkMonthContainsDuplicate() {
        //{(feb, 2) , (mar,3)}    {}
        Map<String, Integer> ifDuplicates = isDropdownHasDuplicates(monthLocator);
        boolean hasDuplicates = false;
        if (ifDuplicates.size() > 0) {
            System.out.println("Duplicates: " + ifDuplicates);
            return true;
        } else {
            return false;
        }
    }

    public boolean isInvalidEmailErrorDisplayed() {
        return DriverWrapper.getDriver().findElement(emailError).isDisplayed();
    }


}

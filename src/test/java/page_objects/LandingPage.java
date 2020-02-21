package page_objects;

import org.openqa.selenium.By;

public class LandingPage extends BasePage {

    //Locators
    private By emailTextField = By.id("email");
    private By passTextField = By.id("pass");
    private By loginButton = By.id("submit");
    private By firstname = By.id("");

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

    public boolean isLoginButtonDisplayed() {
        return isElementDisplayed(loginButton);
    }
}

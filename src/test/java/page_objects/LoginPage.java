package page_objects;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    //Locators
    private By loginError = By.xpath("/a[contains(text(),'Recover Your Account')]");

    //Methods
    public String getErrorMessage() {
        return getValueFromElement(loginError);
    }
}

package page_objects;

import org.openqa.selenium.By;

public class MessengerLoginFailPage extends BasePage {

    private By blankSignInError = By.xpath("//div[starts-with(text(),'Incorrect email')]");

    public String getBlankSignInError() {
        return getValueFromElement(blankSignInError);
    }
}

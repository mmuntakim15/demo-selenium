package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import test_scripts.DriverWrapper;

public class BasePage {

    public void clickOn(By locator) {
        DriverWrapper.getDriver().findElement(locator).click();
    }

    public void setValue(By locator, String value) {
        DriverWrapper.getDriver().findElement(locator).sendKeys(value);
    }

    public String getValueFromElement(By locator) {
        return DriverWrapper.getDriver().findElement(locator).getText();
    }

    public boolean isElementDisplayed(By locator) {
        boolean isDisplayed;
        try {
            isDisplayed = DriverWrapper.getDriver().findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        }
        return isDisplayed;
    }
}


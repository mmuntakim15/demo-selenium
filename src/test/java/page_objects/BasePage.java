package page_objects;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import test_scripts.DriverWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BasePage {

    // This is the most common wait function used in selenium
    public static WebElement webAction(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverWrapper.getDriver())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotFoundException.class)
                .withMessage(
                        "Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return element;
    }

    public void clickOn(By locator) {
        webAction(locator).click();
    }

    public void setValue(By locator, String value) {
        webAction(locator).sendKeys(value);
    }

    public String getValueFromElement(By locator) {
        return webAction(locator).getText();
    }

    public boolean isElementDisplayed(By locator) {
        boolean isDisplayed;
        try {
            isDisplayed = webAction(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        }
        return isDisplayed;
    }

    public boolean isElementSelected(By locator) {
        return DriverWrapper.getDriver().findElement(locator).isSelected();
    }

    public boolean isElementEnabled(By locator) {
        return DriverWrapper.getDriver().findElement(locator).isEnabled();
    }

    public void selectByTextFromDropDown(By locator, String text) {
        WebElement dropDownElement = DriverWrapper.getDriver().findElement(locator);
        Select dropDown = new Select(dropDownElement);
        dropDown.selectByVisibleText(text);
    }

    public void selectByValueFromDropDown(By locator, String value) {
        WebElement dropDownElement = DriverWrapper.getDriver().findElement(locator);
        Select dropDown = new Select(dropDownElement);
        dropDown.selectByValue(value);
    }

    public void selectByIndexFromDropDown(By locator, int index) {
        WebElement dropDownElement = DriverWrapper.getDriver().findElement(locator);
        Select dropDown = new Select(dropDownElement);
        dropDown.selectByIndex(index);
    }

    public Map<String,Integer> isDropdownHasDuplicates(By locator) {
        //Planned to result to show up like below:
        //{(feb,2), (mar-3)}
        WebElement dropDownElement = DriverWrapper.getDriver().findElement(locator);
        Select dropDown = new Select(dropDownElement);
        List<WebElement> allOptionsElements = dropDown.getOptions();

        List<String> allValues = new ArrayList<>();
        for (WebElement option : allOptionsElements) {
            allValues.add(option.getText());
        }

        Map<String, Integer> duplicates = new HashMap<>();
        //{jan, feb, mar, feb, mar,}
        for (int i=0 ; i < allValues.size()-1 ; i++) {
            int count=1;
            String val = allValues.get(i);
            if (!duplicates.containsKey(val)) {
                for (int j = i + 1; j <= allValues.size() - 1; j++) {
                    if (val.equalsIgnoreCase(allValues.get(j))) {
                        count++;
                    }
                }
                if (count > 1) {
                    duplicates.put(val, count);
                }
            }
        }
        return duplicates;
    }

    public boolean isDropDownContainsValue(By locator, String valueToCheck) {
        Map<String, Integer> duplicates = new HashMap<>();
        List<String> allValues = new ArrayList<>();
        WebElement dropDownElement = DriverWrapper.getDriver().findElement(locator);
        Select dropDown = new Select(dropDownElement);
        List<WebElement> allOptionsElements = dropDown.getOptions();

        for (WebElement option : allOptionsElements) {
            allValues.add(option.getText().toLowerCase());
        }
        return allValues.contains(valueToCheck.toLowerCase());
    }

    public List<WebElement> getElements(By locator) {
        return DriverWrapper.getDriver().findElements(locator);
    }

}


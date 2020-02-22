package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import test_scripts.DriverWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        WebElement dropDownElement = DriverWrapper.getDriver().findElement(locator);
        Select dropDown = new Select(dropDownElement);
        List<WebElement> allOptionsElements = dropDown.getOptions();

        List<String> allValues = new ArrayList<>();
        for (WebElement option : allOptionsElements) {
            allValues.add(option.getText());
        }

        Map<String, Integer> duplicates = new HashMap<>();
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

}


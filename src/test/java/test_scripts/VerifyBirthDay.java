package test_scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class VerifyBirthDay extends DriverWrapper{

    @Test
    public void verifyBirthDay() throws InterruptedException {

        WebElement month = getDriver().findElement(By.id("month"));
        Select monthDropdown = new Select(month);
//        monthDropdown.selectByVisibleText("Jan");
//        Thread.sleep(3000);
//        monthDropdown.selectByIndex(4);
//        Thread.sleep(3000);
//        monthDropdown.selectByValue("3");

        List<WebElement> options = monthDropdown.getOptions();

        boolean isFound = false;
        for (WebElement option : options) {
            if (option.getText().equals("mo")) {
                isFound = true;
                break;
            }
        }
        Assert.assertTrue(isFound, "ERROR: value is not found");
    }
}

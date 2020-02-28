package page_objects.Expedia;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page_objects.BasePage;
import test_scripts.DriverWrapper;

import java.util.List;

public class Homepage extends BasePage {

    // page object only contains code to demonstrate Auto-complete functionality.
    By autoOptions = By.xpath("//li[@class='results-item']//a");

    public void autoComplete(String clickThis) {
        List<WebElement> options = getElements(autoOptions);
        for (WebElement option : options) {
            if(option.getAttribute("data-value").equalsIgnoreCase(clickThis)) {
                option.click();
                break;
            }
        }
    }



}

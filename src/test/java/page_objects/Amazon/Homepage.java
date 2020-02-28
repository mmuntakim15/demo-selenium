package page_objects.Amazon;

import org.openqa.selenium.By;
import page_objects.BasePage;

public class Homepage extends BasePage {

    By searchBox = By.id("twotabsearchtextbox");
    By searchIcon = By.xpath("//input[@value='Go']");


    public void writeInSearchBox(String searchThis) {
        setValue(searchBox, searchThis);
    }

    public void clickOnSearchIcon() {
        clickOn(searchIcon);
    }



}

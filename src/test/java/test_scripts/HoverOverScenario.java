package test_scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HoverOverScenario extends DriverWrapper {

    @Test
    public static void hoverOver() {
        getDriver().manage().window().maximize();
        WebElement productMenu = getDriver().findElement(By.linkText("Products"));

        Actions actions = new Actions(getDriver());
        //Hover over element
        actions.moveToElement(productMenu).build().perform();
        //Double click on web element
        actions.doubleClick(productMenu);
        //Click and hold
        actions.clickAndHold(productMenu);
        //Context click (the other side)
        actions.contextClick(productMenu);
        //Drag and drop
        actions.dragAndDrop(productMenu, productMenu);
        //usage of keys (only on text fields)
        productMenu.sendKeys(Keys.TAB);
        syncWait(2000);
        getDriver().findElement(By.linkText("Demo applications")).click();
        syncWait(2000);
    }
}

package test_scripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class VerifyAlert extends DriverWrapper {

    @Test
    public void verifyAlert() {
        getDriver().switchTo().frame("iframeResult");
        getDriver().findElement(By.xpath("html/body/button")).click();
        getDriver().switchTo().alert().accept();
        getDriver().findElement(By.xpath("html/body/button")).click();
        getDriver().switchTo().alert().dismiss();

        getDriver().navigate().forward();
        getDriver().navigate().back();
        getDriver().navigate().refresh();
    }
}

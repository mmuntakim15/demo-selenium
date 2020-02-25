package test_scripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class VerifyWindow extends DriverWrapper {

    private void switchToWindow(int index) {
        List<String> windows = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(windows.get(index));
    }

    //Closes current window and switches back to root window
    private void switchToRootWindow() {
        List<String> windows = new ArrayList<>(getDriver().getWindowHandles());

        for (int i = 1; i < windows.size(); i++) {
            getDriver().switchTo().window(windows.get(i));
            getDriver().close();
        }
        getDriver().switchTo().window(windows.get(0));
    }

    @Test
    public void testWindow() throws InterruptedException {
        getDriver().findElement(By.cssSelector("#privacy-link")).click();
        Thread.sleep(2000);
        switchToWindow(1);
        Thread.sleep(2000);
        getDriver().findElement(By.linkText("Sign Up")).click();
        Thread.sleep(2000);
        switchToRootWindow();
        Thread.sleep(2000);
    }
}

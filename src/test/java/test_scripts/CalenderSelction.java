package test_scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CalenderSelction extends DriverWrapper{

    @Test
    public void selectCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("d");
        Date date = new Date();
        String today = sdf.format(date);

        syncWait(3000);
        getDriver().findElement(By.xpath("//input[@id='qf-0q-localised-check-in']")).click();

        List<WebElement> days = getDriver().findElements(By.xpath("(//div[contains(@class,'datepicker-bd')])[1]//td//a"));

        for (WebElement day : days) {
            System.out.println(day.getText());
            if (day.getText().equals(today)) {

                day.click();
                syncWait(2000);
                break;
            }
        }


    }

}

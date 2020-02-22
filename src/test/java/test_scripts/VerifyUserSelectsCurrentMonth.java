package test_scripts;

import org.testng.annotations.Test;
import page_objects.LandingPage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VerifyUserSelectsCurrentMonth extends DriverWrapper {

    @Test
    public void verifyUserSelectsCurrentMonth() {
        LandingPage landingPage = new LandingPage();

        landingPage.enterFirstName("userFname");
        landingPage.enterLastname("userLname");
        landingPage.enterMobileorEmail("1234567890");
        landingPage.enterNewPassword("test1234");
        landingPage.selectMonth("Current");
        landingPage.selectMaleGender();
        landingPage.clickSignUpButton();
    }
}

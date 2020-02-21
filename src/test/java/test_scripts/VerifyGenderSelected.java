package test_scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.LandingPage;

public class VerifyGenderSelected extends DriverWrapper {

    @Test
    public void verifyGenderSelected() {
        LandingPage landingPage = new LandingPage();

        landingPage.enterFirstName("firstname");
        landingPage.enterLastname("lastname");
        landingPage.enterMobileorEmail("1234567890");
        landingPage.enterNewPassword("test@12345");
        if (!landingPage.isMaleSelected()) {
            landingPage.selectMaleGender();
        }
        Assert.assertTrue(landingPage.isMaleSelected(), "Male radio button is not selected.");

    }

}

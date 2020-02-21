package test_scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.LandingPage;
import page_objects.LoginPage;

public class VerifyGenderError extends DriverWrapper {

    @Test
    public void verifyGenderError() {
        LandingPage landingPage = new LandingPage();

        landingPage.enterFirstName("firstname");
        landingPage.enterLastname("lastname");
        landingPage.enterMobileorEmail("1234567890");
        landingPage.enterNewPassword("test@12345");
        landingPage.clickSignUpButton();
        String expGenderError = "Please choose a gender. You can change who can see this later.";
        Assert.assertEquals(landingPage.getGenderErrorMsg(), expGenderError,
                "Gender error is not as expected");
    }
}

package test_scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.LandingPage;
import page_objects.LoginPage;

public class VerifyInvalidLogin extends DriverWrapper {

    @Test
    public void verifyInvalidLogin() {
        LandingPage landingPage = new LandingPage();
        LoginPage loginPage = new LoginPage();

        landingPage.enterEmail("mohammad@technosoft.io");
        landingPage.enterPassword("test12345");
        landingPage.clickLoginButton();
        //Assertion
        Assert.assertEquals("Recover your account", loginPage.getErrorMessage());
    }
}

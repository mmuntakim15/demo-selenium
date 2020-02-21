package test_scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.LandingPage;
import page_objects.LoginPage;
import page_objects.MessengerLoginFailPage;
import page_objects.MessengerPage;

public class VerifyBlankMessengerSignInError extends DriverWrapper {


    @Test
    public void verifyInvalidMessengerError() {
        LandingPage landingPage = new LandingPage();
        MessengerPage messengerPage = new MessengerPage();
        MessengerLoginFailPage mLoginFail = new MessengerLoginFailPage();

        landingPage.clickMessengerLink();
        messengerPage.clickSignInButton();
        String expErrorMsg = "Incorrect email address or phone number";
        Assert.assertEquals(expErrorMsg, mLoginFail.getBlankSignInError(),
                "Error message is not as expected");
    }
}

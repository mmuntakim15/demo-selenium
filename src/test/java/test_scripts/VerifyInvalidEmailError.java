package test_scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.LandingPage;

import java.util.ArrayList;
import java.util.List;

public class VerifyInvalidEmailError {

    @Test
    public void verifyInvalidEmailError() {

        LandingPage landingPage = new LandingPage();

        List<String> invalidEmails = new ArrayList<>();
        invalidEmails.add("plainaddress");
        invalidEmails.add("あいうえお@example.com");

        int errorReceived = 0;

        for(String email: invalidEmails) {
            landingPage.enterFirstName("firstname");
            landingPage.enterLastname("lastname");
            landingPage.enterMobileorEmail(email);
            landingPage.enterNewPassword("test@12345");
            landingPage.selectMaleGender();
            landingPage.clickSignUpButton();
            if (landingPage.isInvalidEmailErrorDisplayed()) {
                errorReceived++;
            }
        }
        Assert.assertEquals(errorReceived, invalidEmails.size(), "Invalid email error doesn't show up for all invalid emails.");



    }



}

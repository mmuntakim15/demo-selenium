package test_scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.BasePage;
import page_objects.LandingPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VerifyDropdownContainsDuplicates extends DriverWrapper {

    @Test
    public void verifyDuplicatesInMonth() {
        LandingPage landingPage = new LandingPage();
        boolean result = landingPage.checkMonthContainsDuplicate();
        Assert.assertFalse(result, "Months dropdown contains duplicate values");
    }

}

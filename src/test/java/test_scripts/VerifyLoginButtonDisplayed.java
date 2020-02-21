package test_scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.LandingPage;

public class VerifyLoginButtonDisplayed extends DriverWrapper{

    @Test
    public void testLoginButton() {

        LandingPage landingPage = new LandingPage();

        Assert.assertTrue(landingPage.isLoginButtonDisplayed(), "ERROR: Submit button is not displayed");
    }
}

/**
 * Homework 1: Signup form should not accept any invalid email address
 * 1. Enter Firstname
 * 2. Enter Lastname
 * 3. Enter Invalid Email
 * 4. Click on New Password text field
 * 5. Click on red warning button on email field
 *
 * 6. Verify Error Message "Please enter a valid mobile number or email address."
 */

/**
 * List of Invalid Email Addresses
 *
 * plainaddress
 * #@%^%#$@#$@#.com
 * @example.com
 * Joe Smith <email@example.com>
 * email.example.com
 * email@example@example.com
 * .email@example.com
 * email.@example.com
 * email..email@example.com
 * あいうえお@example.com
 * email@example.com (Joe Smith)
 * email@example
 * email@-example.com
 * email@example.web
 * email@111.222.333.44444
 * email@example..com
 * Abc..123@example.com
 */

/**
 * Homework #2: Select the current month from month dropdown
 */

/**
 * Homework #3: Find out if dropdown contains duplicates, if yes fail the test and print the duplicate values
 */

/**
 * Homework #4: Create basepage action for, isDisplayed, isSelected, isEnabled, selectByText, selectByIndex, selectByValue, isDropDownContainsValue, isDropdownHasDuplicates
 */

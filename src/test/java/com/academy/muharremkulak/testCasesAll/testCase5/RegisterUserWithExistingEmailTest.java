package com.academy.muharremkulak.testCasesAll.testCase5;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.AccountCreatedPage;
import com.academy.muharremkulak.pages.HomePage;
import com.academy.muharremkulak.pages.SignupLoginPage;
import com.academy.muharremkulak.pages.SignupPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class RegisterUserWithExistingEmailTest extends BaseTest {

    private HomePage homePage;
    private SignupLoginPage signupLoginPage;
    private SignupPage signupPage;
    private AccountCreatedPage accountCreatedPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void RegisterUserWithExistingEmailTest(Map<String,String> data) throws InterruptedException {


        extentTest = extentReports.startTest("Register User With Existing Email");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        signupLoginPage = new SignupLoginPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Signup Login page");
        signupPage = new SignupPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Signup page");
        accountCreatedPage = new AccountCreatedPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Account Created page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home Page");
        homePage.verifyHomePageIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Home Page is visible");
        homePage.clickOnSignupLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked on Signup/Login Button");

        signupLoginPage.verifyNewUserSignupHeader();
        extentTest.log(LogStatus.PASS, "Verified New User Signup Header");
        signupLoginPage.enterNameAndEmailForSignup(data);
        extentTest.log(LogStatus.PASS, "Entered Name and Email for Signup");
        signupLoginPage.clickOnSignupButton();
        extentTest.log(LogStatus.PASS, "Clicked on Signup Button");
        signupLoginPage.verifyErrorMessageIsVisibleForSignup();
        extentTest.log(LogStatus.PASS, "Verified error message is visible for signup");

    }
}

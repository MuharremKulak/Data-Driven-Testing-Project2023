package com.academy.muharremkulak.testCasesAll.testCase2;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.HomePage;
import com.academy.muharremkulak.pages.SignupLoginPage;
import com.academy.muharremkulak.pages.SignupPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import java.util.Map;

public class LoginUserWithIncorrectEmailAndPasswordTest extends BaseTest {

    private HomePage homePage;
    private SignupLoginPage signupLoginPage;
    private SignupPage signupPage;

    @Test(dataProvider = "CustomerAccountInformation")
    public void LoginUserWithCorrectEmailAndPasswordTest(Map<String,String> data){

        extentTest = extentReports.startTest("LoginUserWithIncorrectInformation");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        signupLoginPage = new SignupLoginPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Signup Login page");
        signupPage = new SignupPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Signup page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home Page");
        homePage.verifyHomePageIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Home Page is visible");
        homePage.clickOnSignupLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked to Signup/Login Button");

        signupLoginPage.verifyLoginToYourAccountIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Login to your account is visible");
        signupLoginPage.enterLoginIncorrectInformation(data);
        extentTest.log(LogStatus.PASS, "Entered incorrect email and password credentials");
        signupLoginPage.verifyErrorMessageIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Error Message is visible");

    }
}

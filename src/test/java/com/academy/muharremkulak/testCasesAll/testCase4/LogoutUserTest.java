package com.academy.muharremkulak.testCasesAll.testCase4;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.AccountCreatedPage;
import com.academy.muharremkulak.pages.HomePage;
import com.academy.muharremkulak.pages.SignupLoginPage;
import com.academy.muharremkulak.pages.SignupPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class LogoutUserTest extends BaseTest {

    private HomePage homePage;
    private SignupLoginPage signupLoginPage;
    private SignupPage signupPage;
    private AccountCreatedPage accountCreatedPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void LogoutUser(Map<String,String> data){

        extentTest = extentReports.startTest("Logout User Test");

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
        extentTest.log(LogStatus.PASS, "Clicked to Signup/Login Button");

        signupLoginPage.verifyLoginToYourAccountIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Login to your account is visible");
        signupLoginPage.enterLoginCorrectInformation(data);
        extentTest.log(LogStatus.PASS, "Entered correct email and password credentials");

        accountCreatedPage.verifyLoggedInAsUsername(data);
        extentTest.log(LogStatus.PASS, "Verified Logged In as Username");
        accountCreatedPage.clickLogoutButton();
        extentTest.log(LogStatus.PASS, "Clicked Logout Button");
        signupLoginPage.verifyLoginToYourAccountIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Login to your account is visible");


    }
}

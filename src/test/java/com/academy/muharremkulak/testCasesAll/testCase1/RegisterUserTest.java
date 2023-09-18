package com.academy.muharremkulak.testCasesAll.testCase1;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.AccountCreatedPage;
import com.academy.muharremkulak.pages.HomePage;
import com.academy.muharremkulak.pages.SignupLoginPage;
import com.academy.muharremkulak.pages.SignupPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class RegisterUserTest extends BaseTest {

    private HomePage homePage;
    private SignupLoginPage signupLoginPage;
    private SignupPage signupPage;
    private AccountCreatedPage accountCreatedPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void registerUser(Map<String,String> data) throws InterruptedException {

        extentTest = extentReports.startTest("registerUserTest");

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

        signupPage.verifyEnterAccountInformationHeader();
        extentTest.log(LogStatus.PASS, "Verified Enter Account Information Header");
        signupPage.chooseMrOrMrs();
        extentTest.log(LogStatus.PASS, "Chosen Mr. or Mrs. options");
        signupPage.enterPassword(data);
        extentTest.log(LogStatus.PASS, "Entered Password");
        signupPage.chooseDateOfBirth();
        extentTest.log(LogStatus.PASS, "Chosen Data of Birth");
        signupPage.clickOnSignupForOurNewsletterBox();
        extentTest.log(LogStatus.PASS, "Clicked on Signup for our newsletter box");
        signupPage.clickOnReceiveSpecialOffersFromOurPartners();
        extentTest.log(LogStatus.PASS, "Clicked on receive special offers from our partners box");
        signupPage.enterFirstNameAndLastNameForRegister(data);
        extentTest.log(LogStatus.PASS, "Entered first name and last name for register");
        signupPage.enterCompanyForRegister(data);
        extentTest.log(LogStatus.PASS, "Entered company name for register");
        signupPage.enterAddressInformationForRegister(data);
        extentTest.log(LogStatus.PASS, "Entered address information for register");
        signupPage.enterMobileNumberInformationForRegister(data);
        extentTest.log(LogStatus.PASS, "Entered mobile number for register");
        signupPage.clickCreateAccountButton();
        extentTest.log(LogStatus.PASS, "Clicked create account button");

        accountCreatedPage.verifyAccountCreatedHeader();
        extentTest.log(LogStatus.PASS, "Verified Account Created Header");
        accountCreatedPage.clickOnContinueButton();
        extentTest.log(LogStatus.PASS, "Clicked on continue button");
        accountCreatedPage.verifyLoggedInAsUsername(data);
        extentTest.log(LogStatus.PASS, "Verified Logged in as Username");
//        accountCreatedPage.clickDeleteAccountButton();
//        extentTest.log(LogStatus.PASS, "Clicked Delete Account Button");
//        accountCreatedPage.verifyAccountDeletedHeader();
//        extentTest.log(LogStatus.PASS, "Verified Account Deleted Header");
//        accountCreatedPage.clickContinueAfterDeletedAccount();
//        extentTest.log(LogStatus.PASS, "Clicked Continue Button after account deleted");

    }
}

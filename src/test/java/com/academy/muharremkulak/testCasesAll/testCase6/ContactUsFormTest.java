package com.academy.muharremkulak.testCasesAll.testCase6;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class ContactUsFormTest extends BaseTest {

    private HomePage homePage;
    private SignupLoginPage signupLoginPage;
    private SignupPage signupPage;
    private AccountCreatedPage accountCreatedPage;
    private ContactUsPage contactUsPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void ContactUsFormTest(Map<String,String> data) throws InterruptedException {

        extentTest = extentReports.startTest("Contact Us Form Test");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        signupLoginPage = new SignupLoginPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Signup Login page");
        signupPage = new SignupPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Signup page");
        accountCreatedPage = new AccountCreatedPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Account Created page");
        contactUsPage = new ContactUsPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Contact us page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home Page");
        homePage.verifyHomePageIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Home Page is visible");
        homePage.clickOnContactUsButton();
        extentTest.log(LogStatus.PASS, "Clicked Contact us button");
        contactUsPage.verifyGetInTouchHeader();
        extentTest.log(LogStatus.PASS, "Verified Get in Touch header is visible");
        contactUsPage.enterInformationForContactUsPage(data);
        extentTest.log(LogStatus.PASS, "Entered information for contact us page");
        contactUsPage.uploadAFileForContactPage();
        extentTest.log(LogStatus.PASS, "Uploaded file for contact us page");
        contactUsPage.clickSubmitButtonForContactPage();
        extentTest.log(LogStatus.PASS, "Clicked Submit button for contact us page");
        contactUsPage.clickOkButton();
        extentTest.log(LogStatus.PASS, "Clicked Ok button");
        contactUsPage.verifySuccessMessage();
        extentTest.log(LogStatus.PASS, "Verified Success Message");
        contactUsPage.clickOnHomePage();
        extentTest.log(LogStatus.PASS, "Clicked Home button");
        homePage.verifyHomePageIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Home Page is visible");

    }
}

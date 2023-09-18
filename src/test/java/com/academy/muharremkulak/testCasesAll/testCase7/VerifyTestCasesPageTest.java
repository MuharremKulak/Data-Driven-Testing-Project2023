package com.academy.muharremkulak.testCasesAll.testCase7;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class VerifyTestCasesPageTest extends BaseTest {

    private HomePage homePage;
    private SignupLoginPage signupLoginPage;
    private TestCasesPage testCasesPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void VerifyTestCasesTest(Map<String,String> data) throws InterruptedException {

        extentTest = extentReports.startTest("Verify Test Cases Page Test");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        signupLoginPage = new SignupLoginPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Signup Login page");
        testCasesPage = new TestCasesPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Test Cases page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home Page");
        homePage.verifyHomePageIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Home Page is visible");
        homePage.clickOnTestCasesButton();
        extentTest.log(LogStatus.PASS, "Clicked on Test Cases Button");
        testCasesPage.verifyTestCasesPage();
        extentTest.log(LogStatus.PASS, "Verified Test Cases Page is visible");

    }
}
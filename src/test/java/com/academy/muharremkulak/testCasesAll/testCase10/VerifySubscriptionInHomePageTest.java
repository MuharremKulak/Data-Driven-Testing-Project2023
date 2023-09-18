package com.academy.muharremkulak.testCasesAll.testCase10;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class VerifySubscriptionInHomePageTest extends BaseTest {

    private HomePage homePage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void SearchProductTest(Map<String, String> data) throws InterruptedException {

        extentTest = extentReports.startTest("Search Product Test");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home Page");
        homePage.verifyHomePageIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Home Page is visible");
        homePage.scrollAllTheWayDown();
        extentTest.log(LogStatus.PASS, "Scrolled all the way down");
        homePage.verifySubscriptionHeader();
        extentTest.log(LogStatus.PASS, "Verified subscription is visible");
        homePage.enterEmailForSubscription(data);
        extentTest.log(LogStatus.PASS, "Entered and Searched email for subscription");


    }
}
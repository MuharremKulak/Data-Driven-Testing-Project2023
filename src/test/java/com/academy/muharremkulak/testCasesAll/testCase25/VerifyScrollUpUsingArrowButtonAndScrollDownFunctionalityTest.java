package com.academy.muharremkulak.testCasesAll.testCase25;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class VerifyScrollUpUsingArrowButtonAndScrollDownFunctionalityTest extends BaseTest {

    private HomePage homePage;

    @Test
    public void verifyScrollUpUsingArrowButtonAndScrollDownFunctionalityPageTest() throws InterruptedException {

        extentTest = extentReports.startTest("Verify Scroll Up Using Arrow Button and Scroll Down Functionality");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home Page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home Page");
        homePage.verifyHomePageIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Home Page is visible");
        homePage.scrollAllTheWayDown();
        extentTest.log(LogStatus.PASS, "Scrolled all the way down");
        homePage.verifySubscriptionHeader();
        extentTest.log(LogStatus.PASS, "Verified Subscription is visible");
        homePage.scrollAllTheWayUp();
        extentTest.log(LogStatus.PASS, "Scrolled all the way up");
        homePage.verifyThatPageIsScrollUpAndFullFledgedTextIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Full-Fledged Text is visible");

    }




}
package com.academy.muharremkulak.testCasesAll.testCase11;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.CheckoutPage;
import com.academy.muharremkulak.pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class VerifySubscriptionInCartPage extends BaseTest {

    private HomePage homePage;
    private CheckoutPage checkoutPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void VerifySubscriptionInCartPageTest(Map<String, String> data) throws InterruptedException {

        extentTest = extentReports.startTest("Verify Subscription In Cart Page Test");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        checkoutPage = new CheckoutPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Checkout page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home Page");
        homePage.verifyHomePageIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Home Page is visible");
        homePage.clickOnCartButton();
        extentTest.log(LogStatus.PASS, "Clicked on cart button");
        checkoutPage.scrollAllTheWayDownToSubscriptionBox();
        extentTest.log(LogStatus.PASS, "Scrolled down all the way down to subscription box");
        checkoutPage.verifySubscriptionHeaderForCheckoutPage();
        extentTest.log(LogStatus.PASS, "Verified Subscription Header is visible");
        checkoutPage.enterEmailForSubscriptionAndClick(data);
        extentTest.log(LogStatus.PASS, "Entered email and click arrow button");
        checkoutPage.verifySuccessMessage();
        extentTest.log(LogStatus.PASS, "Verified Success message");

    }
}

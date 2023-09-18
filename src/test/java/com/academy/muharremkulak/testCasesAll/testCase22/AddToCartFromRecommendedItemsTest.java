package com.academy.muharremkulak.testCasesAll.testCase22;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class AddToCartFromRecommendedItemsTest extends BaseTest {

    private HomePage homePage;
    private CheckoutPage checkoutPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void AddReviewOnProductPageTest(Map<String, String> data) throws InterruptedException {

        extentTest = extentReports.startTest("Add Review On Product Test");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        checkoutPage = new CheckoutPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Checkout page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home Page");
        homePage.verifyHomePageIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Home Page is visible");
        homePage.scrollAllTheWayDown();
        extentTest.log(LogStatus.PASS, "Scrolled to bottom of page");
        homePage.verifyRecommendedItemsAreVisible();
        extentTest.log(LogStatus.PASS, "Verified 'RECOMMENDED ITEMS' are visible");
        homePage.clickOnAddToCartOnRecommendedProduct();
        extentTest.log(LogStatus.PASS, "Clicked on 'Add To Cart' on Recommended product");
        homePage.clickOnViewCartButton();
        extentTest.log(LogStatus.PASS, "Clicked on 'View Cart' button");
        checkoutPage.verifyCartPageDisplayed();
        extentTest.log(LogStatus.PASS, "Verify that product is displayed in cart page");
    }
}
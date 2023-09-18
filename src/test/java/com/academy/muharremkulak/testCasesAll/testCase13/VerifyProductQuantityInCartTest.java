package com.academy.muharremkulak.testCasesAll.testCase13;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.CheckoutPage;
import com.academy.muharremkulak.pages.HomePage;
import com.academy.muharremkulak.pages.ProductDetailPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class VerifyProductQuantityInCartTest extends BaseTest {

    private HomePage homePage;
    private ProductDetailPage productDetailPage;
    private CheckoutPage checkoutPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void verifyProductQuantityInCartTest(Map<String,String> data) throws InterruptedException {

        extentTest = extentReports.startTest("Verify Product Quantity In Cart");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        productDetailPage = new ProductDetailPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated product detail page");
        checkoutPage = new CheckoutPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Checkout page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home Page");
        homePage.verifyHomePageIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Home Page is visible");
        homePage.clickViewProductForAnyProduct();
        extentTest.log(LogStatus.PASS, "Clicked view product button");
        productDetailPage.verifyProductDetailPageTitle();
        extentTest.log(LogStatus.PASS, "Verified Product Detail Page is visible");
        productDetailPage.increaseQuantityTo4();
        extentTest.log(LogStatus.PASS, "Increased quantity to 4");
        productDetailPage.clickAddToCart();
        extentTest.log(LogStatus.PASS, "Clicked add To Cart button");
        productDetailPage.clickOnViewCartButton();
        extentTest.log(LogStatus.PASS, "Clicked on View Cart Button");
        checkoutPage.verifyProduct43isDisplayedInCartPage();
        extentTest.log(LogStatus.PASS, "Verified product 43 is displayed in cart page");

    }
}

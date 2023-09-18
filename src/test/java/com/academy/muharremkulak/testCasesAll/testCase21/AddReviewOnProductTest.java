package com.academy.muharremkulak.testCasesAll.testCase21;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.testng.annotations.Test;

import java.util.Map;

public class AddReviewOnProductTest extends BaseTest {

    private HomePage homePage;
    private AllProductsPage allProductsPage;
    private SignupLoginPage signupLoginPage;
    private CheckoutPage checkoutPage;
    private ProductDetailPage productDetailPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void AddReviewOnProductPageTest(Map<String,String> data) throws InterruptedException {

        extentTest = extentReports.startTest("Add Review On Product Test");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        allProductsPage = new AllProductsPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new All Products page");
        signupLoginPage = new SignupLoginPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Signup/Login page");
        checkoutPage = new CheckoutPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Checkout page");
        productDetailPage = new ProductDetailPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Product Detail page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home Page");
        homePage.verifyHomePageIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Home Page is visible");
        homePage.clickOnProductsButton();
        extentTest.log(LogStatus.PASS, "Clicked on products button");
        allProductsPage.verifyAllProductsPage();
        extentTest.log(LogStatus.PASS, "Verified All Products Page is visible");
        allProductsPage.clickOnViewProductForFirstProduct();
        extentTest.log(LogStatus.PASS, "Clicked view cart on first product button");
        productDetailPage.verifyWriteYourReviewHeaderIsVisible();
        extentTest.log(LogStatus.PASS, "Verified 'Write your review' is visible");
        productDetailPage.enterNameEmailAndReview(data);
        extentTest.log(LogStatus.PASS, "Entered Name and Email for review");
        productDetailPage.clickSubmit();
        extentTest.log(LogStatus.PASS, "Clicked submit");
        productDetailPage.verifyThankYouForReviewMessage();
        extentTest.log(LogStatus.PASS, "Verified 'Thank You For Your Review' is visible");
    }
}

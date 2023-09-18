package com.academy.muharremkulak.testCasesAll.testCase17;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.AllProductsPage;
import com.academy.muharremkulak.pages.CheckoutPage;
import com.academy.muharremkulak.pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class RemoveProductsFromCartTest extends BaseTest {

    private HomePage homePage;
    private AllProductsPage allProductsPage;
    private CheckoutPage checkoutPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void RemoveProductsFromCartTest(Map<String,String> data) throws InterruptedException {

        extentTest = extentReports.startTest("Remove Products From Cart Test");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        allProductsPage = new AllProductsPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated all product page");
        checkoutPage = new CheckoutPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated checkout page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home Page");
        homePage.verifyHomePageIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Home Page is visible");
        homePage.clickOnProductsButton();
        extentTest.log(LogStatus.PASS, "Clicked on products button");
        allProductsPage.hoverOverFirstProductAndClickAddToCart();
        extentTest.log(LogStatus.PASS, "Hover Over first product and clicked add to cart");
        allProductsPage.clickContinueShoppingButton();
        extentTest.log(LogStatus.PASS, "Clicked on continue shopping button");
        homePage.clickOnCartButton();
        extentTest.log(LogStatus.PASS, "Clicked on cart button");
        checkoutPage.verifyCartPageDisplayed();
        extentTest.log(LogStatus.PASS, "Verified cart page is displayed");
        checkoutPage.removeProductFromTheCart();
        extentTest.log(LogStatus.PASS, "Removed product from the cart");
        checkoutPage.verifyProductIsRemovedFromTheCart();
        extentTest.log(LogStatus.PASS, "Verified cart is empty!");

    }
}

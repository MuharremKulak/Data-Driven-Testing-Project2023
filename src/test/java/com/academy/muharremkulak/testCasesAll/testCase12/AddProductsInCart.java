package com.academy.muharremkulak.testCasesAll.testCase12;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.AllProductsPage;
import com.academy.muharremkulak.pages.CheckoutPage;
import com.academy.muharremkulak.pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class AddProductsInCart extends BaseTest {

    private HomePage homePage;
    private AllProductsPage allProductsPage;
    private CheckoutPage checkoutPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void AddProductsInCartTest(Map<String,String> data) throws InterruptedException {

        extentTest = extentReports.startTest("Add Products In Cart Page Test");

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
        allProductsPage.hoverOverSecondProductAndClickAddToCart();
        extentTest.log(LogStatus.PASS, "Hover Over second product and clicked add to cart");
        allProductsPage.clickOnViewCartButton();
        extentTest.log(LogStatus.PASS, "Clicked on view cart button");
        checkoutPage.verifyBothProductsAreAddedToCart();
        extentTest.log(LogStatus.PASS, "Verified both products are added to cart");
        checkoutPage.verifyFirstProductPriceQuantityAndTotalPrice();
        extentTest.log(LogStatus.PASS, "Verified first product's price, quantity and total price");
        checkoutPage.verifySecondProductPriceQuantityAndTotalPrice();
        extentTest.log(LogStatus.PASS, "Verified second product's price, quantity and total price");
    }
}

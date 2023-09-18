package com.academy.muharremkulak.testCasesAll.testCase20;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.AllProductsPage;
import com.academy.muharremkulak.pages.CheckoutPage;
import com.academy.muharremkulak.pages.HomePage;
import com.academy.muharremkulak.pages.SignupLoginPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class SearchProductsAndVerifyCartAfterLoginTest extends BaseTest {

    private HomePage homePage;
    private AllProductsPage allProductsPage;
    private SignupLoginPage signupLoginPage;
    private CheckoutPage checkoutPage;



    @Test(dataProvider = "CustomerAccountInformation")
    public void SearchProductsAndVerifyCartAfterLoginPageTest(Map<String,String> data) throws InterruptedException {

        extentTest = extentReports.startTest("Search Products And Verify Cart After Login");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        allProductsPage = new AllProductsPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new All Products page");
        signupLoginPage = new SignupLoginPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Signup/Login page");
        checkoutPage = new CheckoutPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Checkout page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home Page");
        homePage.verifyHomePageIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Home Page is visible");
        homePage.clickOnProductsButton();
        extentTest.log(LogStatus.PASS, "Clicked on products button");
        allProductsPage.verifyAllProductsPage();
        extentTest.log(LogStatus.PASS, "Verified All Products Page is visible");
        allProductsPage.enterProductNameInSearchBoxAndClickSearchButton();
        extentTest.log(LogStatus.PASS, "Entered product name and clicked search button");
        allProductsPage.verifySearchedProductsIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Searched Products header is visible");
        allProductsPage.addMenTShirtToCart();
        extentTest.log(LogStatus.PASS, "Added men t-shirt to cart");
        allProductsPage.clickOnViewCartButtonForMenTShirt();
        extentTest.log(LogStatus.PASS, "Clicked on view cart button");
        allProductsPage.verifyProductIsVisibleInCart();
        extentTest.log(LogStatus.PASS, "Verified product is visible in cart");
        homePage.clickOnSignupLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked on signup/login button");
        signupLoginPage.enterLoginCorrectInformation(data);
        extentTest.log(LogStatus.PASS, "Entered information to login");
        homePage.clickOnCartButton();
        extentTest.log(LogStatus.PASS, "Clicked on Cart button");
        checkoutPage.verifyMenTShirtHeader();
        extentTest.log(LogStatus.PASS, "Verified Men T-Shirt Header");

    }
}

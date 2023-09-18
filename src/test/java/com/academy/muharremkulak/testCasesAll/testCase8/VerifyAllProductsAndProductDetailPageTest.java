package com.academy.muharremkulak.testCasesAll.testCase8;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class VerifyAllProductsAndProductDetailPageTest extends BaseTest {

    private HomePage homePage;
    private SignupLoginPage signupLoginPage;
    private TestCasesPage testCasesPage;
    private AllProductsPage allProductsPage;
    private ProductDetailPage productDetailPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void VerifyAllProductsAndProductDetailPage(Map<String, String> data) throws InterruptedException {

        extentTest = extentReports.startTest("Verify Test Cases Page Test");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        signupLoginPage = new SignupLoginPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Signup Login page");
        testCasesPage = new TestCasesPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Test Cases page");
        allProductsPage = new AllProductsPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new All Products page");
        productDetailPage = new ProductDetailPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Product detail page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home Page");
        homePage.verifyHomePageIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Home Page is visible");
        homePage.clickOnProductsButton();
        extentTest.log(LogStatus.PASS, "Clicked Products button");
        allProductsPage.verifyAllProductsPage();
        extentTest.log(LogStatus.PASS, "Verified All Products Page is visible");
        allProductsPage.clickOnViewProductOfFirstProduct();
        extentTest.log(LogStatus.PASS, "Clicked on view product of first product");
        allProductsPage.verifyProductDetails();
        extentTest.log(LogStatus.PASS, "Verified Product Details Page");
    }
}
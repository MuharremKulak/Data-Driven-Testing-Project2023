package com.academy.muharremkulak.testCasesAll.testCase9;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class SearchProductTest extends BaseTest {

    private HomePage homePage;
    private SignupLoginPage signupLoginPage;
    private TestCasesPage testCasesPage;
    private AllProductsPage allProductsPage;
    private ProductDetailPage productDetailPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void SearchProductTest(Map<String, String> data) throws InterruptedException {

        extentTest = extentReports.startTest("Search Product Test");

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
        allProductsPage.enterProductNameAndSearch();
        extentTest.log(LogStatus.PASS, "Entered Product name and searched");
        allProductsPage.verifySearchProductsHeader();
        extentTest.log(LogStatus.PASS, "Verified searched products is visible");

    }
}
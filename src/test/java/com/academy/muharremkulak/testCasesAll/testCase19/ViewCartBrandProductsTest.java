package com.academy.muharremkulak.testCasesAll.testCase19;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.AllProductsPage;
import com.academy.muharremkulak.pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class ViewCartBrandProductsTest extends BaseTest {

    private HomePage homePage;
    private AllProductsPage allProductsPage;

    @Test
    public void viewCartBrandProductsPageTest() throws InterruptedException {

        extentTest = extentReports.startTest("View Cart Brand Products");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        allProductsPage = new AllProductsPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new All Products page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home Page");
        homePage.verifyHomePageIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Home Page is visible");
        homePage.clickOnProductsButton();
        extentTest.log(LogStatus.PASS, "Clicked on products button");
        allProductsPage.verifyBrandsHeader();
        extentTest.log(LogStatus.PASS, "Verified Brands Header");
        allProductsPage.verifyAllCategoriesUnderBrands();
        extentTest.log(LogStatus.PASS, "Verified all categories under brands option");
        allProductsPage.clickOnPoloOptionUnderBrands();
        extentTest.log(LogStatus.PASS, "Clicked on Polo button");
        allProductsPage.verifyBrandPageIsDisplayed();
        extentTest.log(LogStatus.PASS, "Verified brand page is displayed");
        allProductsPage.clickOnHandM();
        extentTest.log(LogStatus.PASS, "Clicked on H&M button");
        allProductsPage.verifyHMBrandHeader();
        extentTest.log(LogStatus.PASS, "Verified H&M Brand Header");

    }
}

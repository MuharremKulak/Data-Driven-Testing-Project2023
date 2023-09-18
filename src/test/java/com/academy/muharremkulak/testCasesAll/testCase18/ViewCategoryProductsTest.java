package com.academy.muharremkulak.testCasesAll.testCase18;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.AllProductsPage;
import com.academy.muharremkulak.pages.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class ViewCategoryProductsTest extends BaseTest {

    private HomePage homePage;
    private AllProductsPage allProductsPage;


    @Test
    public void ViewCategoryProductsPageTest() throws InterruptedException {

        extentTest = extentReports.startTest("View Category Products Test");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        allProductsPage = new AllProductsPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated All products page");


        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home Page");
        homePage.verifyHomePageIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Home Page is visible");
        homePage.verifyCategoryOnTheLeftSideOfPage();
        extentTest.log(LogStatus.PASS, "Verified Category header is visible");
        homePage.clickWomenCategoryOption();
        extentTest.log(LogStatus.PASS, "Clicked on Women Category option on the left side");
        homePage.clickOnDressOptionUnderWomenCategory();
        extentTest.log(LogStatus.PASS, "Clicked on dress option under Women Category option on the left side");
        allProductsPage.verifyWomenDressProductsHeader();
        extentTest.log(LogStatus.PASS, "Verified Category header is visible");
        allProductsPage.clickOnMenCategory();
        extentTest.log(LogStatus.PASS, "Clicked on Men Category option on the left side");
        allProductsPage.clickJeansOptionUnderMenCategory();
        extentTest.log(LogStatus.PASS, "Clicked Jeans option under Men Category option on the left side");
        allProductsPage.verifyMenJeansProductsHeader();
        extentTest.log(LogStatus.PASS, "Verified Men Jeans Products Header");
    }
}

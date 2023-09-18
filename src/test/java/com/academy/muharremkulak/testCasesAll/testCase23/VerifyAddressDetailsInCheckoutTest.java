package com.academy.muharremkulak.testCasesAll.testCase23;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class VerifyAddressDetailsInCheckoutTest extends BaseTest {

    private HomePage homePage;
    private CheckoutPage checkoutPage;
    private SignupLoginPage signupLoginPage;
    private SignupPage signupPage;
    private AccountCreatedPage accountCreatedPage;
    private AllProductsPage allProductsPage;



    @Test(dataProvider = "CustomerAccountInformation")
    public void verifyAddressDetailsInCheckoutPageTest(Map<String,String> data) throws InterruptedException {

        extentTest = extentReports.startTest("Verify address details in checkout page");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        checkoutPage = new CheckoutPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Checkout page");
        signupLoginPage = new SignupLoginPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Signup/Login page");
        signupPage = new SignupPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Signup page");
        accountCreatedPage = new AccountCreatedPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Account Created Page");
        allProductsPage = new AllProductsPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new All Products Page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home Page");
        homePage.verifyHomePageIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Home Page is visible");
        homePage.clickOnSignupLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked on Signup/Login button");
        signupLoginPage.enterNameAndEmailForSignup(data);
        extentTest.log(LogStatus.PASS, "Entered Name and Email for Signup");
        signupLoginPage.clickOnSignupButton();
        extentTest.log(LogStatus.PASS, "Clicked on Signup button");
        signupPage.chooseMrOrMrs();
        extentTest.log(LogStatus.PASS, "Chosen Mr or Mrs option");
        signupPage.enterPassword(data);
        extentTest.log(LogStatus.PASS, "Entered password for creating account");
        signupPage.chooseDateOfBirth();
        extentTest.log(LogStatus.PASS, "Chosen date of birth");
        signupPage.clickOnSignupForOurNewsletterBox();
        extentTest.log(LogStatus.PASS, "Clicked on signup for our newsletter box");
        signupPage.clickOnReceiveSpecialOffersFromOurPartners();
        extentTest.log(LogStatus.PASS, "Clicked on receive special offers from our partners box");
        signupPage.enterFirstNameAndLastNameForRegister(data);
        extentTest.log(LogStatus.PASS, "Entered firstname and lastname for creating account");
        signupPage.enterCompanyForRegister(data);
        extentTest.log(LogStatus.PASS, "Entered company name for creating account");
        signupPage.enterAddressInformationForRegister(data);
        extentTest.log(LogStatus.PASS, "Entered address information for register");
        signupPage.enterMobileNumberInformationForRegister(data);
        extentTest.log(LogStatus.PASS, "Entered mobile number information for register");
        signupPage.clickCreateAccountButton();
        extentTest.log(LogStatus.PASS, "Clicked on Create Account Button");
        accountCreatedPage.verifyAccountCreatedHeader();
        extentTest.log(LogStatus.PASS, "Verified Account Created Header is visible");
        accountCreatedPage.clickOnContinueButton();
        extentTest.log(LogStatus.PASS, "Clicked on continue button");
        accountCreatedPage.verifyLoggedInAsUsername(data);
        extentTest.log(LogStatus.PASS, "Verified Logged in as username");
        homePage.clickWomenCategoryOption();
        extentTest.log(LogStatus.PASS, "Clicked on Women Category option");
        homePage.clickOnDressOptionUnderWomenCategory();
        extentTest.log(LogStatus.PASS, "Clicked on dress option under women category");
        allProductsPage.clickOnSleevelessDress();
        extentTest.log(LogStatus.PASS, "Clicked on product to add to cart");
        homePage.clickOnCartButton();
        extentTest.log(LogStatus.PASS, "Clicked on cart button");
        checkoutPage.verifyCartPageDisplayed();
        extentTest.log(LogStatus.PASS, "Verified cart page is displayed");
        checkoutPage.clickProceedToCheckout();
        extentTest.log(LogStatus.PASS, "Clicked proceed to checkout");
        checkoutPage.verifyAddressDetailsAndReviewYourOrder();
        extentTest.log(LogStatus.PASS, "Verified address details and review your order");
        checkoutPage.verifyDeliveryAddressIsSameRegisteredAddress(data);
        extentTest.log(LogStatus.PASS, "Verified delivery address is the same registered address");
        checkoutPage.verifyBillingAddressIsSameRegisteredAddress(data);
        extentTest.log(LogStatus.PASS, "Verified Billing Address is the same registered address");
        checkoutPage.clickOnDeleteAccountButton();
        extentTest.log(LogStatus.PASS, "Clicked on Delete Account Button");
        accountCreatedPage.verifyAccountDeletedHeader();
        extentTest.log(LogStatus.PASS, "Verified Account Delete Header");
        accountCreatedPage.clickContinueAfterDeletedAccount();
        extentTest.log(LogStatus.PASS, "Clicked on Continue button after deleted account");

    }
}

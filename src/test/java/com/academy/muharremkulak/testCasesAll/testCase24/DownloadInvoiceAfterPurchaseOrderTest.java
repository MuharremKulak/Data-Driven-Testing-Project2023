package com.academy.muharremkulak.testCasesAll.testCase24;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import java.util.Map;

public class DownloadInvoiceAfterPurchaseOrderTest extends BaseTest {

    private HomePage homePage;
    private SignupLoginPage signupLoginPage;
    private SignupPage signupPage;
    private AccountCreatedPage accountCreatedPage;
    private CheckoutPage checkoutPage;
    private AllProductsPage allProductsPage;
    private PaymentPage paymentPage;
    private OrderPlacedPage orderPlacedPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void DownloadInvoiceAfterPurchaseOrderPageTest(Map<String, String> data) throws InterruptedException {

        extentTest = extentReports.startTest("Download Invoice After Purchase Order");

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
        paymentPage = new PaymentPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Payment Page");
        orderPlacedPage = new OrderPlacedPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Order Placed Page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home Page");
        homePage.verifyHomePageIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Home Page is visible");
        homePage.clickWomenCategoryOption();
        extentTest.log(LogStatus.PASS, "Clicked Women Category option");
        homePage.clickOnDressOptionUnderWomenCategory();
        extentTest.log(LogStatus.PASS, "Clicked dress option under women category");
        allProductsPage.clickOnSleevelessDress();
        extentTest.log(LogStatus.PASS, "Clicked on Sleeve dress option");
        allProductsPage.clickOnViewCartButton();
        extentTest.log(LogStatus.PASS, "Clicked on view cart button");
        checkoutPage.verifyCartPageDisplayed();
        extentTest.log(LogStatus.PASS, "Verified Cart page is displayed");
        checkoutPage.clickProceedToCheckout();
        extentTest.log(LogStatus.PASS, "Clicked proceed to checkout");
        checkoutPage.clickOnRegisterLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked on register login button");
        signupLoginPage.enterNameAndEmailForSignup(data);
        extentTest.log(LogStatus.PASS, "Entered name and email for signup");
        signupLoginPage.clickOnSignupButton();
        extentTest.log(LogStatus.PASS, "Clicked on signup button");
        signupPage.chooseMrOrMrs();
        extentTest.log(LogStatus.PASS, "Chosen Mr or Mrs");
        signupPage.enterPassword(data);
        extentTest.log(LogStatus.PASS, "Entered Password");
        signupPage.chooseDateOfBirth();
        extentTest.log(LogStatus.PASS, "Chosen date of birth");
        signupPage.clickOnSignupForOurNewsletterBox();
        extentTest.log(LogStatus.PASS, "Clicked on signup for our newsletter box");
        signupPage.clickOnReceiveSpecialOffersFromOurPartners();
        extentTest.log(LogStatus.PASS, "Clicked on receive special offers from our partners");
        signupPage.enterFirstNameAndLastNameForRegister(data);
        extentTest.log(LogStatus.PASS, "Entered first name and last name for register");
        signupPage.enterCompanyForRegister(data);
        extentTest.log(LogStatus.PASS, "Entered company for register");
        signupPage.enterAddressInformationForRegister(data);
        extentTest.log(LogStatus.PASS, "Entered Address Information For Register");
        signupPage.enterMobileNumberInformationForRegister(data);
        extentTest.log(LogStatus.PASS, "Entered mobile number information for register");
        signupPage.clickCreateAccountButton();
        extentTest.log(LogStatus.PASS, "Clicked create account button");
        accountCreatedPage.verifyAccountCreatedHeader();
        extentTest.log(LogStatus.PASS, "Verified account created header");
        accountCreatedPage.clickOnContinueButton();
        extentTest.log(LogStatus.PASS, "Clicked on continue button");
        homePage.verifyLoggedInAsUsernameAtTop(data);
        extentTest.log(LogStatus.PASS, "Verified logged in as username");
        homePage.clickOnCartButton();
        extentTest.log(LogStatus.PASS, "Clicked on cart button");
        checkoutPage.clickProceedToCheckout();
        extentTest.log(LogStatus.PASS, "Clicked proceed to checkout");
        checkoutPage.verifyDeliveryAddressIsSameRegisteredAddress(data);
        extentTest.log(LogStatus.PASS, "Verified delivery address is same registered address");
        checkoutPage.verifyBillingAddressIsSameRegisteredAddress(data);
        extentTest.log(LogStatus.PASS, "Verified billing address is same registered address");
        checkoutPage.enterDescriptionInCommentTextArea();
        extentTest.log(LogStatus.PASS, "Entered Description in comment text area");
        checkoutPage.clickOnPlaceOrderButton();
        extentTest.log(LogStatus.PASS, "Clicked on place order button");
        paymentPage.enterPaymentDetails(data);
        extentTest.log(LogStatus.PASS, "Entered payment details");
        paymentPage.clickOnPayAndConfirmButton();
        extentTest.log(LogStatus.PASS, "Clicked on pay and confirm button");
        orderPlacedPage.verifySuccessMessage();
        extentTest.log(LogStatus.PASS, "Verified success message");
        orderPlacedPage.clickOnDownloadInvoiceButton();
        extentTest.log(LogStatus.PASS, "Clicked on download invoice button");
        orderPlacedPage.verifyInvoiceIsDownloadedSuccessfully();
        extentTest.log(LogStatus.PASS, "Verified invoice is downloaded successfully");
        orderPlacedPage.clickOnContinueButton();
        extentTest.log(LogStatus.PASS, "Clicked on continue button");
        checkoutPage.clickOnDeleteAccountButton();
        extentTest.log(LogStatus.PASS, "Clicked on delete account button");
        accountCreatedPage.verifyAccountDeletedHeader();
        extentTest.log(LogStatus.PASS, "Verified account deleted header");
        accountCreatedPage.clickContinueAfterDeletedAccount();
        extentTest.log(LogStatus.PASS, "Clicked on continue button after deleted account");
    }

}

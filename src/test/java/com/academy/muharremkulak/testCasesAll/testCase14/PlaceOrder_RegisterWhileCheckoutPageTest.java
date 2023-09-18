package com.academy.muharremkulak.testCasesAll.testCase14;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import java.util.Map;

public class PlaceOrder_RegisterWhileCheckoutPageTest extends BaseTest {

    private HomePage homePage;
    private ProductDetailPage productDetailPage;
    private CheckoutPage checkoutPage;
    private SignupLoginPage signupLoginPage;
    private SignupPage signupPage;
    private AccountCreatedPage accountCreatedPage;
    private PaymentPage paymentPage;
    private OrderPlacedPage orderPlacedPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void PlaceOrder_RegisterWhileCheckoutPageTest(Map<String, String> data) throws InterruptedException {

        extentTest = extentReports.startTest("Place Order: Register While Checkout Test");

        homePage = new HomePage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated new Home page");
        productDetailPage = new ProductDetailPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated product detail page");
        checkoutPage = new CheckoutPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Checkout page");
        signupLoginPage = new SignupLoginPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Signup Login page");
        signupPage = new SignupPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Signup page");
        accountCreatedPage = new AccountCreatedPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Account Created Page");
        paymentPage = new PaymentPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Payment page");
        orderPlacedPage = new OrderPlacedPage(driver);
        extentTest.log(LogStatus.INFO, "Instantiated Order Placed Page");

        homePage.navigateToHomePage();
        extentTest.log(LogStatus.INFO, "Navigated to Home Page");
        homePage.verifyHomePageIsVisible();
        extentTest.log(LogStatus.PASS, "Verified Home Page is visible");
        homePage.clickViewProductForAnyProduct();
        extentTest.log(LogStatus.PASS, "Clicked view product button");
        productDetailPage.verifyProductDetailPageTitle();
        extentTest.log(LogStatus.PASS, "Verified Product Detail Page is visible");
        productDetailPage.increaseQuantityTo4();
        extentTest.log(LogStatus.PASS, "Increased quantity to 4");
        productDetailPage.clickAddToCart();
        extentTest.log(LogStatus.PASS, "Clicked add To Cart button");
        productDetailPage.clickOnViewCartButton();
        extentTest.log(LogStatus.PASS, "Clicked on View Cart Button");
        checkoutPage.verifyProduct43isDisplayedInCartPage();
        extentTest.log(LogStatus.PASS, "Verified product 43 is displayed in cart page");
        checkoutPage.clickProceedToCheckout();
        extentTest.log(LogStatus.PASS, "Clicked proceed to checkout Button");
        checkoutPage.clickOnRegisterLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked Register/Login Button");

        signupLoginPage.enterNameAndEmailForSignup(data);
        extentTest.log(LogStatus.PASS, "Entered Name and Email for Signup");
        signupLoginPage.clickOnSignupButton();
        extentTest.log(LogStatus.PASS, "Clicked Signup Button");
        signupPage.chooseMrOrMrs();
        extentTest.log(LogStatus.PASS, "Chosen Mr. or Mrs.");
        signupPage.enterPassword(data);
        extentTest.log(LogStatus.PASS, "Entered Password");
        signupPage.chooseDateOfBirth();
        extentTest.log(LogStatus.PASS, "Chosen DOB");
        signupPage.clickOnSignupForOurNewsletterBox();
        extentTest.log(LogStatus.PASS, "Clicked Signup for our newsletter box");
        signupPage.clickOnReceiveSpecialOffersFromOurPartners();
        extentTest.log(LogStatus.PASS, "Clicked on receive special offers from our partners box");
        signupPage.enterFirstNameAndLastNameForRegister(data);
        extentTest.log(LogStatus.PASS, "Entered first name and last name for register");
        signupPage.enterCompanyForRegister(data);
        extentTest.log(LogStatus.PASS, "Entered company for register");
        signupPage.enterAddressInformationForRegister(data);
        extentTest.log(LogStatus.PASS, "Entered address information for register");
        signupPage.enterMobileNumberInformationForRegister(data);
        extentTest.log(LogStatus.PASS, "Entered Mobile number for information register");
        signupPage.clickCreateAccountButton();
        extentTest.log(LogStatus.PASS, "Clicked create account button");
        accountCreatedPage.verifyAccountCreatedHeader();
        extentTest.log(LogStatus.PASS, "Verified account created header");
        accountCreatedPage.clickOnContinueButton();
        extentTest.log(LogStatus.PASS, "Clicked continue button");
        homePage.verifyLoggedInAsUsernameAtTop(data);
        extentTest.log(LogStatus.PASS, "Verified logged in as username at top");
        homePage.clickOnCartButton();
        extentTest.log(LogStatus.PASS, "Clicked on the cart button");
        checkoutPage.clickProceedToCheckout();
        extentTest.log(LogStatus.PASS, "Clicked proceed to checkout");
        checkoutPage.verifyAddressDetailsAndReviewYourOrder();
        extentTest.log(LogStatus.PASS, "Verified address details and review your order");
        checkoutPage.enterDescriptionInCommentTextArea();
        extentTest.log(LogStatus.PASS, "Entered description in comment text area");
        checkoutPage.clickOnPlaceOrderButton();
        extentTest.log(LogStatus.PASS, "Clicked on place order button");
        paymentPage.verifyPaymentPage();
        extentTest.log(LogStatus.PASS, "Verified Payment Page");
        paymentPage.enterPaymentDetails(data);
        extentTest.log(LogStatus.PASS, "Entered Payment Details");
        paymentPage.clickOnPayAndConfirmButton();
        extentTest.log(LogStatus.PASS, "Clicked on Pay and Confirm button");
        orderPlacedPage.verifySuccessMessage();
        extentTest.log(LogStatus.PASS, "Verified Success Message");
        orderPlacedPage.clickOnDeleteAccountButton();
        extentTest.log(LogStatus.PASS, "Clicked on delete account button");
        accountCreatedPage.verifyAccountDeleted();
        extentTest.log(LogStatus.PASS, "Verified account deleted");
        accountCreatedPage.clickOnContinueButton();
        extentTest.log(LogStatus.PASS, "Clicked on continue button");
    }
}

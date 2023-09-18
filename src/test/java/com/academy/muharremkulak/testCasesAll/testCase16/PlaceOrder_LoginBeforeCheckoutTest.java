package com.academy.muharremkulak.testCasesAll.testCase16;

import com.academy.muharremkulak.baseTest.BaseTest;
import com.academy.muharremkulak.pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.Map;

public class PlaceOrder_LoginBeforeCheckoutTest extends BaseTest {

    private HomePage homePage;
    private ProductDetailPage productDetailPage;
    private CheckoutPage checkoutPage;
    private SignupLoginPage signupLoginPage;
    private SignupPage signupPage;
    private AccountCreatedPage accountCreatedPage;
    private PaymentPage paymentPage;
    private OrderPlacedPage orderPlacedPage;


    @Test(dataProvider = "CustomerAccountInformation")
    public void PlaceOrder_RegisterBeforeCheckoutPageTest(Map<String, String> data) throws InterruptedException {

        extentTest = extentReports.startTest("Place Order: Login Before Checkout Test");

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
        homePage.clickOnSignupLoginButton();
        extentTest.log(LogStatus.PASS, "Clicked on signup login button");
        signupLoginPage.enterLoginCorrectInformation(data);
        extentTest.log(LogStatus.PASS, "Entered login information");
        homePage.verifyLoggedInAsUsernameAtTop(data);
        extentTest.log(LogStatus.PASS, "Verified Logged in as username at top");
        homePage.addProduct3ToCart();
        extentTest.log(LogStatus.PASS, "Added product 3 to cart");
        homePage.clickOnCartButtonAfterChosenThirdProduct();
        extentTest.log(LogStatus.PASS, "Clicked on cart button after chosen third product");
        checkoutPage.verifyCartPageIsDisplayed();
        extentTest.log(LogStatus.PASS, "Verified cart page is displayed");
        checkoutPage.clickProceedToCheckout();
        extentTest.log(LogStatus.PASS, "Clicked on proceed to checkout");
        checkoutPage.verifyAddressDetailsAndReviewYourOrder();
        extentTest.log(LogStatus.PASS, "Verified address details and reviewed your order");
        checkoutPage.enterDescriptionInCommentTextArea();
        extentTest.log(LogStatus.PASS, "Entered description in comment text area");
        checkoutPage.clickOnPlaceOrderButton();
        extentTest.log(LogStatus.PASS, "Clicked on place order button");
        paymentPage.enterPaymentDetails(data);
        extentTest.log(LogStatus.PASS, "Entered payment details");
        paymentPage.clickOnPayAndConfirmButton();
        extentTest.log(LogStatus.PASS, "Clicked pay and confirm button");
        orderPlacedPage.verifySuccessMessage();
        extentTest.log(LogStatus.PASS, "Verified success message");
        orderPlacedPage.clickOnDeleteAccountButton();
        extentTest.log(LogStatus.PASS, "Clicked on delete account button");
        accountCreatedPage.clickContinueAfterDeletedAccount();
        extentTest.log(LogStatus.PASS, "Clicked on continue after deleted account");
    }
}
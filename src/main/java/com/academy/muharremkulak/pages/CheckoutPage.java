package com.academy.muharremkulak.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Map;

public class CheckoutPage {

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@class='single-widget']/h2")
    public WebElement subscriptionHeader;
    @FindBy(id = "susbscribe_email")
    public WebElement emailInputForSubscription;
    @FindBy(id = "subscribe")
    public WebElement arrowButton;
    @FindBy(id = "success-subscribe")
    public WebElement successMessage;
    @FindBy(xpath = "//tr[@id='product-1']/td[2]/h4/a")
    public WebElement blueTopFirstProductForVerification;
    @FindBy(xpath = "//tr[@id='product-2']/td[2]/h4/a")
    public WebElement menTShirtSecondProductForVerification;
    @FindBy(xpath = "//tr[@id='product-1']/td[3]/p")
    public WebElement firstProductPrice;
    @FindBy(xpath = "//tr[@id='product-2']/td[3]/p")
    public WebElement secondProductPrice;
    @FindBy(xpath = "//tr[@id='product-1']/td[4]/button")
    public WebElement firstProductQuantity;
    @FindBy(xpath = "//tr[@id='product-2']/td[4]/button")
    public WebElement secondProductQuantity;
    @FindBy(xpath = "//tr[@id='product-1']/td[5]/p")
    public WebElement firstProductTotalPrice;
    @FindBy(xpath = "//tr[@id='product-2']/td[5]/p")
    public WebElement secondProductTotalPrice;
    @FindBy(xpath = "//tr[@id='product-43']/td[2]/h4/a")
    public WebElement product43name;
    @FindBy(xpath = "//tr[@id='product-43']/td[3]/p")
    public WebElement product43Price;
    @FindBy(xpath = "//tr[@id='product-43']/td[4]/button")
    public WebElement product43Quantity;
    @FindBy(xpath = "//tr[@id='product-43']/td[5]/p")
    public WebElement product43TotalPrice;
    @FindBy(xpath = "//section[@id='do_action']/div[1]/div/div/a")
    public WebElement proceedToCheckoutButton;
    @FindBy(xpath = "(//a[@href='/login'])[2]")
    public WebElement registerLoginButton;
    @FindBy(xpath = "//ul[@id='address_delivery']/li/h3")
    public WebElement yourDeliveryAddressHeader;
    @FindBy(xpath = "//div[@class='step-one']/h2")
    public WebElement reviewYourOrderHeader;
    @FindBy(xpath = "//div[@id='ordermsg']/textarea")
    public WebElement commentBoxInput;
    @FindBy(xpath = "//a[@href='/payment']")
    public WebElement placeOrderButton;
    @FindBy(xpath = "//a[@href='/product_details/3']")
    public WebElement sleevelessDressHeader;
    @FindBy(xpath = "//a[@class='cart_quantity_delete']")
    public WebElement deleteOptionForProduct;
    @FindBy(xpath = "//span[@id='empty_cart']/p/b")
    public WebElement cartIsEmptyLocator;
    @FindBy(xpath = "//section[@id='cart_items']/div/div/ol/li[2]")
    public WebElement shoppingCartHeader;
    @FindBy(xpath = "//tr[@id='product-2']/td[2]/h4/a")
    public WebElement menTShirtHeader;
    @FindBy(xpath = "//ul[@id='address_delivery']/li[4]")
    public WebElement deliveryAddress;
    @FindBy(xpath = "//ul[@id='address_invoice']/li[4]")
    public WebElement billingAddress;
    @FindBy(xpath = "//a[@href='/delete_account']")
    public WebElement deleteAccountButton;

    public void scrollAllTheWayDownToSubscriptionBox() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void verifySubscriptionHeaderForCheckoutPage() {
        String actualHeader = subscriptionHeader.getText();
        String expectedHeader = "SUBSCRIPTION";
        Assert.assertEquals(actualHeader, expectedHeader);
    }

    public void enterEmailForSubscriptionAndClick(Map<String, String> data) {
        emailInputForSubscription.sendKeys(data.get("SubscriptionEmail"));
        arrowButton.click();
    }

    public void verifySuccessMessage() {
        String actualMessage = successMessage.getText();
        String expectedMessage = "You have been successfully subscribed!";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    public void verifyBothProductsAreAddedToCart() {
        String actualFirstProduct = blueTopFirstProductForVerification.getText();
        String expectedFirstProduct = "Blue Top";
        Assert.assertEquals(actualFirstProduct, expectedFirstProduct);
        //---------------------
        String actualSecondProduct = menTShirtSecondProductForVerification.getText();
        String expectedSecondProduct = "Men Tshirt";
        Assert.assertEquals(actualSecondProduct, expectedSecondProduct);
    }

    public void verifyFirstProductPriceQuantityAndTotalPrice() {
        String actualPrice = firstProductPrice.getText();
        String expectedPrice = "Rs. 500";
        Assert.assertEquals(actualPrice, expectedPrice);
        //----------------
        String actualQuantity = firstProductQuantity.getText();
        String expectedQuantity = "1";
        Assert.assertEquals(actualQuantity, expectedQuantity);
        //----------------
        String actualTotalPrice = firstProductTotalPrice.getText();
        String expectedTotalPrice = "Rs. 500";
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
    }


    public void verifySecondProductPriceQuantityAndTotalPrice() {
        String actualPrice = secondProductPrice.getText();
        String expectedPrice = "Rs. 400";
        Assert.assertEquals(actualPrice, expectedPrice);
        //----------------
        String actualQuantity = secondProductQuantity.getText();
        String expectedQuantity = "1";
        Assert.assertEquals(actualQuantity, expectedQuantity);
        //----------------
        String actualTotalPrice = secondProductTotalPrice.getText();
        String expectedTotalPrice = "Rs. 400";
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
    }


    public void verifyProduct43isDisplayedInCartPage() {
        String actualProduct43Name = product43name.getText();
        String expectedProduct43Name = "GRAPHIC DESIGN MEN T SHIRT - BLUE";
        Assert.assertEquals(actualProduct43Name, expectedProduct43Name);
        //----------------
        String actualPrice = product43Price.getText();
        String expectedPrice = "Rs. 1389";
        Assert.assertEquals(actualPrice, expectedPrice);
        //----------------
        String actualQuantity = product43Quantity.getText();
        String expectedQuantity = "4";
        Assert.assertEquals(actualQuantity, expectedQuantity);
        //----------------
        String actualTotalPrice = product43TotalPrice.getText();
        String expectedTotalPrice = "Rs. 5556";
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
    }

    public void clickProceedToCheckout() {
        proceedToCheckoutButton.click();
    }

    public void clickOnRegisterLoginButton() {
        registerLoginButton.click();
    }

    public void verifyAddressDetailsAndReviewYourOrder() {
        Assert.assertTrue(yourDeliveryAddressHeader.isDisplayed());
        Assert.assertTrue(reviewYourOrderHeader.isDisplayed());
    }

    public void enterDescriptionInCommentTextArea() {
        commentBoxInput.sendKeys("This is Muharrem (Mo). This project is amazing! QA Team is on fire!!!");
    }

    public void clickOnPlaceOrderButton() {
        placeOrderButton.click();
    }

    public void verifyCartPageIsDisplayed() {
        String actualHeader = sleevelessDressHeader.getText();
        String expectedHeader = "Sleeveless Dress";
        Assert.assertEquals(actualHeader, expectedHeader);
    }

    public void removeProductFromTheCart() throws InterruptedException {
        deleteOptionForProduct.click();
        Thread.sleep(2000);
    }

    public void verifyProductIsRemovedFromTheCart() {
        String actualText = cartIsEmptyLocator.getText();
        String expectedText = "Cart is empty!";
        Assert.assertEquals(actualText, expectedText);
    }

    public void verifyCartPageDisplayed() {
        Assert.assertTrue(shoppingCartHeader.isDisplayed());
    }

    public void verifyMenTShirtHeader(){
        Assert.assertTrue(menTShirtHeader.isDisplayed());
    }

    public void verifyDeliveryAddressIsSameRegisteredAddress(Map<String,String> data){
        String actualDeliveryAddress = deliveryAddress.getText();
        String expectedDeliveryAddress = data.get("StreetAddress");
        Assert.assertEquals(actualDeliveryAddress, expectedDeliveryAddress);
    }

    public void verifyBillingAddressIsSameRegisteredAddress(Map<String,String> data){
        String actualBillingAddress = billingAddress.getText();
        String expectedBillingAddress = data.get("StreetAddress");
        Assert.assertEquals(actualBillingAddress, expectedBillingAddress);
    }

    public void clickOnDeleteAccountButton(){
        deleteAccountButton.click();
    }


}


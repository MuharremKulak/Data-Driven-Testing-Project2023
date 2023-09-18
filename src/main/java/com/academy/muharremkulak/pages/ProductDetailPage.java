package com.academy.muharremkulak.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Map;

public class ProductDetailPage {

    private WebDriver driver;

    public ProductDetailPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "quantity")
    public WebElement quantityInputBox;
    @FindBy(xpath = "//div[@class='product-details']/div[2]/div/span/button")
    public WebElement addToCartButton;
    @FindBy(xpath = "(//a[@href='/view_cart'])[2]")
    public WebElement viewCart;
    @FindBy(xpath = "//a[@href='#reviews']")
    public WebElement writeYourReviewHeader;
    @FindBy(id = "name")
    public WebElement nameInputForReview;
    @FindBy(id = "email")
    public WebElement emailInputForReview;
    @FindBy(id = "review")
    public WebElement reviewInputBox;
    @FindBy(id = "button-review")
    public WebElement submitButtonForReview;
    @FindBy(xpath = "//div[@id='review-section']/div/div/span")
    public WebElement thankYouMessage;


    public void verifyProductDetailPageTitle(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Exercise - Product Details";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    public void increaseQuantityTo4() throws InterruptedException {
        quantityInputBox.clear();
        Thread.sleep(2000);
        quantityInputBox.sendKeys("4");
    }

    public void clickAddToCart(){
        addToCartButton.click();
    }

    public void clickOnViewCartButton(){
        viewCart.click();
    }

    public void verifyWriteYourReviewHeaderIsVisible(){
        Assert.assertTrue(writeYourReviewHeader.isDisplayed());
    }

    public void enterNameEmailAndReview(Map<String,String> data) throws InterruptedException {
        nameInputForReview.sendKeys(data.get("FullName"));
        Thread.sleep(1000);
        emailInputForReview.sendKeys(data.get("Email"));
        Thread.sleep(1000);
        reviewInputBox.sendKeys("Product is amazing, hope to have new features to test it :)");
        Thread.sleep(1000);
    }

    public void clickSubmit(){
        submitButtonForReview.click();
    }

    public void verifyThankYouForReviewMessage(){
        Assert.assertTrue(thankYouMessage.isDisplayed());
    }




}


package com.academy.muharremkulak.pages;

import com.academy.muharremkulak.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Map;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement signUpLoginButton;
    @FindBy(xpath = "//a[@href='/contact_us']")
    public WebElement contactUsButton;
    @FindBy(xpath = "//a[@href='/test_cases']/i")
    public WebElement testCasesButton;
    @FindBy(xpath = "//a[@href='/products']/i")
    public WebElement productsButton;
    @FindBy(id = "susbscribe_email")
    public WebElement subscriptionInputBox;
    @FindBy(xpath = "//div[@class='single-widget']/h2")
    public WebElement subscriptionHeader;
    @FindBy(id = "subscribe")
    public WebElement buttonForSubscription;
    @FindBy(xpath = "//div[@class='col-sm-8']/div/ul/li[3]")
    public WebElement cartButton;
    @FindBy(xpath = "//a[@href='/product_details/43']")
    public WebElement viewProductButton;
    @FindBy(xpath = "//header[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b")
    public WebElement firstNameAfterCreatedAccount;
    @FindBy(xpath = "(//a[@data-product-id='3']/i)[1]")
    public WebElement addToCartForThirdProduct;
    @FindBy(xpath = "(//a[@href='/view_cart'])[2]")
    public WebElement viewCartButtonAfterChosenThirdProduct;
    @FindBy(xpath = "//div[@class='left-sidebar']/h2")
    public WebElement categoryHeader;
    @FindBy(xpath = "(//div[@id='accordian']/div/div/h4/a)[1]")
    public WebElement womenCategory;
    @FindBy(xpath = "(//div[@id='Women']/div/ul/li/a)[1]")
    public WebElement dressOption;
    @FindBy(xpath = "//div[@class='recommended_items']/h2")
    public WebElement recommendedItemsHeader;
    @FindBy(xpath = "(//a[@data-product-id='2'])[3]")
    public WebElement menTShirtForRecommendedProduct;
    @FindBy(xpath = "(//a[@href='/view_cart'])[2]")
    public WebElement viewCartButton;
    @FindBy(id = "scrollUp")
    public WebElement scrollUpArrow;
    @FindBy(xpath = "(//div[@class='col-sm-6']/h2)[1]")
    public WebElement fullFledgedPracticeTextArea;


    public void navigateToHomePage(){
        driver.get(ConfigReader.getProperty("url"));
    }

    public void verifyHomePageIsVisible(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    public void clickOnSignupLoginButton(){
        signUpLoginButton.click();
    }

    public void clickOnContactUsButton(){
        contactUsButton.click();
    }

    public void clickOnTestCasesButton() throws InterruptedException {
        testCasesButton.click();
        Thread.sleep(3000);
    }

    public void clickOnProductsButton(){
        productsButton.click();
    }

    public void scrollAllTheWayDown() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(1500);
    }

    public void verifySubscriptionHeader(){
        String actualText = subscriptionHeader.getText();
        String expectedText = "SUBSCRIPTION";
        Assert.assertEquals(actualText, expectedText);
    }

    public void enterEmailForSubscription(Map<String,String> data) throws InterruptedException {
        subscriptionInputBox.sendKeys(data.get("SubscriptionEmail"));
        Thread.sleep(3000);
        buttonForSubscription.click();
    }

    public void clickOnCartButton(){
        cartButton.click();
    }

    public void clickViewProductForAnyProduct(){
        viewProductButton.click();
    }

    public void verifyLoggedInAsUsernameAtTop(Map<String,String> data){
        String actualName = firstNameAfterCreatedAccount.getText();
        String expectedName = data.get("FirstName");
        Assert.assertEquals(actualName, expectedName);
    }

    public void addProduct3ToCart(){
        addToCartForThirdProduct.click();
    }

    public void clickOnCartButtonAfterChosenThirdProduct(){
        viewCartButtonAfterChosenThirdProduct.click();
    }

    public void verifyCategoryOnTheLeftSideOfPage(){
        String actualText = categoryHeader.getText();
        String expectedText = "CATEGORY";
        Assert.assertEquals(actualText, expectedText);
    }

    public void clickWomenCategoryOption() throws InterruptedException {
        womenCategory.click();
        Thread.sleep(1000);
    }

    public void clickOnDressOptionUnderWomenCategory() throws InterruptedException {
        dressOption.click();
        Thread.sleep(2000);
    }

    public void verifyRecommendedItemsAreVisible(){
        Assert.assertTrue(recommendedItemsHeader.isDisplayed());
    }

    public void clickOnAddToCartOnRecommendedProduct(){
        menTShirtForRecommendedProduct.click();
    }

    public void clickOnViewCartButton(){
        viewCartButton.click();
    }

    public void scrollAllTheWayUp() throws InterruptedException {
        scrollUpArrow.click();
        Thread.sleep(2000);
    }

    public void verifyThatPageIsScrollUpAndFullFledgedTextIsVisible(){
        Assert.assertTrue(fullFledgedPracticeTextArea.isDisplayed());
    }

    public void scrollAllTheWayUpWithoutArrow() throws InterruptedException {
        // Create a JavascriptExecutor object
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll to the top of the page
        js.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(2000);
    }



}

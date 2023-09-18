package com.academy.muharremkulak.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;


public class AllProductsPage {

    private WebDriver driver;

    public AllProductsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//a[@href='/product_details/1']")
    public WebElement firstProductViewDetails;
    @FindBy(xpath = "//div[@class='product-information']/h2")
    public WebElement productName;
    @FindBy(xpath = "//div[@class='product-information']/p[1]")
    public WebElement productCategory;
    @FindBy(xpath = "//div[@class='product-information']/span/span")
    public WebElement productPrice;
    @FindBy(xpath = "//div[@class='product-information']/p[2]")
    public WebElement productAvailability;
    @FindBy(xpath = "//div[@class='product-information']/p[3]")
    public WebElement productCondition;
    @FindBy(xpath = "//div[@class='product-information']/p[4]")
    public WebElement productBrand;
    @FindBy(id = "search_product")
    public WebElement searchProductInputBox;
    @FindBy(id = "submit_search")
    public WebElement searchButton;
    @FindBy(xpath = "//div[@class='features_items']/h2")
    public WebElement searchedProductsHeader;
    @FindBy(xpath = "(//a[@data-product-id='1'])[1]")
    public WebElement addToCartButton;
    @FindBy(xpath = "(//div[@class='single-products']/div)[1]")
    public WebElement addToCartButtonForFirstProduct;
    @FindBy(xpath = "(//div[@class='single-products'])[2]")
    public WebElement addToCartButtonForSecondProduct;
    @FindBy(xpath = "//div[@id='cartModal']/div/div/div[3]/button")
    public WebElement continueShoppingButton;
    @FindBy(xpath = "//div[@id='cartModal']/div/div/div[2]/p[2]/a")
    public WebElement viewCartButton;
    @FindBy(xpath = "(//a[@data-product-id='2'])[2]")
    public WebElement addToCartButtonTwo;
    @FindBy(xpath = "//div[@class='features_items']/h2")
    public WebElement womenDressProductsHeader;
    @FindBy(xpath = "//div[@id='accordian']/div[2]/div/h4/a")
    public WebElement menCategoryOption;
    @FindBy(xpath = "//div[@id='Men']/div/ul/li[2]/a")
    public WebElement jeansOptionUnderMenCategory;
    @FindBy(xpath = "//div[@class='features_items']/h2")
    public WebElement menJeansProductsHeader;
    @FindBy(xpath = "//div[@class='brands_products']/h2")
    public WebElement brandsHeader;
    @FindBy(xpath = "(//div[@class='brands-name']/ul/li/a)[1]")
    public WebElement poloOption;
    @FindBy(xpath = "//div[@class='features_items']/h2")
    public WebElement brandPoloProductsHeader;
    @FindBy(xpath = "(//div[@class='brands-name']/ul/li)[2]")
    public WebElement hAndMButton;
    @FindBy(xpath = "//div[@class='features_items']/h2")
    public WebElement hAndMBrandHeader;
    @FindBy(xpath = "(//a[@data-product-id='2'])[2]")
    public WebElement menTShirtAddToCart;
    @FindBy(xpath = "(//a[@href='/view_cart'])[2]")
    public WebElement viewCart;
    @FindBy(xpath = "//tr[@id='product-2']/td[2]/h4/a")
    public WebElement menTShirtHeader;
    @FindBy(xpath = "//a[@href='/product_details/1']")
    public WebElement viewProductButtonForFirstProduct;
    @FindBy(xpath = "(//div[@class='overlay-content'])[1]/a")
    public WebElement addToCartSleevelessDress;



    public void verifyAllProductsPage(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Exercise - All Products";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    public void clickOnViewProductOfFirstProduct(){
        firstProductViewDetails.click();
    }

    public void verifyProductDetails(){
        String actualProductName = productName.getText();
        String expectedProductName = "Blue Top";
        Assert.assertEquals(actualProductName,expectedProductName);
        //---------------
        String actualCategoryName = productCategory.getText();
        String expectedCategoryName = "Category: Women > Tops";
        Assert.assertEquals(actualCategoryName,expectedCategoryName);
        //---------------
        String actualPrice = productPrice.getText();
        String expectedPrice = "Rs. 500";
        Assert.assertEquals(actualPrice, expectedPrice);
        //---------------
        String actualText = productAvailability.getText().trim();
        System.out.println(actualText);
        String expectedText = "Availability: In Stock";
        Assert.assertEquals(actualText, expectedText);
        //---------------
        String actualText1 = productCondition.getText().trim();
        System.out.println(actualText1);
        String expectedText1 = "Condition: New";
        Assert.assertEquals(actualText1, expectedText1);
        //---------------
        String actualText2 = productBrand.getText().trim();
        System.out.println(actualText2);
        String expectedText2 = "Brand: Polo";
        Assert.assertEquals(actualText2, expectedText2);
    }

    public void enterProductNameAndSearch(){
        searchProductInputBox.sendKeys("Men Tshirt");
        searchButton.click();
    }

    public void verifySearchProductsHeader(){
        String actualHeader = searchedProductsHeader.getText();
        String expectedHeader = "SEARCHED PRODUCTS";
        Assert.assertEquals(actualHeader, expectedHeader);
    }

    public void hoverOverFirstProductAndClickAddToCart() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartButtonForFirstProduct).perform();
        addToCartButton.click();
        Thread.sleep(2000);
    }

    public void clickContinueShoppingButton() throws InterruptedException {
        continueShoppingButton.click();
        Thread.sleep(2000);
    }

    public void hoverOverSecondProductAndClickAddToCart() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartButtonForSecondProduct).perform();
        Thread.sleep(2000);
        addToCartButtonTwo.click();
        Thread.sleep(2000);
    }

    public void clickOnViewCartButton() throws InterruptedException {
        viewCartButton.click();
        Thread.sleep(2000);
    }

    public void verifyWomenDressProductsHeader(){
        Assert.assertTrue(womenDressProductsHeader.isDisplayed());
    }

    public void clickOnMenCategory() throws InterruptedException {
        menCategoryOption.click();
        Thread.sleep(2000);
    }

    public void clickJeansOptionUnderMenCategory(){
        jeansOptionUnderMenCategory.click();
    }

    public void verifyMenJeansProductsHeader(){
        Assert.assertTrue(menJeansProductsHeader.isDisplayed());
    }

    public void verifyBrandsHeader(){
        Assert.assertTrue(brandsHeader.isDisplayed());
    }

    public void verifyAllCategoriesUnderBrands(){
        List<WebElement> brandsOptions = driver.findElements(By.xpath("//div[@class='brands-name']/ul/li/a"));
        for (WebElement brandsOption : brandsOptions) {
            Assert.assertTrue(brandsOption.isDisplayed());
        }
    }

    public void clickOnPoloOptionUnderBrands() throws InterruptedException {
        poloOption.click();
        Thread.sleep(2000);
    }

    public void verifyBrandPageIsDisplayed(){
        Assert.assertTrue(brandPoloProductsHeader.isDisplayed());
    }

    public void clickOnHandM() throws InterruptedException {
        hAndMButton.click();
        Thread.sleep(2000);
    }

    public void verifyHMBrandHeader(){
        Assert.assertTrue(hAndMBrandHeader.isDisplayed());
    }

    public void enterProductNameInSearchBoxAndClickSearchButton() throws InterruptedException {
        searchProductInputBox.sendKeys("Men Tshirt");
        Thread.sleep(2000);
        searchButton.click();
        Thread.sleep(1000);
    }

    public void verifySearchedProductsIsVisible(){
        Assert.assertTrue(searchedProductsHeader.isDisplayed());
    }

    public void addMenTShirtToCart() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(menTShirtAddToCart).perform();
        Thread.sleep(1000);
        menTShirtAddToCart.click();
        Thread.sleep(2000);
    }

    public void clickOnViewCartButtonForMenTShirt(){
        viewCart.click();
    }

    public void verifyProductIsVisibleInCart(){
        String actualProductText = menTShirtHeader.getText();
        String expectedProductText = "Men Tshirt";
        Assert.assertEquals(actualProductText, expectedProductText);
    }

    public void clickOnViewProductForFirstProduct(){
        viewProductButtonForFirstProduct.click();
    }

    public void clickOnSleevelessDress() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartSleevelessDress).perform();
        Thread.sleep(1000);
        addToCartSleevelessDress.click();
    }



}

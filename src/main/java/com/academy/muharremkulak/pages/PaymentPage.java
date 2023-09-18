package com.academy.muharremkulak.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Map;

public class PaymentPage {

    private WebDriver driver;


    public PaymentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//input[@data-qa='name-on-card']")
    public WebElement nameInputForPayment;
    @FindBy(xpath = "//input[@data-qa='card-number']")
    public WebElement cardNumberInputForPayment;
    @FindBy(xpath = "//input[@data-qa='cvc']")
    public WebElement cvcInputForPayment;
    @FindBy(xpath = "//input[@data-qa='expiry-month']")
    public WebElement expMonthInputForPayment;
    @FindBy(xpath = "//input[@data-qa='expiry-year']")
    public WebElement expYearInputForPayment;
    @FindBy(id = "submit")
    public WebElement payAndConfirmButton;


    public void verifyPaymentPage(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Exercise - Payment";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    public void enterPaymentDetails(Map<String,String> data){
        nameInputForPayment.sendKeys(data.get("NameOnCard"));
        cardNumberInputForPayment.sendKeys(data.get("CardNumber"));
        cvcInputForPayment.sendKeys(data.get("CVC"));
        expMonthInputForPayment.sendKeys(data.get("ExpMonth"));
        expYearInputForPayment.sendKeys(data.get("ExpYear"));
    }

    public void clickOnPayAndConfirmButton(){
        payAndConfirmButton.click();
    }

}

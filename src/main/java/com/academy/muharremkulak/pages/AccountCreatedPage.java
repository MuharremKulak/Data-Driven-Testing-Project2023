package com.academy.muharremkulak.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Map;

public class AccountCreatedPage {

    private WebDriver driver;

    public AccountCreatedPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//h2[@data-qa='account-created']/b")
    public WebElement accountCreatedHeader;
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueButton;
    @FindBy(xpath = "//li/a/b")
    public WebElement loginUsernameHeader;
    @FindBy(xpath = "//a[@href='/delete_account']")
    public WebElement deleteAccountButton;
    @FindBy(xpath = "//h2[@data-qa='account-deleted']/b")
    public WebElement accountDeletedHeader;
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueButtonForAccountDeleted;
    @FindBy(xpath = "//a[@href='/logout']/i")
    public WebElement logoutButton;
    @FindBy(xpath = "//h2[@data-qa='account-deleted']/b")
    public WebElement deleteAccountHeaderAfterOrder;


    public void verifyAccountCreatedHeader(){
        Assert.assertTrue(accountCreatedHeader.isDisplayed());
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

    public void verifyLoggedInAsUsername(Map<String,String> data){
        String actualUsername = loginUsernameHeader.getText();
        String expectedUsername = data.get("FirstName");
        Assert.assertEquals(actualUsername,expectedUsername);
    }

    public void clickDeleteAccountButton(){
        deleteAccountButton.click();
    }

    public void verifyAccountDeletedHeader(){
        String actualText = accountDeletedHeader.getText();
        String expectedText = "ACCOUNT DELETED!";
        Assert.assertEquals(actualText,expectedText);
    }

    public void clickContinueAfterDeletedAccount(){
        continueButtonForAccountDeleted.click();
    }

    public void clickLogoutButton(){
        logoutButton.click();
    }

    public void verifyAccountDeleted(){
        String actualText = deleteAccountHeaderAfterOrder.getText();
        String expectedText = "ACCOUNT DELETED!";
        Assert.assertEquals(actualText, expectedText);
    }



}

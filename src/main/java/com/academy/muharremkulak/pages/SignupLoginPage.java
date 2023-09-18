package com.academy.muharremkulak.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Map;

public class SignupLoginPage {

    private WebDriver driver;

    public SignupLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@class='signup-form']/h2")
    public WebElement newUserSignUpHeader;
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement nameInputForSignup;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement emailInputForSignup;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signupButton;
    @FindBy(xpath = "//div[@class='login-form']/h2")
    public WebElement loginToYourAccountHeader;
    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement emailInputForLogin;
    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement passwordInputForLogin;
    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButton;
    @FindBy(xpath = "//form[@action='/login']/p")
    public WebElement errorMessageForLogin;
    @FindBy(xpath = "//form[@action='/signup']/p")
    public WebElement errorMessageForSignup;



    public void verifyNewUserSignupHeader(){
        Assert.assertTrue(newUserSignUpHeader.isDisplayed());
    }

    public void enterNameAndEmailForSignup(Map<String,String> data){
        nameInputForSignup.sendKeys(data.get("FirstName"));
        emailInputForSignup.sendKeys(data.get("Email"));
    }

    public void clickOnSignupButton() throws InterruptedException {
        signupButton.click();
        Thread.sleep(3000);
    }

    public void verifyLoginToYourAccountIsVisible(){
        String actualText = loginToYourAccountHeader.getText();
        String expectedText = "Login to your account";
        Assert.assertEquals(actualText,expectedText);
    }

    public void enterLoginIncorrectInformation(Map<String,String> data){
        emailInputForLogin.sendKeys(data.get("Email"));
        passwordInputForLogin.sendKeys(data.get("IncorrectPassword"));
        loginButton.click();
    }

    public void enterLoginCorrectInformation(Map<String,String> data){
        emailInputForLogin.sendKeys(data.get("Email"));
        passwordInputForLogin.sendKeys(data.get("Password"));
        loginButton.click();
    }

    public void verifyErrorMessageIsVisible(){
        String actualErrorMessage = errorMessageForLogin.getText();
        String expectedErrorMessage = "Your email or password is incorrect!";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }

    public void verifyErrorMessageIsVisibleForSignup(){
        String actualErrorMessageForSignup = errorMessageForSignup.getText();
        String expectedErrorMessageForSignup = "Email Address already exist!";
        Assert.assertEquals(actualErrorMessageForSignup,expectedErrorMessageForSignup);
    }


}

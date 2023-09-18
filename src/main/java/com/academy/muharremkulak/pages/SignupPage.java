package com.academy.muharremkulak.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.Map;

public class SignupPage {

    private WebDriver driver;

    public SignupPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@class='login-form']/h2/b")
    public WebElement enterAccountInformationHeader;
    @FindBy(xpath = "//input[@id='id_gender1']")
    public WebElement selectMr;
    @FindBy(xpath = "//input[@id='id_gender2']")
    public WebElement selectMrs;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;
    @FindBy(xpath = "//select[@id='days']")
    public WebElement daysForBirthday;
    @FindBy(xpath = "//select[@id='months']")
    public WebElement monthsForBirthday;
    @FindBy(xpath = "//select[@id='years']")
    public WebElement yearsForBirthday;
    @FindBy(id = "newsletter")
    public WebElement signupForOurNewsletterBox;
    @FindBy(id = "optin")
    public WebElement receiveSpecialOffersFromOurPartnerBox;
    @FindBy(id = "first_name")
    public WebElement firstNameInput;
    @FindBy(id = "last_name")
    public WebElement lastNameInput;
    @FindBy(id = "company")
    public WebElement companyInput;
    @FindBy(id = "address1")
    public WebElement addressInputOne;
    @FindBy(id = "address2")
    public WebElement addressInputTwo;
    @FindBy(id = "country")
    public WebElement countryDropDown;
    @FindBy(id = "state")
    public WebElement stateInput;
    @FindBy(id = "city")
    public WebElement cityInput;
    @FindBy(id = "zipcode")
    public WebElement zipcodeInput;
    @FindBy(id = "mobile_number")
    public WebElement mobileNumberInput;
    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement createAccountButton;


    public void verifyEnterAccountInformationHeader(){
        Assert.assertTrue(enterAccountInformationHeader.isDisplayed());
    }

    public void chooseMrOrMrs(){
        if(!selectMr.isSelected()){
            selectMr.click();
        }
        else{
            selectMrs.click();
        }
    }

    public void enterPassword(Map<String,String> data){
        passwordInput.sendKeys(data.get("Password"));
    }

    public void chooseDateOfBirth(){
        Select dropdownDays = new Select(daysForBirthday);
        dropdownDays.selectByVisibleText("17");
        Select dropdownMonths = new Select(monthsForBirthday);
        dropdownMonths.selectByVisibleText("July");
        Select dropdownYears = new Select(yearsForBirthday);
        dropdownYears.selectByVisibleText("1991");
    }

    public void clickOnSignupForOurNewsletterBox(){
        if(!signupForOurNewsletterBox.isSelected()){
            signupForOurNewsletterBox.click();
        }
    }

    public void clickOnReceiveSpecialOffersFromOurPartners(){
        if(!receiveSpecialOffersFromOurPartnerBox.isSelected()){
            receiveSpecialOffersFromOurPartnerBox.click();
        }
    }

    public void enterFirstNameAndLastNameForRegister(Map<String,String> data){
        firstNameInput.sendKeys(data.get("FirstName"));
        lastNameInput.sendKeys(data.get("LastName"));
    }

    public void enterCompanyForRegister(Map<String,String> data){
        companyInput.sendKeys(data.get("Company"));
    }

    public void enterAddressInformationForRegister(Map<String,String> data){
        addressInputOne.sendKeys(data.get("StreetAddress"));
        Select countryDropDownOptions = new Select(countryDropDown);
        countryDropDownOptions.selectByVisibleText("United States");
        stateInput.sendKeys(data.get("State"));
        cityInput.sendKeys(data.get("City"));
        zipcodeInput.sendKeys(data.get("Zip"));
    }

    public void enterMobileNumberInformationForRegister(Map<String,String> data){
        mobileNumberInput.sendKeys(data.get("PhoneNumber"));
    }

    public void clickCreateAccountButton(){
        createAccountButton.click();
    }




}

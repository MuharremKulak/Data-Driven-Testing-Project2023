package com.academy.muharremkulak.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Map;

public class ContactUsPage {

    private WebDriver driver;


    public ContactUsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//div[@class='contact-form']/h2")
    public WebElement getInTouchHeader;
    @FindBy(xpath = "//input[@data-qa='name']")
    public WebElement nameInputForContactPage;
    @FindBy(xpath = "//input[@data-qa='email']")
    public WebElement emailInputForContactPage;
    @FindBy(xpath = "//input[@data-qa='subject']")
    public WebElement subjectInputForContactPage;
    @FindBy(xpath = "//textarea[@data-qa='message']")
    public WebElement messageInputForContactPage;
    @FindBy(xpath = "//input[@data-qa='submit-button']")
    public WebElement submitButtonForContactPage;
    @FindBy(xpath = "//input[@name='upload_file']")
    public WebElement chooseFileButton;
    @FindBy(xpath = "//div[@class='contact-form']/div[2]")
    public WebElement successMessage;
    @FindBy(xpath = "//div[@id='form-section']/a")
    public WebElement homeButtonContactPage;


    public void verifyGetInTouchHeader(){
        String actualTextHeader = getInTouchHeader.getText();
        String expectedTextHeader = "GET IN TOUCH";
        Assert.assertEquals(actualTextHeader,expectedTextHeader);
    }

    public void enterInformationForContactUsPage(Map<String,String> data) throws InterruptedException {
        nameInputForContactPage.sendKeys(data.get("FirstName"));
        emailInputForContactPage.sendKeys(data.get("Email"));
        subjectInputForContactPage.sendKeys("QA Team is Amazing!!!!");
        messageInputForContactPage.sendKeys("Hello everybody, I'm so happy to be part of QA team. We will achieve amazing jobs together!");
        Thread.sleep(3000);
    }

    public void uploadAFileForContactPage(){
        String filePath = System.setProperty("user.dir", "src/main/java/resources/quality-assurance-1.png");
        chooseFileButton.sendKeys(filePath);
    }

    public void clickSubmitButtonForContactPage(){
        submitButtonForContactPage.click();
    }

    public void clickOkButton(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void verifySuccessMessage(){
        String actualText = successMessage.getText();
        String expectedText = "Success! Your details have been submitted successfully.";
        Assert.assertEquals(actualText,expectedText);
    }

    public void clickOnHomePage(){
        homeButtonContactPage.click();
    }
}

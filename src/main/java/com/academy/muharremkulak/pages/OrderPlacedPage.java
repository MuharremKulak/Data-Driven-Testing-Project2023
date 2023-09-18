package com.academy.muharremkulak.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;

public class OrderPlacedPage {

    private WebDriver driver;

    public OrderPlacedPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//section[@id='form']/div/div/div/p")
    public WebElement successMessageText;
    @FindBy(xpath = "//a[@href='/delete_account']")
    public WebElement deleteAccountButton;
    @FindBy(xpath = "//a[@href='/download_invoice/1000']")
    public WebElement downloadInvoice;
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueButton;



    public void verifySuccessMessage(){
        String actualText = successMessageText.getText();
        String expectedText = "Congratulations! Your order has been confirmed!";
        Assert.assertEquals(actualText, expectedText);
    }

    public void clickOnDeleteAccountButton(){
        deleteAccountButton.click();
    }

    public void clickOnDownloadInvoiceButton(){
        downloadInvoice.click();
    }

    public void verifyInvoiceIsDownloadedSuccessfully(){

        // Set the download directory path
        String downloadDir = System.getProperty("user.home") + "/Downloads"; // Default download directory on Mac

        // Assuming the file name follows a specific pattern
        String expectedFileName = "invoice.txt";

        // Wait for the file to download
        File downloadedFile = new File(downloadDir + File.separator + expectedFileName);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until((WebDriver d) -> downloadedFile.exists());

        if (downloadedFile.exists()) {
            System.out.println("Invoice downloaded successfully!");
        } else {
            System.out.println("Invoice download failed!");
        }
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

}

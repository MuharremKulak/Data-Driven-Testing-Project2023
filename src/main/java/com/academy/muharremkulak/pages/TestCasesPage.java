package com.academy.muharremkulak.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TestCasesPage {

    private WebDriver driver;

    public TestCasesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//section[@id='form']/div/div[1]/div/h2/b")
    public WebElement testCasesHeader;


    public void verifyTestCasesPage(){
        String actualTitle = testCasesHeader.getText();
        String expectedTitle = "TEST CASES";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

}

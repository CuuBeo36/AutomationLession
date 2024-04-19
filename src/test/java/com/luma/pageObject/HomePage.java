package com.luma.pageObject;

import com.parabanknew.utils.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Factory;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy (linkText = "Create an Account")
    WebElement lnkCreateAccount;
    @FindBy (css = "#ui-id-4 > span:nth-child(2)")
    WebElement lnkWomen;
    @FindBy ()
    WebElement lnkWomenTops;
    @FindBy ()
    WebElement lnkWomenJackets;

    public void clickCreateAccount(){
        lnkCreateAccount.click();
    }

}

package com.parabanknew.pageObject;

import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AboutUsPage {
    WebDriver driver;
    @FindBy (className = "title")
    WebElement ttlAboutUs;

    public AboutUsPage (WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    public void verifyTitle (String expectedTitle){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(ttlAboutUs));
        String actualTitle =  ttlAboutUs.getText();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}

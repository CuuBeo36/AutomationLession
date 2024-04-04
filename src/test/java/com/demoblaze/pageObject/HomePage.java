package com.demoblaze.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
//    By lnkSignup = By.xpath("//li/a[@id='signin2']");
    By lnkSignup = By.id("signin2");

    public void clickSignupLink() {
//        driver.findElement(lnkSignup).click();

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(lnkSignup));
    }
}

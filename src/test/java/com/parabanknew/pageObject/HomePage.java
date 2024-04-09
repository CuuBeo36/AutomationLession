package com.parabanknew.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By lnkRegisterBy = By.linkText("Register");

    public void clickRegister() {
        driver.findElement(lnkRegisterBy).click();
    }
}
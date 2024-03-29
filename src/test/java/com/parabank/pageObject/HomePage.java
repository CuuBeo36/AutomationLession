package com.parabank.pageObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
     static Logger log = LogManager.getLogger(HomePage.class.getName());
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By lnkRegisterBy = By.linkText("Register");

    public String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    public String registerUrl = "https://parabank.parasoft.com/parabank/register.htm";

    public void clickRegisterLink() {
        log.info("Clicking on Register link");
        driver.findElement(lnkRegisterBy).click();
    }
}

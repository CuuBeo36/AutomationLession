package com.parabank.pageObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
     static Logger log = LogManager.getLogger(RegisterPage.class.getName());
    WebDriver driver;
    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    By txtFirstName = By.id("customer.firstName");

    By txtLastName = By.id("customer.lastName");

    public void register(String firstName, String lastName){
        log.info("Registering user");
        driver.findElement(txtFirstName).sendKeys(firstName);
        driver.findElement(txtLastName).sendKeys(lastName);
    }
}

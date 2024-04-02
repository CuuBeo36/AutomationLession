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
    By txtAddress = By.id("customer.address.street");
    By txtCity = By.id("customer.address.city");
    By txtState = By.id("customer.address.state");
    By txtZipCode = By.id("customer.address.zipCode");
    By txtPhoneNo = By.id("customer.phoneNumber");
    By txtSsn = By.id("customer.ssn");
    By txtUsername = By.id("customer.username");
    By txtPassword = By.id("customer.password");
    By txtRePass = By.id("repeatedPassword");
    public void register(String firstName, String lastName, String address, String city, String state, String zipCode, String phoneNo, String Ssn, String username, String password, String rePass){
        log.info("Registering user");
        driver.findElement(txtFirstName).sendKeys(firstName);
        driver.findElement(txtLastName).sendKeys(lastName);
        driver.findElement(txtAddress).sendKeys(address);
        driver.findElement(txtCity).sendKeys(city);
        driver.findElement(txtState).sendKeys(state);
        driver.findElement(txtZipCode).sendKeys(zipCode);
        driver.findElement(txtPhoneNo).sendKeys(phoneNo);
        driver.findElement(txtSsn).sendKeys(Ssn);
        driver.findElement(txtUsername).sendKeys(username);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(txtRePass).sendKeys(rePass);
    }
}

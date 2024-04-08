package com.parabanknew.pageObject;

import com.parabanknew.pojo.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;
    public RegisterPage(WebDriver driver) {
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
     public By msgUsername = By.id("customer.username.errors");
     public By msgPassword = By.id("customer.password.errors");

    By btnRegister = By.xpath("//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input");

    public void Register (User user) {
        driver.findElement(txtFirstName).sendKeys(user.getFirstName());
        driver.findElement(txtLastName).sendKeys(user.getLastName());
        driver.findElement(txtAddress).sendKeys(user.getAddress());
        driver.findElement(txtCity).sendKeys(user.getCity());
        driver.findElement(txtState).sendKeys(user.getState());
        driver.findElement(txtZipCode).sendKeys(user.getZipCode());
        driver.findElement(txtPhoneNo).sendKeys(user.getPhoneNumber());
        driver.findElement(txtSsn).sendKeys(user.getSsn());
        driver.findElement(txtUsername).sendKeys(user.getUsername());
        driver.findElement(txtPassword).sendKeys(user.getPassword());
        driver.findElement(txtRePass).sendKeys(user.getPassword());
        driver.findElement(btnRegister).click();

    }
}

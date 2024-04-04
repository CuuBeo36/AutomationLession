package com.demoblaze.pageObject;

import com.demoblaze.pojo.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }
    By txtUsername = By.id("sign-username");
    By txtPassword = By.id("sign-password");
    By btnSignup = By.xpath("//button[contains(text(),'Sign up')]");

    public void signup(User user) {
        driver.findElement(txtUsername).sendKeys(user.getUsername());
        driver.findElement(txtPassword).sendKeys(user.getPassword());
        driver.findElement(btnSignup).click();
    }
}

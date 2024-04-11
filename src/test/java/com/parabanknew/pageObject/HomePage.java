package com.parabanknew.pageObject;

import com.parabanknew.pojo.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    //    public HomePage(WebDriver driver) {
//        this.driver = driver;
//    }
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Register")
    WebElement lnkRegisterBy;

    @FindBy(linkText = "About Us")
    WebElement lnkAboutUs;

    @FindBy(xpath = "//input[@value=\"Log In\"]")
    WebElement btnLogin;

    @FindBy(xpath = "//input[@name=\"username\"]")
    WebElement txtUsername;

    @FindBy(xpath = "//input[@name=\"password\"]")
    WebElement txtPassword;

    @FindBy(xpath ="//*[@id=\"rightPanel\"]/p")
    public WebElement txtLoginError;
//    public By txtLoginError = By.xpath("//*[@id=\"rightPanel\"]/p");

    public void clickRegister() {
        lnkRegisterBy.click();
    }

    public void clickAboutUs() {
        lnkAboutUs.click();
    }
    public void login(User user){
        txtUsername.sendKeys(user.getUsername());
        txtPassword.sendKeys(user.getPassword());
        btnLogin.click();
    }
}
package com.luma.pageObject;

import com.luma.pojo.User;
import com.luma.utils.Message;
import com.parabanknew.utils.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.lang.reflect.Member;
import java.time.Duration;

public class CreatePage {
    WebDriver driver;
    public CreatePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy (css = "#firstname")
    WebElement txtFristName;
    @FindBy (css = "#lastname")
    WebElement txtLastName;
    @FindBy (css = "#email_address")
    WebElement txtEmail;
    @FindBy (css ="#password")
    WebElement txtPassword;
    @FindBy (css = "#password-confirmation")
    WebElement txtConfirmPassword;
    @FindBy (xpath = "//span[contains(.,'Create an Account')]")
    WebElement btnCreate;
    @FindBy (xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
    WebElement txtRegisterSuccess;
    public void register(User user) {
        txtFristName.sendKeys(user.getFirstName());
        txtLastName.sendKeys(user.getLastName());
        txtEmail.sendKeys(user.getEmail());
        txtPassword.sendKeys(user.getPassword());
        txtConfirmPassword.sendKeys(user.getConfirmPassword());
        btnCreate.click();
    }
    public void verifySuccessMessage(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(txtRegisterSuccess));
        String actualMessage = txtRegisterSuccess.getText();
//        String expectedMessage1 = Message.getProperty("CreateAccountSuccess");
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}

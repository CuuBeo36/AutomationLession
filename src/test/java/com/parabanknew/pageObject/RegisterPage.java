package com.parabanknew.pageObject;

import com.parabanknew.pojo.User;
import com.parabanknew.utils.Config;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegisterPage {
    WebDriver driver;
    //    public RegisterPage(WebDriver driver) {
//        this.driver = driver;
//    }
//    By txtFirstName = By.id("customer.firstName");
//    By txtLastName = By.id("customer.lastName");
//    By txtAddress = By.id("customer.address.street");
//    By txtCity = By.id("customer.address.city");
//    By txtState = By.id("customer.address.state");
//    By txtZipCode = By.id("customer.address.zipCode");
//    By txtPhoneNo = By.id("customer.phoneNumber");
//    By txtSsn = By.id("customer.ssn");
//    By txtUsername = By.id("customer.username");
//    By txtPassword = By.id("customer.password");
//    By txtRePass = By.id("repeatedPassword");
//    By btnRegister = By.xpath("//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input");
//
    public By msgFirstName = By.id("customer.firstName.errors");
    public By msgLastName = By.id("customer.lastName.errors");
    public By msgAddress = By.id("customer.address.street.errors");
    public By msgCity = By.id("customer.address.city.errors");
    public By msgState = By.id("customer.address.state.errors");
    public By msgZipCode = By.id("customer.address.zipCode.errors");
    public By msgSsn = By.id("customer.ssn.errors");
    public By msgUsername = By.id("customer.username.errors");
    public By msgPassword = By.id("customer.password.errors");
    public By msgRePassword = By.id("repeatedPassword.errors");

    @FindBy(id = "customer.firstName")
    WebElement txtFirstName;
    @FindBy(id = "customer.lastName")
    WebElement txtLastName;
    @FindBy(id = "customer.address.street")
    WebElement txtAddress;
    @FindBy(id = "customer.address.city")
    WebElement txtCity;
    @FindBy(id = "customer.address.state")
    WebElement txtState;
    @FindBy(id = "customer.address.zipCode")
    WebElement txtZipCode;
    @FindBy(id = "customer.phoneNumber")
    WebElement txtPhoneNo;
    @FindBy(id = "customer.ssn")
    WebElement txtSsn;
    @FindBy(id = "customer.username")
    WebElement txtUsername;
    @FindBy(id = "customer.password")
    WebElement txtPassword;
    @FindBy(id = "repeatedPassword")
    WebElement txtRePass;
    @FindBy(xpath = "//*[@id=\"rightPanel\"]/p")
    public WebElement txtRegisterSuccess;
    @FindBy(xpath = "//*[@id='customerForm']/table/tbody/tr[13]/td[2]/input")
    WebElement btnRegister;

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void register(User user) {
//        driver.findElement(txtFirstName).sendKeys(user.getFirstName());
//        driver.findElement(txtLastName).sendKeys(user.getLastName());
//        driver.findElement(txtAddress).sendKeys(user.getAddress());
//        driver.findElement(txtCity).sendKeys(user.getCity());
//        driver.findElement(txtState).sendKeys(user.getState());
//        driver.findElement(txtZipCode).sendKeys(user.getZipCode());
//        driver.findElement(txtPhoneNo).sendKeys(user.getPhoneNumber());
//        driver.findElement(txtSsn).sendKeys(user.getSsn());
//        driver.findElement(txtUsername).sendKeys(user.getUsername());
//        driver.findElement(txtPassword).sendKeys(user.getPassword());
//        driver.findElement(txtRePass).sendKeys(user.getConfirmPassword());
//        driver.findElement(btnRegister).click();
        txtFirstName.sendKeys(user.getFirstName());
        txtLastName.sendKeys(user.getLastName());
        txtAddress.sendKeys(user.getAddress());
        txtCity.sendKeys(user.getCity());
        txtState.sendKeys(user.getState());
        txtZipCode.sendKeys(user.getZipCode());
        txtPhoneNo.sendKeys(user.getPhoneNumber());
        txtSsn.sendKeys(user.getSsn());
        txtUsername.sendKeys(user.getUsername());
        txtPassword.sendKeys(user.getPassword());
        txtRePass.sendKeys(user.getConfirmPassword());
        btnRegister.click();
    }
    public void verifySuccessMessage(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(txtRegisterSuccess));
        String actualTitle = txtRegisterSuccess.getText();
        String expectedTitle = Config.getProperty("expectedRegisterSuccessMessage");
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    public String getActualSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(txtRegisterSuccess));
        String actualMessage = txtRegisterSuccess.getText();
        return actualMessage;
    }
}

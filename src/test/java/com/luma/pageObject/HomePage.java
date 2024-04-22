package com.luma.pageObject;

import com.parabanknew.utils.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Factory;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Create an Account")
    WebElement lnkCreateAccount;
    @FindBy(xpath = "//span[contains(.,'Women')]")
    WebElement lnkWomen;
    @FindBy(xpath = "//a[contains(.,'Tops')]")
    WebElement lnkWomenTops;
    @FindBy(xpath = "//a[contains(.,'Jackets')]")
    WebElement lnkWomenJackets;
    @FindBy(id = "id=option-label-size-143-item-166")
    WebElement btnJacketSize;
    @FindBy(id = "option-label-color-93-item-49")
    WebElement btnJacketColor;
    @FindBy(css = ".product-item-inner:nth-child(4) .actions-primary span")
    WebElement btnAddToCart;
    @FindBy(css = ".showcart > .counter")
    WebElement btnShowCart;

    @FindBy(css = "#top-cart-btn-checkout")
    WebElement btnCheckout;
    public void clickCreateAccount() {
        lnkCreateAccount.click();
    }
    public void selectWomen() {
        Actions actions = new Actions(driver);
        actions.contextClick(lnkWomen).perform();
    }
    public void selectWomenTops() {
        Actions actions = new Actions(driver);
        actions.contextClick(lnkWomenTops).perform();
    }
    public void clickWomenJackets() {
        lnkWomenJackets.click();
    }
    public void clickJacketSize() {
        btnJacketSize.click();
    }

    public void clickJacketColor() {
        btnJacketColor.click();
    }

    public void clickAddToCart() {
        btnAddToCart.click();
    }

    public void clickShowCart(){
        btnShowCart.click();
    }

    public void clickCheckout(){
        btnCheckout.click();
    }
}

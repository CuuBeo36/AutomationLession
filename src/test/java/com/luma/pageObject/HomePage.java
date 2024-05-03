package com.luma.pageObject;

import com.luma.utils.LibWebGeneric;
import com.luma.utils.Message;
import com.luma.utils.ReadExcelFile;
import com.parabanknew.utils.Config;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
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
    LibWebGeneric libWebGeneric;

    static Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        libWebGeneric = new LibWebGeneric();
    }
    @FindBy (id = "search")
    WebElement txtSearch;
    @FindBy(linkText = "Create an Account")
    WebElement lnkCreateAccount;
    @FindBy(xpath = "//span[contains(.,'Women')]")
    WebElement lnkWomen;
    @FindBy(xpath = "//a[contains(.,'Tops')]")
    WebElement lnkWomenTops;
    @FindBy(xpath = "//a[contains(.,'Jackets')]")
    WebElement lnkWomenJackets;
    @FindBy(id = "option-label-size-143-item-166")
    WebElement btnJacketSize;
    @FindBy(id = "option-label-color-93-item-49")
    WebElement btnJacketColor;
    @FindBy(css = ".product-item-inner:nth-child(4) .actions-primary span")
    WebElement btnAddToCart;
    @FindBy(css = "div.products.wrapper.grid.products-grid li:nth-child(1) strong > a")
    WebElement txtProductName;
    @FindBy(xpath = "//a[text()='shopping cart']")
    WebElement msgShoppingCart;
    @FindBy(css = "#maincontent > div.page.messages > div:nth-child(2) > div > div > div")
    WebElement msgAddSuccess;
    @FindBy(css = ".showcart > .counter")
    WebElement btnShowCart;
    @FindBy(css = "#top-cart-btn-checkout")
    WebElement btnCheckout;
    public void clickCreateAccount() {
        lnkCreateAccount.click();
    }
    public void selectWomen() {
        libWebGeneric.waitElementVisible(driver, lnkWomen);
        Actions actions = new Actions(driver);
        actions.contextClick(lnkWomen).perform();
    }
    public void selectWomenTops() {
        libWebGeneric.waitElementVisible(driver, lnkWomenTops);
        Actions actions = new Actions(driver);
        actions.contextClick(lnkWomenTops).perform();
    }
    public void clickWomenJackets() {
        libWebGeneric.waitElementVisible(driver, lnkWomenJackets);
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
    public void verifyAddSuccessMessage(){
        String expectedMessage = Message.getProperty("AddToCardSuccess");
        String finalExpectedMessage = expectedMessage.replaceAll("productName", txtProductName.getText());
        System.out.println("finalExpectedMessage: "+finalExpectedMessage);
        LibWebGeneric libWebGeneric = new LibWebGeneric();
        libWebGeneric.waitElementVisible(driver, msgShoppingCart);
        boolean isTextPresent = libWebGeneric.isTextPresent(driver, finalExpectedMessage);
        Assert.assertTrue(isTextPresent);
    }
    public void clickShowCart(){
        btnShowCart.click();
    }

    public void clickCheckout(){
        btnCheckout.click();
    }

    public void searchTextFromFile(){
        ReadExcelFile readExcelFile = new ReadExcelFile();
        String searchText = readExcelFile.readData();
        txtSearch.sendKeys(searchText);
        txtSearch.sendKeys(Keys.ENTER);
    }
}

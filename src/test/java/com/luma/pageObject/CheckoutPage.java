package com.luma.pageObject;

import com.luma.pojo.CheckoutUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CheckoutPage {
    WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy (className = "username")
    WebElement txtEmail;
    @FindBy (className = "firstname")
    WebElement txtFirstName;
    @FindBy (className = "lastname")
    WebElement txtLastName;
    @FindBy (className = "company")
    WebElement txtCompany;
    @FindBy (className = "street[0]")
    WebElement txtStreet0;
    @FindBy (className = "street[1]")
    WebElement txtStreet1;
    @FindBy (className = "street[2]")
    WebElement txtStreet2;
    @FindBy (className = "city")
    WebElement txtCity;
    @FindBy (id = "N6IJ27R")
    List<WebElement> lstState;
    @FindBy (className = "postcode")
    WebElement txtZipCode;
    @FindBy (id = "GK3O422")
    List<WebElement> lstCountry;
    @FindBy (className = "telephone")
    WebElement txtPhoneNo;
    @FindBy (className = "ko_unique_3")
    WebElement btnShipBestWay;
    @FindBy (className = "ko_unique_4")
    WebElement btnShipFlatRate;
    @FindBy(id = "shipping-method-buttons-container")
    WebElement btnNext;
    public void selectRandomState() {
        int maxStates = lstState.size();
        Random random = new Random();
        int randomState = random.nextInt(maxStates);
        // Select the list item
        lstState.get(randomState).click();
    }
    public void selectRandomCountry() {
        int maxCountries = lstCountry.size();
        Random random = new Random();
        int randomCountry = random.nextInt(maxCountries);
        // Select the list item
        lstCountry.get(randomCountry).click();
    }
    public void selectRandomShip(){
        List givenList = Arrays.asList(btnShipBestWay, btnShipFlatRate);
        Random rand = new Random();
        WebElement selectedRadio =  (WebElement) givenList.get(rand.nextInt(givenList.size()));
        selectedRadio.click();
    }
    public void checkout(CheckoutUser user){
        txtEmail.sendKeys(user.getEmail());
        txtFirstName.sendKeys(user.getFirstName());
        txtLastName.sendKeys(user.getLastName());
        txtCompany.sendKeys(user.getCity());
        txtStreet0.sendKeys(user.getStreet0());
        txtStreet1.sendKeys(user.getStreet1());
        txtStreet2.sendKeys(user.getStreet2());
        txtCity.sendKeys(user.getCity());
        selectRandomState();
        txtZipCode.sendKeys(user.getZipCode());
        selectRandomCountry();
        txtPhoneNo.sendKeys(user.getPhoneNo());
        selectRandomShip();
        btnNext.click();
    }
}

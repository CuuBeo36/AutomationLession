package com.luma.pageObject;

import com.luma.pojo.CheckoutUser;
import com.luma.utils.LibWebGeneric;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CheckoutPage {
    WebDriver driver;

    static Logger log = LogManager.getLogger(CheckoutPage.class.getName());
    CommonPage commonPage;
    LibWebGeneric libWebGeneric;
    public CheckoutPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        commonPage = new CommonPage(driver);
        libWebGeneric = new LibWebGeneric();
    }
    @FindBy (id = "customer-email")
    WebElement txtEmail;
    @FindBy (xpath = "//*[@name='firstname']")
    WebElement txtFirstName;
    @FindBy (xpath = "//*[@name='lastname']")
    WebElement txtLastName;
    @FindBy (xpath = "//*[@name='company']")
    WebElement txtCompany;
    @FindBy (xpath = "//*[@name='street[0]']")
    WebElement txtStreet0;
    @FindBy (xpath = "//*[@name='street[1]']")
    WebElement txtStreet1;
    @FindBy (xpath = "//*[@name='street[2]']")
    WebElement txtStreet2;
    @FindBy (xpath = "//*[@name='city']")
    WebElement txtCity;
    @FindBy (xpath = "//*[@name='region_id']")
    WebElement ddlState;
    @FindBy (xpath = "//*[@name='region_id']/option")
    List<WebElement> lstStates;
    @FindBy (xpath = "//*[@name='postcode']")
    WebElement txtZipCode;
    @FindBy (xpath = "//*[@name='country_id']")
    WebElement ddlCountry;
    @FindBy (xpath = "//*[@name='country_id']/option")
    List<WebElement> lstCountry;
    @FindBy (xpath = ".telephone")
    WebElement txtPhoneNo;
    @FindBy (xpath = "//*[@name = 'ko_unique_1']")
    WebElement btnShipBestWay;
    @FindBy (xpath = "//*[@name = 'ko_unique_2']")
    WebElement btnShipFlatRate;
    @FindBy (xpath = "//*[@id=\"shipping-method-buttons-container\"]/div/button")
    WebElement btnNext;
    public void selectRandomState() {
        log.info("Start to select state");
        libWebGeneric.scrollToElement(driver, ddlState);
      //  libWebGeneric.waitElementVisible(driver, ddlState);
        ddlState.click();
        int maxStates = lstStates.size();
        Random random = new Random();
        int randomState = random.nextInt(maxStates);
        log.info("random state" + randomState);
        // Select the list item
        lstStates.get(randomState).click();
        log.info("End select state");
    }
    public void selectRandomCountry() {
        log.info("Start to select Country");
        libWebGeneric.scrollToElement(driver, ddlCountry);
        ddlCountry.click();
        int maxCountries = lstCountry.size();
        Random random = new Random();
        int randomCountry = random.nextInt(maxCountries);
        log.info("random country" + randomCountry);
        // Select the list item
        lstCountry.get(randomCountry).click();
        log.info("End select country");
    }
    public void selectRandomShip(){
        List givenList = Arrays.asList(btnShipBestWay, btnShipFlatRate);
        log.info("Start select Ship");
        Random rand = new Random();
        WebElement selectedRadio =  (WebElement) givenList.get(rand.nextInt(givenList.size()));
        log.info("random ship" + selectedRadio);
        selectedRadio.click();
        log.info("End select Ship");
    }
    public void checkout(CheckoutUser user){
        libWebGeneric.waitElementVisible(driver, txtEmail);
        txtEmail.sendKeys(user.getEmail());
        commonPage.waitForLoadingIconToDisappear();

        libWebGeneric.waitElementVisible(driver, txtFirstName);
        txtFirstName.sendKeys(user.getFirstName());
        commonPage.waitForLoadingIconToDisappear();

        libWebGeneric.waitElementVisible(driver, txtLastName);
        txtLastName.sendKeys(user.getLastName());

        txtCompany.sendKeys(user.getCompany());
        txtStreet0.sendKeys(user.getStreet0());
        txtStreet1.sendKeys(user.getStreet1());
        txtStreet2.sendKeys(user.getStreet2());
        txtCity.sendKeys(user.getCity());
        libWebGeneric.waitElementVisible(driver, ddlState);
        selectRandomState();
        commonPage.waitForLoadingIconToDisappear();

        txtZipCode.sendKeys(user.getZipCode());
        commonPage.waitForLoadingIconToDisappear();

        libWebGeneric.waitElementVisible(driver, ddlCountry);
        selectRandomCountry();
        commonPage.waitForLoadingIconToDisappear();

        txtPhoneNo.sendKeys(user.getPhoneNo());
        commonPage.waitForLoadingIconToDisappear();

        libWebGeneric.waitElementVisible(driver, btnShipBestWay);
        libWebGeneric.waitElementVisible(driver, btnShipFlatRate);
        selectRandomShip();
        commonPage.waitForLoadingIconToDisappear();

        btnNext.click();
    }
}

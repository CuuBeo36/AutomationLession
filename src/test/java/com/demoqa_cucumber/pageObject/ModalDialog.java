package com.demoqa_cucumber.pageObject;

import com.demoqa_cucumber.utils.LibWebGeneric;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ModalDialog {
    WebDriver driver;
    LibWebGeneric libWebGeneric;
    static Logger log = LogManager.getLogger(ModalDialog.class.getName());

    public ModalDialog(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        libWebGeneric = new LibWebGeneric();
    }
    @FindBy (id = "showSmallModal")
    WebElement btnShowSmallModal;
    @FindBy (id = "showLargeModal")
    WebElement btnShowLargeModal;
    @FindBy (id = "example-modal-sizes-title-sm")
    WebElement ttlSmallModal;
    @FindBy (id = "example-modal-sizes-title-lg")
    WebElement ttlLargeModal;
    @FindBy (id = "closeSmallModal")
    WebElement btnCloseSmallModal;
    @FindBy (id = "closeLargeModal")
    WebElement btnCloseLargeModal;

    public void verifySmallModal(String expectedSmallTitle) throws InterruptedException {
        btnShowSmallModal.click();
        libWebGeneric.waitElementVisible(driver, ttlSmallModal);
        String actualSmallTitle = ttlSmallModal.getText();
        log.info("Actual Small Title: " + actualSmallTitle);
        Assert.assertEquals(actualSmallTitle, expectedSmallTitle);
        btnCloseSmallModal.click();
        Thread.sleep(5000);
    }

    public void verifyLargeModal(String expectedLargeTitle) throws InterruptedException {
        btnShowLargeModal.click();
        String actualLargeTitle = ttlLargeModal.getText();
        log.info("Actual Large Title: " + actualLargeTitle);
        Assert.assertEquals(actualLargeTitle, expectedLargeTitle);
        btnCloseLargeModal.click();
        Thread.sleep(5000);
    }
}

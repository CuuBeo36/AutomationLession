package com.demoqa.pageObject;

import com.demoqa.utils.LibWebGeneric;
import com.demoqa.utils.Text;
import com.luma.utils.Message;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Alerts {
    WebDriver driver;
    LibWebGeneric libWebGeneric;
    static Logger log = LogManager.getLogger(Alerts.class.getName());

    public Alerts(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        libWebGeneric = new LibWebGeneric();
    }
    @FindBy (id = "alertButton")
    WebElement btnAlert;
    @FindBy (id = "timerAlertButton")
    WebElement btnTimerAlert;
    @FindBy (id = "confirmButton")
    WebElement btnConfirm;
    @FindBy (id = "confirmResult")
    WebElement txtConfirm;
    @FindBy (id = "promtButton")
    WebElement btnPromtButton;
    @FindBy (id = "promptResult")
    WebElement txtPrompt;

    public boolean isAlertPresent() {
        boolean presentFlag = false;
        try {
            // Check the presence of alert
            Alert alert = driver.switchTo().alert();
            // Alert present; set the flag
            presentFlag = true;
        } catch (NoAlertPresentException ex) {
            // Alert not present
            ex.printStackTrace();
        }
        return presentFlag;
    }
    public void verifyAlert (String expectedAlert) throws InterruptedException {
        btnAlert.click();
        log.info("Alert present: " + isAlertPresent());
        String actualAlert = driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlert,expectedAlert);
        log.info("actualAlert: " + actualAlert);
        driver.switchTo().alert().accept();
    }
    public void verifyTimerAlert (String expectedTimerAlert) throws InterruptedException{
        btnTimerAlert.click();
        libWebGeneric.waitAlertVisible(driver);
        log.info("Timer Alert present: " + isAlertPresent());
        String actualTimerAlert = driver.switchTo().alert().getText();
        log.info("actualTimerAlert: " + actualTimerAlert);

        Assert.assertEquals(actualTimerAlert,expectedTimerAlert);
        driver.switchTo().alert().accept();
    }

    public void confirmAlertOk (String expectedConfirmText) throws InterruptedException{
        btnConfirm.click();
        libWebGeneric.waitAlertVisible(driver);
        log.info("Confirm alert present: " + isAlertPresent());

        String actualConfirmAlert = driver.switchTo().alert().getText();
        log.info("Actual confirm alert: " + actualConfirmAlert);
        String expectedConfirmAlert = Text.getProperty("expectedConfirmAlert");
        Assert.assertEquals(actualConfirmAlert,expectedConfirmAlert);

        driver.switchTo().alert().accept();
        String actualText = txtConfirm.getText();
        log.info("actualText" + actualText);
        Assert.assertEquals(actualText,expectedConfirmText);
    }

    public void verifyPromtBox () throws InterruptedException {
        btnPromtButton.click();
        libWebGeneric.waitAlertVisible(driver);
//        log.info("Prompt alert present: " + isAlertPresent());

        String actualPrompt = driver.switchTo().alert().getText();
//        log.info("Actual prompt: " + actualPrompt);
//        String expectedPrompt = Text.getProperty("expectedPrompt");
//        Assert.assertEquals(actualPrompt,expectedPrompt);

        String text = "Automation Test Data";
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();

        String actualPromptResult = txtPrompt.getText();

        String expectedPromptResult = Text.getProperty("expectedPromptResult");
        String finalexpectedPromptResult = expectedPromptResult.replaceAll("text", text);
        log.info("Final Prompt result " + finalexpectedPromptResult);
        Assert.assertEquals(actualPromptResult, finalexpectedPromptResult);
    }
}

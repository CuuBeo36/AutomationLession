package com.luma.utils;

import com.parabank.pageObject.RegisterPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LibWebGeneric {
    static Logger log = LogManager.getLogger(LibWebGeneric.class.getName());
    public boolean isTextPresent(WebDriver driver, String text) {
        String pageSource = driver.getPageSource();
        return pageSource.contains(text);
    }
    public void waitElementVisible(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForLoadingIconToDisappear(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
    public void scrollToElement(WebDriver driver, WebElement element) {
        log.info("Start to scroll element");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        log.info("End to scroll element");
    }
    public void moveToElement(WebDriver driver, WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}
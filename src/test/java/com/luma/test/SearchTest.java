package com.luma.test;

import com.luma.pageObject.HomePage;
import com.luma.utils.Env;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchTest extends BaseClass {
    static Logger log = Logger.getLogger(com.luma.test.SearchTest.class.getName());

    @Test(description = "testSearch1text")
    public void testSearch1text() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        //homePage.searchTextFromFile();
    }

    @Test(description = "testSearch1text")
    public void testSearch2text() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.searchTextFromFile();
    }

    @Test(description = "testSearch1text")
    public void testSearch3text() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.searchTextFromFile();
    }
}

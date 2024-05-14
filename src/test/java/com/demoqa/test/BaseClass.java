package com.demoqa.test;

import com.demoqa.utils.Env;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseClass {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    long implicitlyWait;
    String baseUrl = Env.getProperty("baseUrl");
    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        WebDriverManager.chromedriver().setup();
        // Disable save password popup
        ChromeOptions options = new ChromeOptions();
        // Running mode: headless
        options.addArguments("--headless");
        driver.set(new ChromeDriver(options));
        getDriver().manage().window().maximize();
        implicitlyWait = Long.parseLong(Env.getProperty("implicitlyWait"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
//        getDriver().get(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        getDriver().quit();
    }
}

package com.demoqa_cucumber.definitions;

import com.demoqa.utils.Env;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
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

    @Given("User go to Home page")
    public void setup() {
        WebDriverManager.chromedriver().setup();
        // Disable save password popup
        ChromeOptions options = new ChromeOptions();
        // Running mode: headless
//        options.addArguments("--headless");
        driver.set(new ChromeDriver(options));
        getDriver().manage().window().maximize();
        implicitlyWait = Long.parseLong(Env.getProperty("implicitlyWait"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
//        getDriver().get(baseUrl);
    }

    @And("User closes browser")
    public void tearDown() {
        BaseClass.getDriver().quit();
    }
}

package com.parabanknew.test;

import com.beust.ah.A;
import com.parabanknew.pageObject.AboutUsPage;
import com.parabanknew.pageObject.HomePage;
import com.parabanknew.utils.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class AboutUsTest {
    WebDriver driver;
    String baseUrl = Config.getProperty("baseUrl");

    static Logger log = Logger.getLogger(RegisterTest.class.getName());
    long implicitlyWait;
    @BeforeMethod(alwaysRun = true)
    public void setup() {
        WebDriverManager.chromedriver().setup();
        // Disable save password popup
        ChromeOptions options = new ChromeOptions();
        // Running mode: headless
        options.addArguments("--headless");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("autofill.profile_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        implicitlyWait = Long.parseLong(Config.getProperty("implicitlyWait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
        driver.get(baseUrl);
    }
    @Test
    public void testAboutUs(){
        HomePage homePage = new HomePage(driver);
        homePage.clickAboutUs();

        AboutUsPage aboutUsPage = new AboutUsPage(driver);
        String expectedTitle= Config.getProperty("expectedTitleAboutUs");
        aboutUsPage.verifyTitle(expectedTitle);
    }
}

package com.luma.test;

import com.luma.pageObject.HomePage;
import com.luma.pageObject.CreatePage;
import com.luma.pojo.User;
import com.luma.utils.Env;
import com.luma.utils.Message;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class RegisterTest {
    WebDriver driver;
    String baseUrl = Env.getProperty("baseUrl");
    static Logger log = Logger.getLogger(com.luma.test.RegisterTest.class.getName());
    long implicitlyWait;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        WebDriverManager.chromedriver().setup();
        // Disable save password popup
        ChromeOptions options = new ChromeOptions();
        // Running mode: headless
//        options.addArguments("--headless");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("autofill.profile_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        implicitlyWait = Long.parseLong(Env.getProperty("implicitlyWait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
        driver.get(baseUrl);
    }

    @Test(description = "Full information")
    public void testRegisterFull() throws InterruptedException {
        User user = new User();
        user.generateUser();

        HomePage homePage = new HomePage(driver);
        homePage.clickCreateAccount();

        CreatePage createPage = new CreatePage(driver);
        createPage.register(user);

        String expectedMessage = Message.getProperty("CreateAccountSuccess");
        createPage.verifySuccessMessage(expectedMessage);

    }
    @AfterMethod(alwaysRun = true)
    public void tearDown (){
        driver.quit();
    }
}


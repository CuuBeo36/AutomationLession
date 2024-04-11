package com.parabanknew.test;

import com.parabanknew.pageObject.AboutUsPage;
import com.parabanknew.pageObject.HomePage;
import com.parabanknew.pageObject.RegisterPage;
import com.parabanknew.pojo.User;
import com.parabanknew.utils.Config;
import com.parabanknew.utils.Data;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class LoginTest {
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
//        options.addArguments("--headless");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("autofill.profile_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        implicitlyWait = Long.parseLong(Config.getProperty("implicitlyWait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
        driver.get(baseUrl);
    }

    @Test (description = "Test login with recently sign up user")
    public void testLoginSuccess() throws InterruptedException {
        User user = new User();
        user.generateUser();

        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(user);

        String expectedTitle = Config.getProperty("expectedRegisterSuccessMessage");
        registerPage.verifySuccessMessage(expectedTitle);
        WebElement btnLogOut = driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[8]/a"));
        btnLogOut.click();

        homePage.login(user);
        log.info("First name:" + user.firstName);
        log.info("Last name:" + user.lastName);
        String expectedAccount = "Welcome " + user.firstName + " " + user.lastName;
        log.info(expectedAccount);

        WebElement loggedAccount = driver.findElement(By.className("smallText"));
        log.info(loggedAccount);
        Assert.assertEquals(loggedAccount, expectedAccount, "Pass");
    }

    @Test (description = "Test login with invalid user")
    public void testLoginInvalidAccount() throws InterruptedException {
        User user = new User();
        user.generateUser();
        user.setUsername(Data.getProperty("user1"));
        user.setPassword(Data.getProperty("pass1"));

        HomePage homePage = new HomePage(driver);
        homePage.login(user);

        String actualError = homePage.txtLoginError.getText();
        String expectedError= Data.getProperty("message1");
        log.info("Actual message: " + actualError);
        log.info(expectedError);
        Assert.assertEquals(actualError, expectedError, "Wrong message");
    }
    @Test (description = "Test login with special characters")
    public void testLoginSpecialCharacter() throws InterruptedException {
        User user = new User();
        user.generateUser();
        user.setUsername(Data.getProperty("user2"));
        user.setPassword(Data.getProperty("pass2"));

        HomePage homePage = new HomePage(driver);
        homePage.login(user);

        String actualError = homePage.txtLoginError.getText();
        String expectedError= Data.getProperty("message2");
        log.info("Actual message: " + actualError);
        log.info(expectedError);
        Assert.assertEquals(actualError, expectedError, "Wrong message");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}


package com.parabanknew.test;

import com.parabanknew.pageObject.HomePage;
import com.parabanknew.pageObject.RegisterPage;
import com.parabanknew.pojo.User;
import com.parabanknew.utils.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class RegisterTest {
    //    public static WebDriver driver =  new ChromeDriver();;
    WebDriver driver;
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    static Logger log = Logger.getLogger(RegisterTest.class.getName());

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        WebDriverManager.chromedriver().setup();
        // Disable save password popup
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("autofill.profile_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(baseUrl);
    }

    @Parameters("browser")
    public void setup(String browser) throws Exception {
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            throw new Exception("Incorrect Browser");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(groups = {"only"}, description = "Full information")
    public void testRegisterFull() throws InterruptedException {
        User user = new User();
        user.generateUser();

        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(user);
//
//        String expectedElementText = "Your account was created successfully. You are now logged in.";
//        Thread.sleep(5000);
//
//        WebElement t = driver.findElement(registerPage.txtRegisterSuccess);
//        String actualElementText = t.getText();
//        log.info("Actual message: " + actualElementText);
//        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual are not same");
        String expectedMessage= Config.getProperty("expectedRegisterSuccessMessage");
        registerPage.verifySuccessMessage(expectedMessage);
    }

    @Test(groups = {"success"}, description = "PhoneNo is empty")
    public void testRegisterPhoneNoEmpty() throws InterruptedException {
        User user = new User();
        user.generateUser();
        user.setPhoneNumber("");

        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(user);

//        String expectedElementText = "Your account was created successfully. You are now logged in.";
//        Thread.sleep(5000);

//        WebElement t = driver.findElement(registerPage.txtRegisterSuccess);
//        String actualElementText = t.getText();
//        log.info("Actual message: " + actualElementText);
//        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual are not same");
        String expectedMessage= Config.getProperty("expectedRegisterSuccessMessage");
        registerPage.verifySuccessMessage(expectedMessage);
    }

    @Test(groups = {"fail"})
    public void testRegisterFirstNameEmpty() throws InterruptedException {
        User user = new User();
        user.generateUser();
        user.setFirstName("");

        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(user);

        String expectedElementText = "First name is required.";
        Thread.sleep(5000);

        WebElement t = driver.findElement(registerPage.msgFirstName);
        String actualElementText = t.getText();
        log.info("Actual message: " + actualElementText);
        Assert.assertEquals(actualElementText, expectedElementText, "Wrong message in case first name is empty");
    }

    @Test(groups = {"fail"})
    public void testRegisterLastNameEmpty() throws InterruptedException {
        User user = new User();
        user.generateUser();
        user.setLastName("");

        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(user);

        String expectedElementText = "Last name is required.";
        Thread.sleep(5000);

        WebElement t = driver.findElement(registerPage.msgLastName);
        String actualElementText = t.getText();
        log.info("Actual message: " + actualElementText);
        Assert.assertEquals(actualElementText, expectedElementText, "Wrong message in case first name is empty");
    }

    @Test(groups = {"fail"})
    public void testRegisterUsernameEmpty() throws InterruptedException {
        User user = new User();
        user.generateUser();
        user.setUsername("");

        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(user);

        String expectedElementText = "Username is required.";
        Thread.sleep(5000);

        WebElement t = driver.findElement(registerPage.msgUsername);
        String actualElementText = t.getText();
        log.info("Actual message: " + actualElementText);
        Assert.assertEquals(actualElementText, expectedElementText, "Wrong message in case username is empty");
    }

    @Test(priority = 3, groups = {"fail"})
    public void testRegisterPasswordEmpty() throws InterruptedException {
        User user = new User();
        user.generateUser();
        user.setPassword("");

        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(user);

        String expectedElementText = "Password is required.";
        Thread.sleep(5000);

        WebElement t = driver.findElement(registerPage.msgPassword);
        String actualElementText = t.getText();
        log.info("Actual message: " + actualElementText);
        Assert.assertEquals(actualElementText, expectedElementText, "Wrong message in case password is empty");
    }

    @Test(groups = {"fail"})
    public void testRegisterRePasswordEmpty() throws InterruptedException {
        User user = new User();
        user.generateUser();
        user.setConfirmPassword("");

        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(user);

        String expectedElementText = "Password confirmation is required.";
        Thread.sleep(5000);

        WebElement t = driver.findElement(registerPage.msgRePassword);
        String actualElementText = t.getText();
        log.info("Actual message: " + actualElementText);
        Assert.assertEquals(actualElementText, expectedElementText, "Wrong message in case confirm password is empty");
    }

    @Test(groups = {"fail"})
    public void testRegisterUsernameExist() throws InterruptedException {
        User user = new User();
        user.generateUser();
        user.setFirstName("Seymour");
        user.setUsername("Seymour");

        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(user);

        String expectedElementText = "This username already exists.";
        Thread.sleep(5000);

        WebElement t = driver.findElement(registerPage.msgUsername);
        String actualElementText = t.getText();
        log.info("Actual message:" + actualElementText);
        Assert.assertEquals(actualElementText, expectedElementText, "Wrong message in case username is existed");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

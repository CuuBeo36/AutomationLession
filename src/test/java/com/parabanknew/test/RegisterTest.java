package com.parabanknew.test;

import com.parabanknew.pageObject.HomePage;
import com.parabanknew.pageObject.RegisterPage;
import com.parabanknew.pojo.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class RegisterTest {
    WebDriver driver;
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(baseUrl);
    }

    @Test(priority = 1)
    public void testRegisterSuccess() throws InterruptedException {
        User user = new User();
        user.generateUser();

        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-web-security");
        options.addArguments("--no-proxy-server");

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.Register(user);

        String expectedElementText = "Your account was created successfully. You are now logged in.";
        Thread.sleep(5000);

        WebElement t = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p"));

        String actualElementText = t.getText();
        System.out.println(actualElementText);
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual are not same");


    }

    @Test(priority = 2)
    public void testRegisterEmptyUsername() throws InterruptedException {
        User user = new User();
        user.generateUser();

        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.Register(user);
        user.setPassword("Passw@rd");

        String expectedElementText = "Username is empty.";
        Thread.sleep(5000);

        WebElement t = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p"));

        String actualElementText = t.getText();
        System.out.println(actualElementText);
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual are not same");
    }


    @Test(priority = 3)
    public void testRegisterPasswordUnmatch() throws InterruptedException {
        User user = new User();
        user.generateUser();

        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.Register(user);
        user.setPassword("");

        String expectedElementText = "Confirm Password is not match";
        Thread.sleep(5000);

        WebElement t = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p"));

        String actualElementText = t.getText();
        System.out.println(actualElementText);
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual are not same");
    }
        @AfterTest
        public void tearDown() {
            driver.quit();
        }
}

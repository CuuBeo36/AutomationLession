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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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

        // Disable save password popup
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("autofill.profile_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(baseUrl);
    }

    @Test (priority = 5)
    public void testRegisterSuccess() throws InterruptedException {
        User user = new User();
        user.generateUser();

        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.Register(user);

        String expectedElementText = "Your account was created successfully. You are now logged in.";
        Thread.sleep(5000);

        WebElement t = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p"));

        String actualElementText = t.getText();
        System.out.println(actualElementText);
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual are not same");
    }

    @Test (priority = 2)
    public void testRegisterUsernameEmpty() throws InterruptedException {
        User user = new User();
        user.generateUser();
        user.setUsername("");

        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.Register(user);


        //        TODO: expectedElementText is wrong, pls check -> DONE
        String expectedElementText = "Username is required.";
        Thread.sleep(5000);

        //        TODO: xpath should be in pageObject -> DONE
        WebElement t = driver.findElement(By.id("customer.username.errors"));

        String actualElementText = t.getText();
        System.out.println(actualElementText);

        //        TODO: error message should be more clear and more specific -> DONE
        Assert.assertEquals(actualElementText, expectedElementText, "Wrong message in case username is empty");
    }

    @Test (priority = 3)
    public void testRegisterPasswordEmpty() throws InterruptedException {
        User user = new User();
        user.generateUser();
        user.setPassword("");

        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.Register(user);


//        TODO: expectedElementText is wrong, pls check -> DONE
        String expectedElementText = "Password is required.";
        Thread.sleep(5000);

//        TODO: xpath should be in pageObject -> DONE
        WebElement t = driver.findElement(By.id("customer.password.errors"));

        String actualElementText = t.getText();
        System.out.println(actualElementText);

//        TODO: error message should be more clear and more specific -> DONE
        Assert.assertEquals(actualElementText, expectedElementText, "Wrong message in case password is empty");
    }

    @Test (priority = 4)
    public void testRegisterUsernameExist() throws InterruptedException {
        User user = new User();
        user.generateUser();
        user.setFirstName("Seymour");
        user.setUsername("Seymour");

        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.Register(user);


//        TODO: expectedElementText is wrong, pls check -> DONE
        String expectedElementText = "This username already exists.";
        Thread.sleep(5000);

//        TODO: xpath should be in pageObject -> DONE
        WebElement t = driver.findElement(By.id("customer.username.errors"));

        String actualElementText = t.getText();
        System.out.println(actualElementText);

//        TODO: error message should be more clear and more specific -> DONE
        Assert.assertEquals(actualElementText, expectedElementText, "Wrong message in case username is existed");
    }


//    @AfterMethod
//    public void goBackToHomepage ( ) {
//        driver.findElement(By.linkText("Home")).click() ;
//    }

    @AfterTest
        public void tearDown() {
            driver.quit();
        }
}

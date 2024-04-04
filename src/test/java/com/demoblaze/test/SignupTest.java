package com.demoblaze.test;

import com.demoblaze.pageObject.HomePage;
import com.demoblaze.pageObject.SignupPage;
import com.demoblaze.pojo.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignupTest {
    WebDriver driver;
    String baseUrl = "https://www.demoblaze.com/index.html";

    @BeforeTest
    public void setup() {
       WebDriverManager.edgedriver().setup();
       driver = new EdgeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       driver.get(baseUrl);
    }

    @Test(priority = 12)
    public void testSignupSuccess() throws InterruptedException {
        User user = new User();
        user.generateUser();

        HomePage homePage = new HomePage(driver);
        homePage.clickSignupLink();

        SignupPage signupPage = new SignupPage(driver);
        signupPage.signup(user);

        String expectedAlertMessage = "Sign up successful.";

        Thread.sleep(5000);

        // Assuming alert is present
        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), expectedAlertMessage, "Alert message is not as expected");

        // Accept the alert
        alert.accept();

    }

    @Test(priority = 2)
    public void testSignupFailureUsernameEmpty() throws InterruptedException {
        User user = new User();
        user.setUsername("");
        user.setPassword("Passw@rd123");

        HomePage homePage = new HomePage(driver);
        homePage.clickSignupLink();

        SignupPage signupPage = new SignupPage(driver);
        signupPage.signup(user);

        String expectedAlertMessage = "Please fill out Username and Password.";

        Thread.sleep(5000);

        // Assuming alert is present
        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), expectedAlertMessage, "Alert message is not as expected");

        // Accept the alert
        alert.accept();

    }

//    @Test
//    public void testSignupFailurePasswordEmpty() {
//        // Write code here
//    }
//
//    @Test
//    public void testSignupFailureBothUsernamePasswordEmpty() {
//        // Write code here
//    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

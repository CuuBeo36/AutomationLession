package com.luma.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.luma.pageObject.CheckoutPage;
import com.luma.pageObject.CreatePage;
import com.luma.pageObject.HomePage;
import com.luma.pojo.CheckoutUser;
import com.luma.pojo.SignInUser;
import com.luma.utils.Env;
import com.luma.utils.Message;
import com.parabanknew.pojo.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CheckoutTest {
    WebDriver driver;
    String baseUrl = Env.getProperty("baseUrl");
    static Logger log = Logger.getLogger(com.luma.test.CheckoutTest.class.getName());
    long implicitlyWait;

    private ExtentReports extent;
    private ExtentTest test;

    @BeforeSuite
    public void setUp() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("report.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
    @BeforeMethod(alwaysRun = true)
    public void setup() {
        WebDriverManager.chromedriver().setup();
        // Disable save password popup
        ChromeOptions options = new ChromeOptions();
        // Running mode: headless
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        implicitlyWait = Long.parseLong(Env.getProperty("implicitlyWait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
        driver.get(baseUrl);
    }
    @Test(description = "testCheckoutNoSignIn")
    public void testCheckoutNoSignIn() throws InterruptedException {
        test = extent.createTest("testCheckoutNoSignIn", "testCheckoutNoSignIn");

        HomePage homePage = new HomePage(driver);
        homePage.selectWomen();
        homePage.selectWomenTops();
        homePage.clickWomenJackets();
        homePage.clickJacketSize();
        homePage.clickJacketColor();
        homePage.clickAddToCart();
        homePage.clickShowCart();
        homePage.clickCheckout();

        CheckoutUser user = new CheckoutUser();
        user.generateCheckOutUser();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkout(user);

    }
    @AfterMethod(alwaysRun = true)
    public void tearDown (){
        driver.quit();
        extent.flush();
    }
}

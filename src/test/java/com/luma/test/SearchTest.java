package com.luma.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.luma.pageObject.HomePage;
import com.luma.utils.Env;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchTest {
    WebDriver driver;
    String baseUrl = Env.getProperty("baseUrl");
    long implicitlyWait = Long.parseLong(Env.getProperty("implicitlyWait"));
    static Logger log = Logger.getLogger(com.luma.test.SearchTest.class.getName());
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
        ChromeOptions options = new ChromeOptions();
//        Running mode: headless
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
        driver.get(baseUrl);
    }

    @Test(description = "testSearch1text")
    public void testSearch1text() throws InterruptedException {
        test = extent.createTest("testSearch1text", "testSearch1text");
        HomePage homePage = new HomePage(driver);
        homePage.searchTextFromFile();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown (){
        driver.quit();
        extent.flush();
    }
}

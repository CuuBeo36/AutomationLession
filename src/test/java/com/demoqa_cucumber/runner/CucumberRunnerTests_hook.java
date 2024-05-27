package com.demoqa_cucumber.runner;

import com.demoqa.utils.Env;
import com.demoqa_cucumber.definitions.BaseClass;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

@CucumberOptions(tags = "AddNewRecord", features = {"src/test/resources/demoqa_features"}, plugin = {}, glue = "com.demoqa_cucumber.definitions")
public class CucumberRunnerTests_hook {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    long implicitlyWait;
    String baseUrl = Env.getProperty("baseUrl");
    public static WebDriver getDriver() {
        return driver.get();
    }

    private static TestNGCucumberRunner runner;
    public CucumberRunnerTests_hook(){
        runner = new TestNGCucumberRunner(this.getClass());
    }

    @BeforeClass
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

    @DataProvider
    public Object[][] scenarios() {
        return runner.provideScenarios();
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {
        runner.runScenario(pickleWrapper.getPickle());
    }

    @AfterMethod
    public void tearDown() {
        BaseClass.getDriver().quit();
    }
}
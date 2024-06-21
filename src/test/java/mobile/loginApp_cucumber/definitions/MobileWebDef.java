package mobile.loginApp_cucumber.definitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.ContextAware;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class MobileWebDef {
    AppiumDriver mobileDriver;

    RemoteWebDriver remoteWebDriver;
    @When("Setup mobile web device")
    public void setupMobileWeb() throws MalformedURLException {
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        capabilities.setCapability("browserName", "safari");
        browserstackOptions.put("osVersion", "16");
        browserstackOptions.put("deviceName", "iPhone 14 Pro Max");
        browserstackOptions.put("appiumVersion", "1.21.0");
        browserstackOptions.put("userName", "cuubeo_Su8GIc");
        browserstackOptions.put("accessKey", "xJ6xoV1z9zii1hxeenGp");
        browserstackOptions.put("interactiveDebugging", "true");
        browserstackOptions.put("debug", "true");
        capabilities.setCapability("bstack:options", browserstackOptions);

        remoteWebDriver = new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"), capabilities);
    }

    @When("Setup mobile web device from Json")
    public void setupMobileWebFromJson() throws MalformedURLException {
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        capabilities.setCapability("browserName", "safari");
        browserstackOptions.put("osVersion", "16");
        browserstackOptions.put("deviceName", "iPhone 14 Pro Max");
        browserstackOptions.put("appiumVersion", "1.21.0");
        browserstackOptions.put("userName", "cuubeo_Su8GIc");
        browserstackOptions.put("accessKey", "xJ6xoV1z9zii1hxeenGp");
        browserstackOptions.put("interactiveDebugging", "true");
        browserstackOptions.put("debug", "true");
        capabilities.setCapability("bstack:options", browserstackOptions);

        remoteWebDriver = new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"), capabilities);
    }

    @When("User access mobile web")
    public void accessVNExpress(){
        remoteWebDriver.get("https://vnexpress.net/");
    }

    @Then("Verify web title")
    public void verifyWebTitle(){
        String actualTitle = remoteWebDriver.getTitle();
        System.out.println("Title: " + actualTitle);
        String expectedTitle = "Báo VnExpress - Báo tiếng Việt nhiều người xem nhất";
        Assert.assertEquals(actualTitle, expectedTitle, "Pass");
    }

    @And("Close Web")
    public void tearDown(){
        remoteWebDriver.quit();
    }

    @When("User search on mobile web")
    public void searchOnWeb(){
        remoteWebDriver.get("https://vnexpress.net/");
        remoteWebDriver.findElement(By.xpath("//*[@id=\"header\"]/div[1]")).click();
        remoteWebDriver.findElement(By.id("auto_search_textbox")).sendKeys("Automation Test");
        remoteWebDriver.findElement(By.id("auto_search_textbox")).sendKeys(Keys.ENTER);
    }

    @Then("Verify search result")
    public void VerifySearchResult(){
        String actualTitle = remoteWebDriver.getTitle();
        System.out.println("Title: " + actualTitle);
        String expectedTitle = "Báo VnExpress - Báo tiếng Việt nhiều người xem nhất";
        Assert.assertEquals(actualTitle, expectedTitle, "Pass");
    }
}

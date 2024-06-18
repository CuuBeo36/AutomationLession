package mobile.loginApp_cucumber.definitions;

import com.automation.core.utils.LibMobileGeneric;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.loginApp_cucumber.pageObject.HomePage;
import mobile.loginApp_cucumber.pageObject.LoginPage;
import mobile.loginApp_cucumber.pageObject.RegisterPage;
import mobile.loginApp_cucumber.pojo.User;
import mobile.loginApp_cucumber.utils.JsonUtils;
import org.json.JSONPropertyName;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class RegisterDef {
    AppiumDriver mobileDriver;

    RemoteWebDriver remoteWebDriver;

    @Given("Setup device")
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities = JsonUtils.getCapabilitiesFromJson("Device1");
        String appName = capabilities.getCapability("appium:app").toString();
        String newPath = System.getProperty("user.dir") + "\\" + appName;
        capabilities.setCapability("appium:app", newPath);

        mobileDriver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @Given("Setup browserstack device")
    public void setupBrowserstack() throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        capabilities = JsonUtils.getCapabilitiesFromJson("Device5");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("projectName", "LoginApp");
        browserstackOptions.put("userName", "cuubeo_Su8GIc");
        browserstackOptions.put("accessKey", "xJ6xoV1z9zii1hxeenGp");
        browserstackOptions.put("interactiveDebugging", "true");
        browserstackOptions.put("debug", "true");
        capabilities.setCapability("bstack:options", browserstackOptions);
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("appium:platformVersion", "13.0");
        capabilities.setCapability("appium:deviceName", "Samsung Galaxy S23 Ultra");
        capabilities.setCapability("appium:app", "bs://b51a5825b8cf8617d9c0c4d1d0dad089967c6da7");

        mobileDriver = new AppiumDriver(new URL("https://hub.browserstack.com/wd/hub"), capabilities);
    }

//    @Given("Setup browserstack device from json")
//    public void setupBrowserstackFromJson() throws MalformedURLException {
//        JSONPropertyName parser = new JSONParser();
//
//        try {
//            // Parse the contents of the JSON file
//            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("Input/conf/single.conf.json"));
//
//            // Get the 'browserstackOptions' object
//            JSONObject browserstackOptions = (JSONObject) jsonObject.get("browserstackOptions");
//
//            // Print the contents of 'browserstackOptions'
//            System.out.println("Browserstack Options: " + browserstackOptions.toJSONString());
//
//            // If you want to access individual properties, you can do so like this:
//            String userName = (String) browserstackOptions.get("userName");
//            System.out.println("Username: " + userName);
//
//            // Continue for other properties...
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
        @Then("Close application")
        public void tearDown () {
            mobileDriver.quit();
        }

        @When("User register new account")
        public void registerAccount () throws MalformedURLException, InterruptedException {
            LoginPage loginPage = new LoginPage(mobileDriver);
            loginPage.clickRegister();
            User user = new User();
            user.generateRegisterUser();
            RegisterPage registerPage = new RegisterPage(mobileDriver);
            registerPage.registerUser(user);
            System.out.println("Email: " + user.getEmail());
            Thread.sleep(5000);
            registerPage.clickLogin();
            loginPage.login(user);
        }

        @Then("Verify login success")
        public void verifyLoginSuccess () {
            LoginPage loginPage = new LoginPage(mobileDriver);
            loginPage.verifyLoginSuccess();
            HomePage homePage = new HomePage(mobileDriver);
            homePage.verifyLoggedEmail();
        }

        @When("User register new account but empty email")
        public void registerAccountEmptyEmail () throws InterruptedException {
            LibMobileGeneric.scrollDown(mobileDriver);
            LoginPage loginPage = new LoginPage(mobileDriver);
            loginPage.clickRegister();
            User user = new User();
            user.generateRegisterUser();
            RegisterPage registerPage = new RegisterPage(mobileDriver);
            registerPage.emptyEmail(user);
        }

        @Then("Verify message empty email")
        public void verifyEmptyEmail () {
            RegisterPage registerPage = new RegisterPage(mobileDriver);
            registerPage.verifyEmptyEmail();
        }
    }
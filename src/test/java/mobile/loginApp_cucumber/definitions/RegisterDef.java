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
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class RegisterDef {
    AppiumDriver mobileDriver;

    @Given("Setup device")
     public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities = JsonUtils.getCapabilitiesFromJson("Device1");
        String appName = capabilities.getCapability("appium:app").toString();
        String newPath = System.getProperty("user.dir") + "\\" + appName;
        capabilities.setCapability("appium:app", newPath);

        mobileDriver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @Then("Close application")
    public void tearDown(){
        mobileDriver.quit();
    }

    @When("User register new account")
    public void registerAccount() throws MalformedURLException, InterruptedException {
        LoginPage loginPage = new LoginPage(mobileDriver);
        loginPage.clickRegister();
        User user = new User();
        user.generateRegisterUser();
        RegisterPage registerPage = new RegisterPage(mobileDriver);
        registerPage.registerUser(user);
        System.out.println("Email: "+ user.getEmail());
        Thread.sleep(5000);
        registerPage.clickLogin();
        loginPage.login(user);
    }

    @Then("Verify login success")
    public void verifyLoginSuccess() {
        LoginPage loginPage = new LoginPage(mobileDriver);
        loginPage.verifyLoginSuccess();
        HomePage homePage = new HomePage(mobileDriver);
        homePage.verifyLoggedEmail();
    }

    @When("User register new account but empty email")
    public void registerAccountEmptyEmail() throws InterruptedException {
        LibMobileGeneric.scrollDown(mobileDriver);
        LoginPage loginPage = new LoginPage(mobileDriver);
        loginPage.clickRegister();
        User user = new User();
        user.generateRegisterUser();
        RegisterPage registerPage = new RegisterPage(mobileDriver);
        registerPage.emptyEmail(user);
    }

    @Then("Verify message empty email")
    public void verifyEmptyEmail() {
        RegisterPage registerPage = new RegisterPage(mobileDriver);
        registerPage.verifyEmptyEmail();
    }
}
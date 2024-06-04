package mobile.loginApp_cucumber.definitions;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import mobile.loginApp_cucumber.pageObject.LoginPage;
import mobile.loginApp_cucumber.pojo.User;
import mobile.loginApp_cucumber.utils.JsonUtils;
import mobile.web.pageObject.TempMailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LoginDef {

    AppiumDriver mobileDriver;
    WebDriver webDriver;

    String webEmail;

    @When("User get email from Web")
    public void GetEmail() throws MalformedURLException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        webDriver.get("https://temp-mail.org/en/");

        TempMailPage tempMailPage = new TempMailPage(webDriver);
        webEmail = tempMailPage.getEmail();
        webDriver.quit();
    }

    @And("User login by WebEmail")
    public void Login() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities = JsonUtils.getCapabilitiesFromJson("Device1");
        String appName = capabilities.getCapability("appium:app").toString();
        String newPath = System.getProperty("user.dir") + "\\" + appName;
        capabilities.setCapability("appium:app", newPath);

        mobileDriver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        LoginPage login = new LoginPage(mobileDriver);
        User user = new User();
        user.generateLoginUser();
        user.setEmail(webEmail);
        System.out.println("webEmail: " + webEmail);
        login.login(user);
    }

    @Then("Verify wrong message")
    public void verifyWrongMessage() {
        LoginPage login = new LoginPage(mobileDriver);
        login.verifyWrongLogin();
    }

}

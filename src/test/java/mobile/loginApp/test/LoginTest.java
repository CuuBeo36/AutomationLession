package mobile.loginApp.test;

import io.appium.java_client.AppiumDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import mobile.loginApp.pageObject.LoginPage;
import mobile.loginApp.utils.JsonUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import mobile.loginApp.pojo.User;
import mobile.web.pageObject.TempMailPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LoginTest {
    AppiumDriver mobileDriver;
    WebDriver webDriver;
    
//    @BeforeClass
//    public void setup() {
//        try {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//
//            capabilities = JsonUtils.getCapabilitiesFromJson("Device1");
//            String appName = capabilities.getCapability("appium:app").toString();
//            String newPath = System.getProperty("user.dir") + "\\" + appName;
//            capabilities.setCapability("appium:app", newPath);
//
//            driver =  new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
//
//        }catch(Exception e){
//            e.printStackTrace();
//        } finally {
//        }
//    }
    @Test
    public void TestLoginMobile() throws MalformedURLException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        // Disable save password popup
        ChromeOptions options = new ChromeOptions();
        // Running mode: headless
//        options.addArguments("--headless");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        webDriver.get("https://temp-mail.org/en/");

        TempMailPage tempMailPage = new TempMailPage(webDriver);
        String webEmail = tempMailPage.getEmail();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities = JsonUtils.getCapabilitiesFromJson("Device1");
        String appName = capabilities.getCapability("appium:app").toString();
        String newPath = System.getProperty("user.dir") + "\\" + appName;
        capabilities.setCapability("appium:app", newPath);

        mobileDriver =  new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        LoginPage login = new LoginPage(mobileDriver);
        User user = new User();
        user.generateLoginUser();
        user.setEmail(webEmail);
        System.out.println("webEmail: " + webEmail);
        login.login(user);
        login.verifyWrongLogin();
    }
}

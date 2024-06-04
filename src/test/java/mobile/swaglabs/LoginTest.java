package mobile.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginTest {
    RemoteWebDriver driver;

    @Test
    public void setup() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            String path = System.getProperty("user.dir") + "\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";
            System.out.println("Path: " + path);
            capabilities.setCapability("appium:app", path);
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("appium:deviceName", "Pixel_3a_API_34");
            capabilities.setCapability("appium:platformVersion", "11.0");
            capabilities.setCapability("appium:avd", "Pixel_3a_API_34");
            capabilities.setCapability("appium:appPackage", "com.swaglabsmobileapp");
            capabilities.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");
            capabilities.setCapability("appium:unicodeKeyboard", "true");
            capabilities.setCapability("appium:resetKeyboard", "true");

            driver =  new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
//            AndroidDriver driver = null;
//            try {
//                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//            } catch (MalformedURLException e) {
//                System.out.println(e.getMessage());
//            }

// Your test code here. For example, find an element and perform a click action.
            WebElement username = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]"));
            username.sendKeys("abc");
            WebElement password = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]"));
            password.sendKeys("fdkf");
            WebElement login = driver.findElement(By.xpath("//android.widget.TextView[@text=\"LOGIN\"]"));
            login.click();
            Thread.sleep(10000);
            WebElement errorMessage = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]"));
            Assert.assertTrue(errorMessage.isEnabled());
            System.out.println("AAA " + errorMessage.isEnabled());


// Always remember to quit the driver after the test
//            driver.quit();
        }catch(Exception e){
            e.printStackTrace();
        } finally {
        }
    }

}

package api.fullFlow.pageObject;

import com.automation.core.utils.LibMobileGeneric;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.loginApp_cucumber.pojo.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    RemoteWebDriver remoteWebDriver;

    public LoginPage(RemoteWebDriver remoteWebDriver) {
        this.remoteWebDriver = remoteWebDriver;
        PageFactory.initElements(new AppiumFieldDecorator(remoteWebDriver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.loginmodule.learning:id/textInputEditTextEmail\"]")
    @iOSXCUITFindBy(id = "com.loginmodule.learning:id/textInputEditTextEmail")
    WebElement txtEmail;
    @AndroidFindBy(id = "com.loginmodule.learning:id/textInputEditTextPassword")
    WebElement txtPassword;
    @AndroidFindBy(id = "com.loginmodule.learning:id/appCompatButtonLogin")
    WebElement btnLogin;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.loginmodule.learning:id/snackbar_text\"]")
    WebElement msgWrongLogin;

    public void login(User user) throws InterruptedException {
//        Thread.sleep(Duration.ofSeconds(20));
//        LibMobileGeneric.waitForElementVisible(remoteWebDriver,txtEmail, Duration.ofSeconds(60));
        txtEmail.sendKeys(user.getEmail());
//        LibMobileGeneric.waitForElementVisible(remoteWebDriver,txtPassword, Duration.ofSeconds(60));
        txtPassword.sendKeys(user.getPassword());
//        LibMobileGeneric.waitForElementVisible(remoteWebDriver,btnLogin, Duration.ofSeconds(60));
        btnLogin.click();
    }

    public void verifyLoginFail(){
        String actualMessage = msgWrongLogin.getText();
        String expectedMessage = ("Wrong Email or Password");
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}



package mobile.loginApp_cucumber.pageObject;

import com.automation.core.utils.LibMobileGeneric;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.loginApp_cucumber.pojo.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    AppiumDriver driver;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
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
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"No account yet? Create one\"]")
    WebElement btnRegister;

    public void login(User user) {
        LibMobileGeneric.waitForElementVisible(driver,txtEmail, Duration.ofSeconds(60));
        txtEmail.sendKeys(user.getEmail());
        LibMobileGeneric.waitForElementVisible(driver,txtPassword, Duration.ofSeconds(60));
        txtPassword.sendKeys(user.getPassword());
        LibMobileGeneric.waitForElementVisible(driver,btnLogin, Duration.ofSeconds(60));
        btnLogin.click();
    }

    public void verifyWrongLogin() {
        String actualMessage = msgWrongLogin.getText();
        String expectedMessage = ("Wrong Email or Password");
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    public void verifyLoginSuccess(){
        String actualMessage = msgWrongLogin.getText();
        String expectedMessage = ("Wrong Email or Password");
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    public void clickRegister() throws InterruptedException {
        LibMobileGeneric.scrollDown(driver);
        btnRegister.click();
    }
}

package mobile.loginApp_cucumber.pageObject;

import com.automation.core.utils.LibMobileGeneric;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobile.loginApp_cucumber.pojo.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class RegisterPage {
    AppiumDriver driver;

    public RegisterPage (AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy (id = "com.loginmodule.learning:id/textInputEditTextName")
    WebElement txtName;
    @AndroidFindBy (id = "com.loginmodule.learning:id/textInputEditTextEmail")
    WebElement txtEmail;
    @AndroidFindBy (id ="com.loginmodule.learning:id/textInputEditTextPassword")
    WebElement txtPassword;
    @AndroidFindBy (id ="com.loginmodule.learning:id/textInputEditTextConfirmPassword")
    WebElement txtConfirmPassword;
    @AndroidFindBy (id = "com.loginmodule.learning:id/appCompatButtonRegister")
    WebElement btnRegister;
    @AndroidFindBy (id = "com.loginmodule.learning:id/appCompatTextViewLoginLink")
    WebElement btnLogin;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Enter Full Name\"]")
    WebElement msgName;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Enter Valid Email\"]")
    WebElement msgEmail;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Enter Password\"]")
    WebElement msgPassword;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Password Does Not Matches\"]")
    WebElement msgConfirmPassword;

    public void registerUser(User user){
        LibMobileGeneric.waitForElementVisible(driver,txtName, Duration.ofSeconds(30));
        txtName.sendKeys(user.getName());
        txtEmail.sendKeys(user.getEmail());
        txtPassword.sendKeys(user.getPassword());
        txtConfirmPassword.sendKeys(user.getConfirmPassword());
        LibMobileGeneric.scrollDown(driver);
        btnRegister.click();
    }

    public void clickLogin(){
        LibMobileGeneric.scrollDown(driver);
        btnLogin.click();
    }
    public void verifyEmptyName(){
        String expected = "Enter Full Name";
        String actual = msgName.getText();
        Assert.assertEquals(expected,actual,"Empty Name message true");
    }
    public void emptyEmail(User user){
        LibMobileGeneric.waitForElementVisible(driver,txtName, Duration.ofSeconds(30));
        txtName.sendKeys(user.getName());
        txtEmail.sendKeys("");
        txtPassword.sendKeys(user.getPassword());
        txtConfirmPassword.sendKeys(user.getConfirmPassword());
        LibMobileGeneric.scrollDown(driver);
        btnRegister.click();
    }
    public void verifyEmptyEmail() {
        String expected = "Enter Valid Email";
        LibMobileGeneric.waitForElementVisible(driver, msgEmail, Duration.ofSeconds(30) );
        String actual = msgEmail.getText();
        Assert.assertEquals(expected, actual, "Empty Email message true");
    }

    public void emptyPassword(){
        txtName.sendKeys("Test");
        txtEmail.sendKeys("aaa@gmail.com");
//        txtPassword.sendKeys("123456");
        txtConfirmPassword.sendKeys("123456");
        btnRegister.click();
    }

    public void verifyEmptyPassword() {
        String expected = "Enter Password";
        String actual = msgPassword.getText();
        Assert.assertEquals(expected, actual, "Empty Password message true");
    }

    public void emptyConfirmPassword(){
        txtName.sendKeys("Test");
        txtEmail.sendKeys("aaa@gmail.com");
        txtPassword.sendKeys("123456");
//        txtConfirmPassword.sendKeys("123456");
        btnRegister.click();
    }

    public void verifyEmptyConfirmPassword() {
        String expected = "Password Does Not Matches";
        String actual = msgConfirmPassword.getText();
        Assert.assertEquals(expected, actual, "Empty Confirm Password message true");
    }
}

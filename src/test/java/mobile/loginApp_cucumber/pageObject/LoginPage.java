package mobile.loginApp_cucumber.pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import mobile.loginApp_cucumber.pojo.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    AppiumDriver driver;

    public LoginPage (AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id ="com.loginmodule.learning:id/textInputEditTextEmail")
    @iOSXCUITFindBy(id ="com.loginmodule.learning:id/textInputEditTextEmail")
    WebElement txtEmail;
    @AndroidFindBy (id = "com.loginmodule.learning:id/textInputEditTextPassword" )
    WebElement txtPassword;
    @AndroidFindBy (id ="com.loginmodule.learning:id/appCompatButtonLogin")
    WebElement btnLogin;
    @AndroidFindBy (xpath = "//android.widget.TextView[@resource-id=\"com.loginmodule.learning:id/snackbar_text\"]")
    WebElement msgWrongLogin;

    public void login (User user){
        txtEmail.sendKeys(user.getEmail());
        txtPassword.sendKeys(user.getPassword());
        btnLogin.click();
    }

    public void verifyWrongLogin(){
        String actualMessage = msgWrongLogin.getText();
        String expectedMessage = ("Wrong Email or Password");
        Assert.assertEquals(actualMessage,expectedMessage);
    }

}

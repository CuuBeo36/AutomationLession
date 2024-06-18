package mobile.loginApp_cucumber.pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobile.loginApp_cucumber.pojo.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    AppiumDriver driver;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.loginmodule.learning:id/textEmail")
    WebElement txtEmail;
    @AndroidFindBy(id = "com.loginmodule.learning:id/textEmail")
    WebElement txtPassword;

    public void verifyLoggedEmail() {
        String actualEmail = txtEmail.getText();
        User user = new User();
        String expectedEmail = user.getEmail();
        Assert.assertEquals(actualEmail, expectedEmail, "Login success");
    }
}

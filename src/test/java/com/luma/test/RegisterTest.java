package com.luma.test;

import com.luma.pageObject.CreatePage;
import com.luma.pageObject.HomePage;
import com.luma.pojo.SignInUser;
import com.luma.utils.Env;
import com.luma.utils.Message;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTest extends BaseClass {
    static Logger log = Logger.getLogger(com.luma.test.RegisterTest.class.getName());

    @Test(description = "Full information")
    public void testRegisterFull() throws InterruptedException {
        SignInUser user = new SignInUser();
        user.generateUser();

        HomePage homePage = new HomePage(getDriver());
        homePage.clickCreateAccount();

        CreatePage createPage = new CreatePage(getDriver());
        createPage.register(user);

        String expectedMessage = Message.getProperty("CreateAccountSuccess");
        createPage.verifySuccessMessage(expectedMessage);
    }
}


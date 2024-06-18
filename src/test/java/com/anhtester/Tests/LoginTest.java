package com.anhtester.Tests;

import com.anhtester.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest {
    LoginPage loginPage;
    private WebDriver driver;

    @Test
    public void testLoginSuccess() {
        loginPage = new LoginPage(driver);

        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginWithEmailInvalid() {
        loginPage = new LoginPage(driver);

        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM("admin123@example.com", "123456");
        loginPage.verifyLoginFail();
    }
}

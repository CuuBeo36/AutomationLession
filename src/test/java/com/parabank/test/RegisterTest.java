package com.parabank.test;

import com.parabank.pageObject.HomePage;
import com.parabank.pageObject.RegisterPage;
import com.parabank.pojo.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class RegisterTest {

    @Test
    public void testRegister() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        HomePage homePage = new HomePage(driver);

        String baseUrl = homePage.baseUrl;

        driver.get(baseUrl);
        homePage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(user.getFirstName(), user.getLastName());

        driver.quit();
    }
}

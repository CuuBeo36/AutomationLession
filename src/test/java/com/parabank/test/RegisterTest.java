package com.parabank.test;
import com.github.javafaker.Faker;
import com.parabank.pageObject.HomePage;
import com.parabank.pageObject.RegisterPage;
import com.parabank.pojo.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTest {
    @Test
    public void testRegisterSuccess() throws InterruptedException {
        User user = new User();
        Faker faker = new Faker();
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setAddress("Hill");
        user.setCity("LA");
        user.setState("US");
        user.setZipCode("12345");
        user.setPhoneNumber("090011111111");
        user.setSsn("123");
        user.setUsername("JohnD");
        user.setPassword("P12345678");
        user.setConfirmPassword("P12345678");

        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        HomePage homePage = new HomePage(driver);
        String baseUrl = homePage.baseUrl;
        driver.get(baseUrl);
        homePage.clickRegisterLink();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(user);
        Thread.sleep(60000);
        driver.quit();
    }
}

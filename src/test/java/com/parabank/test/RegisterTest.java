package com.parabank.test;
import com.parabank.pageObject.HomePage;
import com.parabank.pageObject.RegisterPage;
import com.parabank.pojo.User;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTest {
    @Test
    public void testRegister() {
        User user = new User();
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
        registerPage.register(user.getFirstName(),
                user.getLastName(),
                user.getAddress(),
                user.getCity(),
                user.getState(),
                user.getZipCode(),
                user.getPhoneNumber(),
                user.getSsn(),
                user.getUsername(),
                user.getPassword(),
                user.getConfirmPassword());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.quit();
    }
}

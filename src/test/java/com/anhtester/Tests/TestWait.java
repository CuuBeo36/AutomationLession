package com.anhtester.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestWait {
    WebDriver driver;

    @Test(priority = 1)
    public void demoImplicitWait() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Set timeout for implicitlyWait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://hrm.anhtester.com/");

        driver.findElement(By.id("iusername")).sendKeys("admin_example");
        driver.findElement(By.id("ipassword")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Click menu dự án
        driver.findElement(By.xpath("//span[contains(text(),'Projects')]")).click();

        Thread.sleep(2000);
        driver.quit();
    }
    @Test(priority = 2)
    public void ExplicitWaitDemo() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Created Driver");
        driver.manage().window().maximize();

        driver.get("https://app.hrsale.com/");

        //Set timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("iusername")).sendKeys("frances.burns");
        driver.findElement(By.id("ipassword")).sendKeys("frances.burns");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Click menu dự án
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Projects')]")));

        driver.findElement(By.xpath("//span[contains(text(),'Projects')]")).click();

        Thread.sleep(2000);
        driver.quit();
    }
}

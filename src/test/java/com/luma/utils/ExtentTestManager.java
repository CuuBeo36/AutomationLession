package com.luma.utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class ExtentTestManager {
    private WebDriver driver;
    private ExtentTest extentTest;

    public ExtentTestManager(WebDriver driver, ExtentTest extentTest) {
        this.driver = driver;
        this.extentTest = extentTest;
    }

    public void captureAndAttachScreenshot() {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            String screenshotBase64 = ts.getScreenshotAs(OutputType.BASE64);
            extentTest.fail("details", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());
        } catch (Exception e) {
            extentTest.fail("Test Failed, cannot attach screenshot");
        }
    }
    public void captureAndAttachFullPageScreenshot() {
        try {
            Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
            BufferedImage image = screenshot.getImage();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                ImageIO.write(image, "png", baos);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            String base64Screenshot = Base64.getEncoder().encodeToString(imageInByte);
            extentTest.fail("details", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        } catch (IOException e) {
            extentTest.fail("Test Failed, cannot attach screenshot");
        }
    }
}

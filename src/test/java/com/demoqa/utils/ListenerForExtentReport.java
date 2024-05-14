package com.demoqa.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.demoqa.test.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class ListenerForExtentReport extends ExtentReport implements ITestListener {
    private static ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();
    ExtentReports extent = reportGenerator();
    ExtentTest test;

    public void onTestStart(ITestResult result) {
        System.out.println("Start of Test" + result.getName());
        test = extent.createTest(result.getName());
        extenttest.set(test);
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Success of Test" + result.getName());
        extenttest.get().log(Status.PASS, "Successful");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Failure of Test" + result.getName());
        extenttest.get().log(Status.FAIL, result.getThrowable());

        try {
            Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(BaseClass.getDriver());
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
            extenttest.get().fail("details", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        } catch (IOException e) {
            extenttest.get().fail("Test Failed, cannot attach screenshot");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        extent.flush();
    }

}

package com.ultimateqa.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
    ExtentReports extent;

    public ExtentReports reportGenerator() {
        String path = System.getProperty("user.dir") + "\\Reports\\Report.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("UltimateQA Page");
        reporter.config().setDocumentTitle("Test Results");
        reporter.config().setTheme(Theme.STANDARD);
        reporter.config().setOfflineMode(true);
        reporter.config().setProtocol(Protocol.HTTP);
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        return extent;
    }
}

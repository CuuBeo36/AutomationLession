package com.demoqa_cucumber.runner;

import com.demoqa_cucumber.utils.Env;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

@CucumberOptions(tags = "", features = {"src/test/resources/demoqa_features"}, plugin = {}, glue = "com.demoqa_cucumber.definitions")
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
}
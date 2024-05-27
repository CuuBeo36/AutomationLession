package com.ultimateqa.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/ultimateqa_feature"}, plugin = {}, glue = "com.ultimateqa.definitions")
public class CucumberRunnerTests  extends AbstractTestNGCucumberTests {
}

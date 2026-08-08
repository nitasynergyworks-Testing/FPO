package com.fpo.utils;

import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.fpo.base.BaseTest;

import java.io.File;

import static com.fpo.utils.ExtentManager.extent;

public class TestListener
        implements ITestListener {

    public static ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getName());
    }


    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        String screenshot = "";
        try {

            screenshot = ScreenshotUtil.capture(
                    BaseTest.driver,
                    result.getName());

           // test.addScreenCaptureFromPath(screenshot);

           
            String base64 =
                    ((TakesScreenshot) BaseTest.driver)
                            .getScreenshotAs(OutputType.BASE64);

            test.fail("Screenshot",
                    MediaEntityBuilder
                            .createScreenCaptureFromBase64String(base64)
                            .build());
            test.fail(result.getThrowable());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }




}
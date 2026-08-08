package com.fpo.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

import static com.fpo.base.BaseTest.driver;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        String screenshotDir =
                System.getProperty("user.dir") + "/reports/screenshots/";

        String screenshotPath =
                screenshotDir + testName + "_" +
                        System.currentTimeMillis() + ".png";

        try {
            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(src, new File(screenshotPath));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }


    public static String capture(WebDriver driver, String name) {
        return name;
    }
}
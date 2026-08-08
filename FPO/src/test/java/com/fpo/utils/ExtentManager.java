package com.fpo.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    static ExtentReports extent =
            ExtentManager.getInstance();

    public static ExtentReports getInstance() {

        if (extent == null) {

            String timestamp = new SimpleDateFormat(
                    "yyyyMMdd_HHmmss_SSS")
                    .format(new Date());

            String reportName =
                    "FPO_Report_" + timestamp + ".html";

            String reportPath =
                    System.getProperty("user.dir")
                            + "/reports/" + reportName;

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(reportPath);

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
    }
}
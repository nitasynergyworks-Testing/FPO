package com.fpo.pages;

import com.fpo.utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class Dashboard {

    WebDriver driver;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
    }


    private By Dashboardlink = By.xpath("//a[@href='/dashboard']");
    private By GetFPOCount = By.xpath("//p[text()='FPOs']/../div/p");
    private By TypeCompanyFilter = By.xpath("//input[@id='type-company']");
    private By StatusFilterExpand = By.xpath("//h4[text()='Status']/../button/div");
    private By StatusFilterSelectionActive = By.xpath("//input[@id='mobile-efiling-active']");
    private By StatesAndUtsFilterExpand = By.xpath("//h4[text()='States and UTs']/../button");
    private By StatesAndUtsFilterselection = By.xpath("//input[@id='mobile-state-BIHAR']");
    private By ClosePromptText = By.xpath("//button[text()='✕']");


    public void DashboardVerifiecation() throws InterruptedException {
        TestListener.test.info("Launch the application  " );
        driver.findElement(Dashboardlink).click();
        Thread.sleep(5000);
        TestListener.test.info("Moved to  Dashboard screen page " );
        driver.findElement(ClosePromptText).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(GetFPOCount).getText());

        TestListener.test.info("Get FPo count without filter = " + driver.findElement(GetFPOCount).getText());
        driver.findElement(TypeCompanyFilter).click();
        TestListener.test.info("Apply company filter on Dashboard screen page " );
        Thread.sleep(10000);
        driver.findElement(StatusFilterExpand).click();
        TestListener.test.info("Apply Status filter on Dashboard screen page " );
        Thread.sleep(2000);
        driver.findElement(StatusFilterSelectionActive).click();
        Thread.sleep(10000);
        driver.findElement(StatesAndUtsFilterExpand).click();
        Thread.sleep(2000);
        driver.findElement(StatesAndUtsFilterselection).click();
        TestListener.test.info("Apply States filter on Dashboard screen page " );
        Thread.sleep(15000);
        System.out.println(driver.findElement(GetFPOCount).getText());
        TestListener.test.info("Get FPo count without filter = " + driver.findElement(GetFPOCount).getText());
        if (driver.findElement(GetFPOCount).isDisplayed()) {
            Reporter.log("Dashboard Page FPO count is  displayed", true);
        } else {
            Assert.fail("Dashboard Page FPO count is not displayed");
        }

    }
}

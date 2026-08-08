package com.fpo.pages;

import com.fpo.utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }


    private By ConnectPageLink = By.xpath("//a[@href='/fpo-connect']");
    private By ClosePromptText = By.xpath("//button[text()='✕']");

    public void HomePageVerification() throws InterruptedException {
        TestListener.test.info("Launch the application  " );
        driver.findElement(ClosePromptText).click();
        Thread.sleep(1000);
        TestListener.test.info("Close the Prompt Text pop-up " );
        if (driver.findElement(ConnectPageLink).isDisplayed()) {
            Reporter.log("Home Page link is not displayed", true);
        } else {
            Assert.fail("Home Page link is not displayed");
        }
        if (driver.findElement(ConnectPageLink).isEnabled()) {
            Reporter.log("Home Page link is not displayed", true);
        } else {
            Assert.fail("Home Page link is not displayed");
        }
        TestListener.test.info("Connect Page link is displayed" );
        driver.findElement(ConnectPageLink).click();

        Thread.sleep(5000);
        TestListener.test.info("Navigate to Connect Page link is displayed" );
    }

}

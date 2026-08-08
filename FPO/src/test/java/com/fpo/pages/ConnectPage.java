package com.fpo.pages;

import com.fpo.utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.List;


public class ConnectPage {

    WebDriver driver;

    public ConnectPage(WebDriver driver) {
        this.driver = driver;
    }


    private By connectPagelink = By.xpath("//a[@href='/fpo-connect']");
    private By FirstFpo = By.xpath("//*[@id='root']/div/div[1]/div[2]/div/div/div[3]/main/div[1]/div/div[1]");
    private By MemberDisplay = By.xpath("//p[text()='Members']");
    private By ClosePromptText = By.xpath("//button[text()='✕']");





    public void ConnectPageVerifiecation() throws InterruptedException {
        Thread.sleep(5000);
        TestListener.test.info("Launch the application  " );
        driver.findElement(ClosePromptText).click();
        Thread.sleep(1000);
        driver.findElement(connectPagelink).click();
        Thread.sleep(5000);
        TestListener.test.info("Moved to connect page  " );

        List<WebElement> elements = driver.findElements(
                By.xpath("//*[@id='root']/div/div[1]/div[2]/div/div/div[3]/main/div[1]/div"));

        int count = elements.size();

        TestListener.test.info("Total Records Found = " + count);
        TestListener.test.info("Connect page data has been verified" );

        Assert.assertTrue(count > 0,
                "No records found on Connect page");

}

    public void FPOProfileVerifiecation() throws InterruptedException {
        TestListener.test.info("Launch the application  " );
        Thread.sleep(5000);
        driver.findElement(ClosePromptText).click();
        Thread.sleep(1000);
        driver.findElement(connectPagelink).click();
        Thread.sleep(5000);
        TestListener.test.info("Moved to connect page  " );
        driver.findElement(FirstFpo).click();
        Thread.sleep(5000);
        TestListener.test.info("Open Fpo profile from connect page" );
        if (driver.findElement(MemberDisplay).isDisplayed()) {
            Reporter.log("FPO Profile Page is displayed", true);
            TestListener.test.info("Verified FPo Profile page " );
        } else {
            Assert.fail("FPO Profile Page is not displayed");
        }
    }
}

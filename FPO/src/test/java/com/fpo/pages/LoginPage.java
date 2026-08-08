package com.fpo.pages;

import com.fpo.utils.ConfigReader;
import com.fpo.utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    private By loginButton = By.xpath("//a[text()='Login']");
    private By EmailLoginBTN = By.xpath("//button[text()='Continue with Email']");
    private By EmailEDT = By.xpath("//label[text()='Email']/../input");
    private By PasswordEDT = By.xpath("//input[@type='password']");
    private By submitButton = By.xpath("//button[@type='submit']");
    private By profileLink = By.xpath("//img[@alt='Profile']");
    private By ClosePromptText = By.xpath("//button[text()='✕']");


    public void login() throws InterruptedException {
        TestListener.test.info("Launch the application  " );
        driver.findElement(loginButton).click();

        Thread.sleep(1000);
        driver.findElement(EmailLoginBTN).click();
        Thread.sleep(1000);
        driver.findElement(EmailEDT)
                .sendKeys(ConfigReader.getProperty("username"));
        Thread.sleep(1000);
        driver.findElement(PasswordEDT)
                .sendKeys(ConfigReader.getProperty("password"));

        driver.findElement(submitButton).click();
        Thread.sleep(3000);

        TestListener.test.info("Login Successfully" );
        driver.findElement(ClosePromptText).click();
        Thread.sleep(1000);
        driver.findElement(profileLink).isDisplayed();
        TestListener.test.info("Profile Page displayed" );
        Assert.assertTrue(
                driver.findElement(profileLink).isDisplayed(),
                "FPO profile link displayed");

    }


    private By MyAccountLink = By.xpath("//a[text()='My Account']");
    private By ClaimButton = By.xpath("//span[text()='Claims']");

    public void ProfileVerification() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(profileLink).click();
        TestListener.test.info("Navigate to Profile Page" );
        Thread.sleep(3000);
        System.out.println(driver.findElement(profileLink).getText());
        if (driver.findElement(profileLink).isDisplayed()) {
            Reporter.log("FPO profile link is  displayed", true);
        } else {
            Assert.fail("FPO profile link is not displayed");
        }
        System.out.println(driver.findElement(MyAccountLink).getText());
        driver.findElement(MyAccountLink).click();
        Thread.sleep(5000);

        if (driver.findElement(ClaimButton).isDisplayed()) {
            Reporter.log("FPO profile Claim link is  displayed", true);
        } else {
            Assert.fail("FPO profile Claim link is not displayed");
        }
        System.out.println(driver.findElement(ClaimButton).getText());
        driver.findElement(ClaimButton).click();
        Thread.sleep(1000);
        TestListener.test.info("Claim Page displayed under profile verification" );

    }
}

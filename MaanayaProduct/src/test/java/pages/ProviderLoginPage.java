package pages;

import common.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static common.Utils.generateUniqueEmail;

public class ProviderLoginPage {

    WebDriver driver;
    WebDriverWait wait;
    int uniqueNumber = (int) (System.currentTimeMillis() % 100000);

    public ProviderLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By username = By.xpath("//input[@placeholder='Email']");
    By password = By.xpath("//input[@placeholder='Password']");
    By signInBtn = By.xpath("//button[text()='Sign In']");
    By SignUp = By.xpath("//a[text()='Sign Up here']");
    By FotgotPasswordBTN = By.xpath("//a[text()='Forgot Password ?']");
    By FirstNameEDT = By.xpath("//input[@name='firstName']");
    By MiddleNameEDT = By.xpath("//input[@name='middleName']");
    By LastNameEDT = By.xpath("//input[@name='lastName']");
    By GenderDropDown = By.xpath("//input[@name='lastName']");
    By PhoneEDT = By.xpath("//input[@name='phone']");
    By DOBEDT = By.xpath("//label[contains(text(),'Date')]/../div/div/input");
    By EmailEDT = By.xpath("//input[@name='email']");
    By PasswordEDT = By.xpath("//input[@name='password']");
    By ConfPasswordEDT = By.xpath("//input[@name='confirmPassword']");
    By RagistrationNumberEDT = By.xpath("//input[@name='registrationNumber']");
    By BioEDT = By.xpath("//textarea[@name='bio']");
    By QualificationDRP = By.xpath("//label[text()='Qualification ']/../select/option");
    By QualificationsOptionSelextion= By.xpath("//label[text()='Qualification ']/../select/option[3]");
    By SpecializationDRP = By.xpath("//label[text()='Specialization ']/../select/option[1]");
    By SpecializationOptionSelextion = By.xpath("//label[text()='Specialization ']/../select/option[6]");
    By ExpertiseDRP = By.xpath("//label[text()='Expertise ']/../select");
    By ExpertiseOptionSelextion = By.xpath("//label[text()='Expertise ']/../select/option[5]");







    public void ProviderSignUp() throws InterruptedException {
        Thread.sleep(10000);
        wait.until(ExpectedConditions.elementToBeClickable(SignUp)).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(FirstNameEDT)).sendKeys("Mohit");
        wait.until(ExpectedConditions.elementToBeClickable(LastNameEDT)).sendKeys("Panda");
        wait.until(ExpectedConditions.elementToBeClickable(EmailEDT)).sendKeys(generateUniqueEmail());
        wait.until(ExpectedConditions.elementToBeClickable(PasswordEDT)).sendKeys("Qwerty@123");
        wait.until(ExpectedConditions.elementToBeClickable(ConfPasswordEDT)).sendKeys("Qwerty@123");
        wait.until(ExpectedConditions.elementToBeClickable(BioEDT)).sendKeys("I am here to Automate this page ");
        wait.until(ExpectedConditions.elementToBeClickable(RagistrationNumberEDT)).sendKeys(String.valueOf(uniqueNumber));
        wait.until(ExpectedConditions.elementToBeClickable(QualificationDRP)).click();
        Thread.sleep(8000);
        wait.until(ExpectedConditions.elementToBeClickable(QualificationsOptionSelextion)).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(SpecializationDRP)).click();
        Thread.sleep(8000);
        wait.until(ExpectedConditions.elementToBeClickable(SpecializationOptionSelextion)).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(ExpertiseDRP)).click();
        Thread.sleep(8000);
        wait.until(ExpectedConditions.elementToBeClickable(ExpertiseOptionSelextion)).click();
        Thread.sleep(5000);

    }
}


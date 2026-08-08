package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By username = By.xpath("//input[@placeholder='Email']");
    By password = By.xpath("//input[@placeholder='Password']");
    By signInBtn = By.xpath("//button[text()='Sign In']");
    By loginBtn = By.xpath("//button[text()='Login']");
    By adminText = By.xpath("//div[text()='Admin']");

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(signInBtn).click();
    }

    public void enterOTP() throws InterruptedException {
        for (int i = 1; i <= 4; i++) {
            Thread.sleep(1000);
            By otp = By.xpath("(//input[@type='text'])[" + i + "]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(otp)).sendKeys("1");
        }
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public String getAdminText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(adminText)).getText();
    }

    public boolean LoginFielddisplay() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(username)).isDisplayed();
    }
}

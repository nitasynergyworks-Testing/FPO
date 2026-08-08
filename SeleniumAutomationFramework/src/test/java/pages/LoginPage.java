package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By email = By.xpath("//input[@placeholder='Email']");
    By password = By.xpath("//input[@placeholder='Password']");
    By signIn = By.xpath("//button[text()='Sign In']");

    public void enterEmail(String user) {
        driver.findElement(email).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickSignIn() {
        driver.findElement(signIn).click();
    }
}
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserLogin {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage = new LoginPage(driver);


    public  UserLogin(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void adminLogin() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://dev-admin.maaanaya.com/login");
        loginPage.login("deepakaw@gmail.com", "Pass@12345");
        loginPage.enterOTP();
        loginPage.clickLogin();
        System.out.println("Login Successfully :)");
    }


    public void providerLogin() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://dev-provider.maaanaya.com/login");
    }

    public void PatientsLogin() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://dev-patient.maaanaya.com/login");
    }
}

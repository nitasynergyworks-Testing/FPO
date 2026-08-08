package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//
//        options.setExperimentalOption("useAutomationExtension", false);
//        options.addArguments("--disable-blink-features=AutomationControlled");
//        driver = new ChromeDriver(options);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://admin.telesecure360.com/login");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

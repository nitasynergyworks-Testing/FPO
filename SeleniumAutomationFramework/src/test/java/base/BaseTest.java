package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utilities.ConfigReader;

import java.time.Duration;

public class BaseTest {

    @BeforeMethod
    public void setup() {

        DriverFactory.initDriver();

        DriverFactory.getDriver().get(
                ConfigReader.getProperty("url")
        );
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}
package com.fpo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.fpo.utils.ConfigReader;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void setup() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        String browser = ConfigReader.getProperty("browser");
        String headless = ConfigReader.getProperty("headless");

        if (browser.equalsIgnoreCase("chrome")) {

            if ("true".equalsIgnoreCase(headless)) {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");
            }

            options.setExperimentalOption(
                    "excludeSwitches",
                    new String[]{"enable-automation"});

            driver = new ChromeDriver(options);

            driver.manage().timeouts().implicitlyWait(
                    Duration.ofSeconds(10));

            driver.manage().timeouts().pageLoadTimeout(
                    Duration.ofSeconds(60));

            driver.manage().timeouts().scriptTimeout(
                    Duration.ofSeconds(30));

            driver.get(ConfigReader.getProperty("url"));
        }
    }
    public void tearDown() {

        if(driver != null) {
            driver.quit();
        }
    }
}

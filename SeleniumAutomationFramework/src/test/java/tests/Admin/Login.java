package tests.Admin;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import static base.DriverFactory.driver;

public class Login extends BaseTest {

    @Test
    public void Login() {

        LoginPage login = new LoginPage(driver);

        login.enterEmail("myhcare-admin@gmail.com");
        login.enterPassword("Qwerty@123");

        login.clickSignIn();

        System.out.println("Login Successful");
    }
}

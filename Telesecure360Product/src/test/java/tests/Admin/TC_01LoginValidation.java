package tests.Admin;

import base.BaseTest;
import pages.LoginPage;
import org.testng.annotations.Test;

public class TC_01LoginValidation extends BaseTest {

    @Test
    public void T30AdminLogin() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("myhcare-admin@gmail.com", "Qwerty@123");
        loginPage.enterOTP();
        loginPage.clickLogin();

        System.out.println("Login Successfully :)");
        System.out.println("Login User Name Text - " + loginPage.getAdminText());
    }
}

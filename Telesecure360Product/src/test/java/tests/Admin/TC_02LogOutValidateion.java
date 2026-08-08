package tests.Admin;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TC_02LogOutValidateion extends BaseTest {

    @Test
    public void T30AdminLogout() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage dashboard = new HomePage(driver);

        loginPage.login("myhcare-admin@gmail.com", "Qwerty@123");
        loginPage.enterOTP();
        loginPage.clickLogin();

        System.out.println("Login Successfully :)");
        Thread.sleep(2000);
        dashboard.clickLogoutBTN();
        dashboard.clickLogoutCNFBTN();
        System.out.println("Login button is Available ;- "+loginPage.LoginFielddisplay());
    }
}

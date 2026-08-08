package tests.Admin;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TC_01LoginLououtValidation extends BaseTest {

    @Test
    public void T30AdminLogin() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage dashboard = new HomePage(driver);

        loginPage.login("deepakaw@gmail.com", "Pass@12345");
        loginPage.enterOTP();
        loginPage.clickLogin();

        System.out.println("Login Successfully :)");
        System.out.println("Login User Name Text - " + loginPage.getAdminText());
        Thread.sleep(2000);
        dashboard.clickLogoutBTN();
        dashboard.clickLogoutCNFBTN();
        System.out.println("Login button is Available ;- "+loginPage.LoginFielddisplay());
    }
}

package tests.Admin;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TC_03ValidateAppointmentsRedirectionaAndCount extends BaseTest {

    @Test
    public void ValidateAppointmentsRedirectionaAndCount() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        HomePage dashboard = new HomePage(driver);

        loginPage.login("myhcare-admin@gmail.com", "Qwerty@123");
        loginPage.enterOTP();
        loginPage.clickLogin();
        System.out.println("Login Successfully :)");

        dashboard.GetcountandredirecttoAppointment();
    }

}

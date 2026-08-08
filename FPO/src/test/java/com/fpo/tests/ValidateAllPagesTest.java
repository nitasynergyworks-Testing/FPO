package com.fpo.tests;


import com.fpo.base.BaseTest;
import com.fpo.pages.ConnectPage;
import com.fpo.pages.Dashboard;
import com.fpo.pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.fpo.utils.TestListener.class)
public class ValidateAllPagesTest extends BaseTest {

    @BeforeMethod
    public void start() {
        setup();
    }


    @Test
    public void verifyDashboardDataTest() throws InterruptedException {

        Dashboard DS = new Dashboard(driver);
        DS.DashboardVerifiecation();

    }

    @Test
    public void verifyFPOProfilePageTest() throws InterruptedException {

        ConnectPage CP = new ConnectPage(driver);
        CP.FPOProfileVerifiecation();

    }

    @Test
    public void verifyConnectPageTest() throws InterruptedException {

        ConnectPage CP = new ConnectPage(driver);
        CP.ConnectPageVerifiecation();
    }

    @Test
    public void verifyHomePageTest() throws InterruptedException {

        HomePage HP = new HomePage(driver);
        HP.HomePageVerification();

    }



    @AfterMethod
    public void close() {
        tearDown();
    }
}

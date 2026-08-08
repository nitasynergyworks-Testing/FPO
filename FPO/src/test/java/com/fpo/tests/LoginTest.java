package com.fpo.tests;

import com.fpo.base.BaseTest;
import com.fpo.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(com.fpo.utils.TestListener.class)
public class LoginTest extends BaseTest {

   @BeforeMethod
    public void start() {
        setup();
    }

    @Test
    public void verifyLoginAndProfileTest() throws InterruptedException {

        LoginPage login = new LoginPage(driver);

        login.login();
        login.ProfileVerification();
    }


   @AfterMethod
    public void close() {
        tearDown();
    }
}

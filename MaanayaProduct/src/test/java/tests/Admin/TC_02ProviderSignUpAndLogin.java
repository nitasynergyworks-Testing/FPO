package tests.Admin;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProviderLoginPage;
import pages.UserLogin;

public class TC_02ProviderSignUpAndLogin extends BaseTest {

    @Test
    public void T30AdminLogout() throws InterruptedException {


        UserLogin userLogin = new UserLogin(driver);
        ProviderLoginPage providerLogin = new ProviderLoginPage(driver);

        userLogin.providerLogin();
        providerLogin.ProviderSignUp();
        Thread.sleep(2000);

    }
}

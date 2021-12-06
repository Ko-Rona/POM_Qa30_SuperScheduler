package scheduler;

import config.ConfigurationScheduler;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.Test;
import schedulerScreens.LoginScreen;
import schedulerScreens.SplashScreen;

public class LoginTest extends ConfigurationScheduler {

    @Test
    public void loginSuccessTest() {
        boolean isFabPresent = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillEmail("hog@gmail.com")
                .fillPassword("12345hoSg!")
                .clickLoginBtn()
                .skipWizard()
                .isFabAddPresent();

        Assert.assertTrue(isFabPresent);
    }

    @Test
    public void loginStartLoginScreen() {
        boolean isFabPresent = new LoginScreen(driver)
                .fillEmail("hog6@gmail.com")
                .fillPassword("12345hoSg!")
                .clickLoginBtn()
                .skipWizard()
                .isFabAddPresent();

        Assert.assertTrue(isFabPresent);
    }

    @Test
    public void loginAuthTestPositive() {
        Auth user = Auth.builder()
                .email("hog6@gmail.com")
                .password("12345hoSg!")
                .build();
        boolean isFabPresent = new LoginScreen(driver)
                .loginComlexPositive(user)
                .skipWizard()
                .isFabAddPresent();

        Assert.assertTrue(isFabPresent);
    }

    @Test
    public void loginTestNegative1() {
        Auth user = Auth.builder()
                .email("hog6gmail.com")
                .password("12345hoSg!")
                .build();
        boolean isLoginBtn = new LoginScreen(driver)
                .loginComlexNegative(user)
                .isLoginBtn();

        Assert.assertTrue(isLoginBtn);
    }

    @Test
    public void loginTestNegative2() {
        Auth user = Auth.builder()
                .email("hog@com")
                .password("12345hoSg!")
                .build();
        boolean isLoginBtn = new LoginScreen(driver)
                .loginComlexNegative(user)
                .isLoginBtn();

        Assert.assertTrue(isLoginBtn);
    }

}

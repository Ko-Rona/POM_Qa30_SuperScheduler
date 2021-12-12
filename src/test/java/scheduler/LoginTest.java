package scheduler;

import config.ConfigurationScheduler;
import config.MyDataProvider;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import schedulerScreens.HomeScreen;
import schedulerScreens.LoginScreen;

public class LoginTest extends ConfigurationScheduler {

    @AfterMethod
    public void post() {
        if (new HomeScreen(driver)
                .isLogged()) {
            new HomeScreen(driver)
                    .setLogout();
        }
    }

    @Test(dataProvider = "loginModelDto", dataProviderClass = MyDataProvider.class)
    public void loginAuthTestPositive2(Auth auth) {
        boolean isBtm = new LoginScreen(driver)
                .loginComplexPositive(auth)
                .skipWizard()
                .isFabAddPresentAssert()
                .openMenu()
                .logOut()
                .isLoginBtn();

        Assert.assertTrue(isBtm);
    }

//    @Test(dataProvider = "loginDto", dataProviderClass = MyDataProvider.class)
//    public void loginSuccessTest(String version, String email, String password) {
//        boolean isFabPresent = new SplashScreen(driver)
//                .checkVersion(version)
//                .fillEmail(email)
//                .fillPassword(password)
//                .clickLoginBtn()
//                .skipWizard()
//                .isFabAddPresent();
//
//
//        Assert.assertTrue(isFabPresent);
//    }

    @Test(dataProvider = "loginDto2", dataProviderClass = MyDataProvider.class)
    public void loginStartLoginScreen(String email, String password) {
        boolean isFabPresent = new LoginScreen(driver)
                .fillEmail(email)
                .fillPassword(password)
                .clickLoginBtn()
                .skipWizard()
                .isFabAddPresent();

        Assert.assertTrue(isFabPresent);
    }

    @Test(dataProvider = "loginModelDto", dataProviderClass = MyDataProvider.class)
    public void loginAuthTestPositive(Auth auth) {
        boolean isFabPresent = new LoginScreen(driver)
                .loginComplexPositive(auth)
                .skipWizard()
                .isFabAddPresent();

        Assert.assertTrue(isFabPresent);
    }

    @Test(dataProvider = "loginCsv", dataProviderClass = MyDataProvider.class)
    public void loginAuthTestPositiveCsv(Auth auth) {
        boolean isFabPresent = new LoginScreen(driver)
                .loginComplexPositive(auth)
                .skipWizard()
                .isFabAddPresent();

        Assert.assertTrue(isFabPresent);
    }

    @Test(dataProvider = "loginNegativeCsv", dataProviderClass = MyDataProvider.class)
    public void loginTestNegative1() {
        Auth user = Auth.builder()
                .email("hog6gmail.com")
                .password("12345hoSg!")
                .build();
        boolean isLoginBtn = new LoginScreen(driver)
                .loginComplexNegative(user)
                .isLoginBtn();


        Assert.assertTrue(isLoginBtn);
    }

    @Test(dataProvider = "loginNegativeCsv", dataProviderClass = MyDataProvider.class)
    public void loginTestNegative2(Auth auth) {
        boolean isLoginBtn = new LoginScreen(driver)
                .loginComplexNegative(auth)
                .isLoginBtn();


        Assert.assertTrue(isLoginBtn);
    }

    @Test(dataProvider = "loginNegativeModelDto", dataProviderClass = MyDataProvider.class)
    public void loginTestNegative3(Auth auth) {
        boolean isLoginBtn = new LoginScreen(driver)
                .loginComplexNegative(auth)
                .checkErrorMessage("Wrong email or password")
                .confirmErrorMessage()
                .isLoginBtn();

        Assert.assertTrue(isLoginBtn);
    }
}

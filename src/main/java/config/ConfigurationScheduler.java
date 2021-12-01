package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class ConfigurationScheduler {

    protected static AppiumDriver<MobileElement> driver;
//    protected static AppiumDriver<IOSElement> driver;
//    protected static AppiumDriver<AndroidElement> driver;

    //    {
//        "platformName": "Android",
//            "deviceName": "Nex",
//            "platformVersion": "8.0",
//            "appPackage": "com.example.svetlana.scheduler",
//            "appActivity": ".presentation.splashScreen.SplashScreenActivity"
//    }
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Nex");
        capabilities.setCapability("platformVersion", "8.0");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, 8.0);
        capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");

        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app", "C:/Tools/v.0.0.3.apk");

        driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

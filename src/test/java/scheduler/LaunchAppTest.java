package scheduler;

import config.ConfigurationScheduler;
import org.testng.Assert;
import org.testng.annotations.Test;
import schedulerScreens.SplashScreen;

//@Listeners(ListenerTestNg.class)

public class LaunchAppTest extends ConfigurationScheduler {

    @Test(enabled = false)
    public void launchTest(){
        logger.info("Start with version 0.0.3");
        String version = new SplashScreen(driver).getCurrencyVersion();
        Assert.assertEquals(version, "0.0.3");
    }
}

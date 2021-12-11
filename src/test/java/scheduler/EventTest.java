package scheduler;

import config.ConfigurationScheduler;
import models.Auth;
import models.Event;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import schedulerScreens.HomeScreen;
import schedulerScreens.LoginScreen;
import schedulerScreens.SplashScreen;

public class EventTest extends ConfigurationScheduler {

    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        new LoginScreen(driver)
                .loginComplexPositive(Auth.builder()
                        .email("hog@gmail.com")
                        .password("12345hoSg!")
                        .build())
                .skipWizard()
                .isFabAddPresent();
    }

    @Test
    public void createNewEventTest(){
        boolean isFabAddPresent = new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(Event.builder()
                        .title("Top")
                        .type("laz")
                        .breaks(2)
                        .wage(50)
                        .build())
                .isFabAddPresent();

        Assert.assertTrue(isFabAddPresent);
    }

    @Test(enabled = false)
    public void createEventComplex(){
        new SplashScreen(driver)
                .checkVersion("0.0.3")
                .loginComplexPositive(Auth.builder()
                        .email("hog@gmail.com")
                        .password("12345hoSg!")
                        .build())
                .skipWizard()
                .initCreationEvent()
                .createNewEvent(Event.builder()
                        .title("Top")
                        .type("laz")
                        .breaks(2)
                        .wage(50)
                        .build())
                .isFabAddPresentAssert();
    }

}

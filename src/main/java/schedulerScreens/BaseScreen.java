package schedulerScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseScreen {

    AppiumDriver<MobileElement> driver;
    Logger logger = LoggerFactory.getLogger(BaseScreen.class);


    public BaseScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void type(MobileElement el, String text) {
        if (text != null) {
            el.click();
            el.clear();
            el.sendKeys(text);
        }
    }

    public void hideKeyBoard() {
        driver.hideKeyboard();
    }

    boolean isDisplayedWithExp(MobileElement el) {
        try {
            should(el, 10);
            return el.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public void should(MobileElement el, int timer) {
        new WebDriverWait(driver, timer).
                until(ExpectedConditions.visibilityOf(el));
    }

    public void shouldHave(MobileElement el, String text, int timer) {
        new WebDriverWait(driver, timer)
                .until(ExpectedConditions.textToBePresentInElement(el, text));
    }

    public void logout(MobileElement el, MobileElement el2){
        el.click();
        el2.click();
    }

}

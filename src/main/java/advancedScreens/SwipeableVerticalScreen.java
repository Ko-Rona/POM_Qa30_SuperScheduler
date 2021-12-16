package advancedScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SwipeableVerticalScreen extends BaseScreenADV {

    public SwipeableVerticalScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='android:id/text1']")
    List<MobileElement> list;
    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement okBtn;

    public SwipeableVerticalScreen swipeVerticalFromDownToUp() {

        MobileElement el = list.get(1);
        Rectangle rect = el.getRect();

        int x = rect.getX() + rect.getWidth() / 2;
        int yFrom = rect.getY() + (rect.getHeight() / 10) * 2;

        int yTo = rect.getY() + (rect.getHeight() / 10) * 8;


        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(x, yFrom))
                .moveTo(PointOption.point(x, yTo))
                .release()
                .perform();

        return this;
    }

    public SwipeableVerticalScreen swipeVerticalFromUpToDown() {

        MobileElement el = list.get(0);
        Rectangle rect = el.getRect();

        int x = rect.getX() + rect.getWidth() / 2;
        int yFrom = rect.getY() + (rect.getHeight() / 10) * 8;

        int yTo = rect.getY() + (rect.getHeight() / 10) * 2;


        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(x, yFrom))
                .moveTo(PointOption.point(x, yTo))
                .release()
                .perform();

        return this;
    }

    public SwipeableVerticalScreen clickOk() {
        okBtn.click();
        return this;
    }
}

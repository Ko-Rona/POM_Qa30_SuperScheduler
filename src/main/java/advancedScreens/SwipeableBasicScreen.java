package advancedScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SwipeableBasicScreen extends BaseScreenADV {

    public SwipeableBasicScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/container' and @class = 'android.widget.FrameLayout']")
    // @FindBy(xpath = "//*[@resource-id='android:id/text1']");
    List<MobileElement> list;

    public SwipeableBasicScreen swipeFromLeftToRight() {
        MobileElement el = list.get(0);
        Rectangle rect = el.getRect();

        int xFrom = rect.getX() + (rect.getWidth() / 10) * 2;
        int y = rect.getY() + rect.getHeight() / 2;

        int xTo = rect.getX() + (rect.getWidth() / 10) * 8;
        //int xTo = rect.getX() - (rect.getWidth()-10);

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom, y))
                .moveTo(PointOption.point(xTo, y))
                .release()
                .perform();

        return this;
    }

    public SwipeableBasicScreen swipeFromRightToLeft() {
        MobileElement el = list.get(0);
        Rectangle rect = el.getRect();

        int xFrom = rect.getX() + (rect.getWidth() / 10) * 8;
        int y = rect.getY() + rect.getHeight() / 2;

        int xTo = rect.getX() + (rect.getWidth() / 10) * 2;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom, y))
                .moveTo(PointOption.point(xTo, y))
                .release()
                .perform();
        return this;
    }
}

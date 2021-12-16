package advansed;

import advancedScreens.DraggScreen;
import configAdvanced.ConfigAdvanced;
import org.testng.annotations.Test;

public class SwipeTest extends ConfigAdvanced {

    @Test
    public void swipeTestLR() {
        new DraggScreen(driver)
                .clickSwipeBtn()
                .selectSwipeableBasic()
                .swipeFromLeftToRight();
    }

    @Test
    public void swipeTestRL() {
        new DraggScreen(driver)
                .clickSwipeBtn()
                .selectSwipeableBasic()
                .swipeFromRightToLeft();
    }

    @Test
    public void swipeTestVertUD() {
        new DraggScreen(driver)
                .clickSwipeBtn()
                .selectSwipeableVertical()
                .swipeVerticalFromDownToUp();
    }

    @Test
    public void swipeTestVertDU() {
        new DraggScreen(driver)
                .clickSwipeBtn()
                .selectSwipeableVertical()
                .swipeVerticalFromUpToDown();
    }

    @Test
    public void swipeTestVertical() {
        new DraggScreen(driver)
                .clickSwipeBtn()
                .selectSwipeableVertical()
                .swipeVerticalFromUpToDown()
                .clickOk()
                .swipeVerticalFromDownToUp();
    }

    @Test
    public void swipeTestVertical2() {
        new DraggScreen(driver)
                .clickSwipeBtn()
                .selectSwipeableVertical()
                .swipeVerticalFromDownToUp()
                .swipeVerticalFromUpToDown()
                .clickOk();
    }

}

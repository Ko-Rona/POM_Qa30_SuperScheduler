package advansed;

import advancedScreens.DraggScreen;
import configAdvanced.ConfigAdvanced;
import org.testng.annotations.Test;

public class SwipeTest extends ConfigAdvanced {

    @Test
    public void swipeTestLR(){
        new DraggScreen(driver)
                .clickSwipeBtn()
                .selectSwipeableBasic()
                .swipeFromLeftToRight();
    }

    @Test
    public void swipeTestRL(){
        new DraggScreen(driver)
                .clickSwipeBtn()
                .selectSwipeableBasic()
                .swipeFromRightToLeft();
    }
}

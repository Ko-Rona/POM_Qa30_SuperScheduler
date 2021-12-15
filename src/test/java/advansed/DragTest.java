package advansed;

import advancedScreens.DraggScreen;
import configAdvanced.ConfigAdvanced;
import org.testng.annotations.Test;

public class DragTest extends ConfigAdvanced {

    @Test
    public void dragDownTest(){
        new DraggScreen(driver)
                .selectDrragableBasic()
                .dragDown(4);
    }

    @Test
    public void dragDownTest2(){
        new DraggScreen(driver)
                .selectDrragableBasic()
                .dragDownWindow();
    }

    @Test
    public void dragUpTest(){
        new DraggScreen(driver)
                .selectDrragableBasic()
                .dragUp();
    }
}

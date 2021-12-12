package advancedScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class DraggScreen extends BaseScreenADV{
    public DraggScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/button'][2]")
    MobileElement selectDraggdable;


    public DraggableBasicScreen selectDrragableBasic(){
        selectDraggdable.click();
        return new DraggableBasicScreen(driver);
    }
}

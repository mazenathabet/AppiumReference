package PageObjects.Views.DragAndDrop;

import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class DragDropPage extends AndroidActions
{
    public DragDropPage(AndroidDriver driver) {
        super(driver);
    }

    By SOURCE = AppiumBy.id("io.appium.android.apis:id/drag_dot_1");
    By RESULT_TEXT = AppiumBy.id("io.appium.android.apis:id/drag_result_text");
    public DragDropPage dragAndDropSource(){
        AndroidActions.dragDropElement(driver.findElement(SOURCE), 640,691);
        return this;
    }

    public String getResultText(){
        return driver.findElement(RESULT_TEXT).getText();
    }
}

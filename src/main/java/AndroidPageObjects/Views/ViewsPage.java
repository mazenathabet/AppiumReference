package AndroidPageObjects.Views;

import AndroidPageObjects.Views.DragAndDrop.DragDropPage;
import AndroidPageObjects.Views.ExpandableList.ExpandableListPage;
import AndroidPageObjects.Views.Gallery.GalleryPage;
import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ViewsPage extends AndroidActions {
    By EXPANDABLE_LIST = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]");
    By GALLERY = AppiumBy.accessibilityId("Gallery");
    By DRAG_DROP = AppiumBy.accessibilityId("Drag and Drop");

    public ViewsPage(AndroidDriver driver) {
        super(driver);
    }

    public ExpandableListPage clickExpandableList() {
        driver.findElement(EXPANDABLE_LIST).click();
        return new ExpandableListPage(driver);
    }

    public ViewsPage scrollToWebView3() {
        AndroidActions.scrollToText("WebView3");
        return this;
    }

    public ViewsPage scrollToTheEnd() {
        AndroidActions.scrollToTheEnd(100, 100, 200, 200, "down", 3.0);
        return this;
    }

    public GalleryPage clickGallery() {
        driver.findElement(GALLERY).click();
        return new GalleryPage(driver);
    }

    public DragDropPage clickDragDrop() {
        driver.findElement(DRAG_DROP).click();
        return new DragDropPage(driver);
    }
}

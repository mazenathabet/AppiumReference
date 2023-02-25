package AndroidTests;

import TestUtils.FrameworkInitialization;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongPressTests extends FrameworkInitialization {

    @Test
    public void longPress() {
        String actualText = mainMenuPage.clickViews()
                .clickExpandableList()
                .clickCustomAdapter()
                .longPressCustomAdapter(2000)
                .getMenuText();
        Assert.assertEquals(actualText, "Sample menu", "Menu title is not correct!!");
    }
}

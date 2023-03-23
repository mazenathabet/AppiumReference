package AndroidTests;

import AndroidPageObjects.MainMenuPage;
import TestUtils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LongPressTests extends TestBase {

    @Test
    public void longPress() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        String actualText = mainMenuPage.clickViews()
                .clickExpandableList()
                .clickCustomAdapter()
                .longPressCustomAdapter(2000)
                .getMenuText();
        Assert.assertEquals(actualText, "Sample menu", "Menu title is not correct!!");
    }
}

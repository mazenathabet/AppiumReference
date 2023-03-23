package AndroidTests;

import AndroidPageObjects.MainMenuPage;
import TestUtils.TestBase;
import org.testng.annotations.Test;

public class ScrollingTests extends TestBase {

    @Test
    public void scrollingIntoViewUsingUIAutomatorTest() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        mainMenuPage.clickViews()
                .scrollToWebView3();
    }

    @Test
    public void scrollingToTheEnd() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        mainMenuPage.clickViews()
                .scrollToTheEnd();
    }

    @Test
    public void scrollingToEndWithCords() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        mainMenuPage.clickViews()
                .scrollToTheEnd();
    }

}

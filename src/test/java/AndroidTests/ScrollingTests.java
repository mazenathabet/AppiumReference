package AndroidTests;

import TestUtils.FrameworkInitialization;
import org.testng.annotations.Test;

public class ScrollingTests extends FrameworkInitialization {

    @Test
    public void scrollingIntoViewUsingUIAutomatorTest(){
        mainMenuPage.clickViews()
                .scrollToWebView3();
    }

    @Test
    public void scrollingToTheEnd(){
        mainMenuPage.clickViews()
                .scrollToTheEnd();
    }

    @Test
    public void scrollingToEndWithCords(){
        mainMenuPage.clickViews()
                .scrollToTheEnd();
    }

}

package IosTests;

import TestUtils.FrameworkInitialization;
import org.testng.annotations.Test;

public class ScrollingTest extends FrameworkInitialization {

    //    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Test
    public void scrollThePage() {
        mainMenuPage1.clickWebViewAndGoBack()
                .goBackHome();
    }
}

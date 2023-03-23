package IosTests;

import TestUtils.TestBase;
import org.testng.annotations.Test;

public class ScrollingTest extends TestBase {

    //    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Test
    public void scrollThePage() {
        mainMenuPage1.clickWebViewAndGoBack()
                .goBackHome();
    }
}

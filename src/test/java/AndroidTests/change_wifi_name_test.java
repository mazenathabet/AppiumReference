package AndroidTests;

import PageObjects.MainMenuPage;
import TestUtils.FrameworkInitialization;
import org.testng.annotations.Test;

public class first_test extends FrameworkInitialization {

    @Test
    public void appium_test(){
        System.out.println("new test");
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
//        mainMenuPage.clickAnimation();
        mainMenuPage.clickPreference();

    }
}

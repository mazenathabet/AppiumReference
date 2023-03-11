package AndroidTests;

import AndroidPageObjects.MainMenuPage;
import AndroidPageObjects.Views.Gallery.GalleryPage;
import TestUtils.FrameworkInitialization;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipingTest extends FrameworkInitialization {

    @Test
    public void swipeImages() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        Assert.assertTrue(mainMenuPage
                        .clickViews()
                        .clickGallery()
                        .clickPhotos()
                        .isFirstImageFocused()
                , "The image has not been swiped");
        Assert.assertFalse(new GalleryPage(driver)
                        .swipeImagesLeft()
                        .isFirstImageFocused()
                , "The image has not been swiped");
    }

}

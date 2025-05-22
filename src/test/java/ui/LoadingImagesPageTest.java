package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.LoadingImagesPage;

public class LoadingImagesPageTest extends BaseTest {

    static LoadingImagesPage loadingImagesPage;

    @BeforeAll
    static void setUp(){
        loadingImagesPage = initUiTest().openLoadingImagesTab();
    }

    @Test
    void checkCompassDisplayed(){
        Assertions.assertTrue(loadingImagesPage.compassIsDisplayed());
    }

    @Test
    void checkCalendarDisplayed(){
        Assertions.assertTrue(loadingImagesPage.calendarIsDisplayed());
    }

    @Test
    void checkCalendarAward(){
        Assertions.assertTrue(loadingImagesPage.awardIsDisplayed());
    }

    @Test
    void checkCalendarLandscape(){
        Assertions.assertTrue(loadingImagesPage.landscapeIsDisplayed());
    }




}

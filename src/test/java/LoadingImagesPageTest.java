import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoadingImagesPage;

public class LoadingImagesPageTest extends BaseTest{

    LoadingImagesPage loadingImagesPage;

    @BeforeEach
    void setUp(){
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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoadingImagesFluentPage;

public class LoadingImagesFluentPageTest extends BaseTest{

    LoadingImagesFluentPage loadingImagesFluentPage;

    @BeforeEach
    void setUp(){
        loadingImagesFluentPage = initUiTest().openLoadingImagesFluentTab();
    }

    @Test
    void allImagesShouldBeVisibleTest() {
        loadingImagesFluentPage
                .checkCompassIsDisplayed()
                .checkCalendarIsDisplayed()
                .checkAwardIsDisplayed()
                .checkLandscapeIsDisplayed();
    }
}

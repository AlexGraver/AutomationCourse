import core.driver.TestDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.NavigationPage;

public class NavigationPageTest extends BaseTest{

    NavigationPage navigationPage;

    @BeforeEach
    void setUp(){
        navigationPage = initUiTest().openNavigationTab();
    }

    @Test
    @DisplayName("Open navigation page test")
    void openNavigationPageTest(){
        Assertions.assertTrue(navigationPage.pageIsOpened());
    }

    @Test
    void paginationNavigationTest(){

        int activePageBeforeNext = navigationPage.checkActivePage();
        navigationPage.clickNext();
        int activePageAfterNext = navigationPage.checkActivePage();
        Assertions.assertEquals(activePageAfterNext, activePageBeforeNext + 1);

        int activePageBeforePrevious = navigationPage.checkActivePage();
        navigationPage.clickPrevious();
        int activePageAfterPrevious = navigationPage.checkActivePage();
        Assertions.assertEquals(activePageBeforePrevious -1, activePageAfterPrevious);
    }

    @Test
    void goToHomePageTest(){
        navigationPage.goToHomePage();
        Assertions.assertEquals("https://bonigarcia.dev/selenium-webdriver-java/index.html", TestDriver.getDriver().getCurrentUrl());
    }





}

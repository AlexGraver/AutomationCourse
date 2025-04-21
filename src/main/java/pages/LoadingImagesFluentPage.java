package pages;

import core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoadingImagesFluentPage extends BasePage {

    public LoadingImagesFluentPage(WebDriver driver) {
        super(driver);
    }

    private static final By COMPASS = By.xpath("//img[@id='compass']");
    private static final By CALENDAR = By.xpath("//img[@id='calendar']");
    private static final By AWARD = By.xpath("//img[@id='award']");
    private static final By LANDSCAPE = By.xpath("//img[@id='landscape']");

    public LoadingImagesFluentPage checkCompassIsDisplayed() {
        boolean isDisplayed = waitUntilElementDisplayed(COMPASS).isDisplayed();
        Assertions.assertTrue(isDisplayed, "Compass image should be displayed");
        return this;
    }

    public LoadingImagesFluentPage checkCalendarIsDisplayed() {
        boolean isDisplayed = waitUntilElementDisplayed(CALENDAR).isDisplayed();
        Assertions.assertTrue(isDisplayed, "Calendar image should be displayed");
        return this;
    }

    public LoadingImagesFluentPage checkAwardIsDisplayed() {
        boolean isDisplayed = waitUntilElementDisplayed(AWARD).isDisplayed();
        Assertions.assertTrue(isDisplayed, "Award image should be displayed");
        return this;
    }

    public LoadingImagesFluentPage checkLandscapeIsDisplayed() {
        boolean isDisplayed = waitUntilElementDisplayed(LANDSCAPE).isDisplayed();
        Assertions.assertTrue(isDisplayed, "Landscape image should be displayed");
        return this;
    }
}

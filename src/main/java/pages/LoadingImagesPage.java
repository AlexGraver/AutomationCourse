package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoadingImagesPage extends BasePage {

    public LoadingImagesPage(WebDriver driver){
        super(driver);
    }

    private static final By COMPASS = By.xpath("//img[@id='compass']");
    private static final By CALENDAR = By.xpath("//img[@id='calendar']");
    private static final By AWARD = By.xpath("//img[@id='award']");
    private static final By LANDSCAPE = By.xpath("//img[@id='landscape']");

    public boolean compassIsDisplayed(){
        return waitUntilElementDisplayed(COMPASS).isDisplayed();
    }

    public boolean calendarIsDisplayed(){
        return waitUntilElementDisplayed(CALENDAR).isDisplayed();
    }

    public boolean awardIsDisplayed(){
        return waitUntilElementDisplayed(AWARD).isDisplayed();
    }

    public boolean landscapeIsDisplayed(){
        return waitUntilElementDisplayed(LANDSCAPE).isDisplayed();
    }



}

package datePicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DatePickerLevel_3 implements IDatePicker{

    private WebDriver driver;

    public DatePickerLevel_3(WebDriver driver) {
        this.driver = driver;
    }

    private static final By SWITCH_TO_LEVEL_4 = By.xpath("(//th[@class=\"datepicker-switch\"])[3]");
    private static final By YEAR_OPTIONS = By.xpath("//span[@class = 'year']");
    private static final By PREV_DECADE = By.xpath("(//th[@class=\"prev\"])[3]");
    private static final By NEXT_DECADE = By.xpath("(//th[@class=\"next\"])[3]");

    @Override
    public List<WebElement> clickNext(){
        driver.findElement(NEXT_DECADE).click();
        return driver.findElements(YEAR_OPTIONS);
    }

    @Override
    public List<WebElement> clickPrev(){
        driver.findElement(PREV_DECADE).click();
        return driver.findElements(YEAR_OPTIONS);
    }

    @Override
    public DatePickerLevel_4 switchToNextLevel(){
        driver.findElement(SWITCH_TO_LEVEL_4).click();
        return new DatePickerLevel_4(driver);
    }
}

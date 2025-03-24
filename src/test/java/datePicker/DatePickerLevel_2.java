package datePicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DatePickerLevel_2 implements IDatePicker {

    private WebDriver driver;

    public DatePickerLevel_2(WebDriver driver) {
        this.driver = driver;
    }

    private static final By SWITCH_TO_LEVEL_3 = By.xpath("(//th[@class=\"datepicker-switch\"])[2]");
    private static final By MONTH_OPTIONS = By.xpath("//span[contains(@class, \"month\")]");
    private static final By PREV_YEAR = By.xpath("(//th[@class=\"prev\"])[2]");
    private static final By NEXT_YEAR = By.xpath("(//th[@class=\"next\"])[2]");



    @Override
    public List<WebElement> clickNext(){
        driver.findElement(NEXT_YEAR).click();
        return driver.findElements(MONTH_OPTIONS);
    }

    @Override
    public List<WebElement> clickPrev(){
        driver.findElement(PREV_YEAR).click();
        return driver.findElements(MONTH_OPTIONS);
    }

    @Override
    public DatePickerLevel_3 switchToNextLevel(){
        driver.findElement(SWITCH_TO_LEVEL_3).click();
        return new DatePickerLevel_3(driver);
    }
}

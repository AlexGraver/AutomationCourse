package datePicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DatePickerLevel_4 implements IDatePicker{

    private WebDriver driver;

    public DatePickerLevel_4(WebDriver driver) {
        this.driver = driver;
    }

    private static final By HEADER = By.xpath("(//th[@class=\"datepicker-switch\"])[3]");
    private static final By PREV_CENTURY = By.xpath("(//th[@class=\"prev\"])[4]");
    private static final By NEXT_CENTURY = By.xpath("(//th[@class=\"next\"])[4]");
    private static final By CENTURY_OPTIONS = By.xpath("//span[@class = 'century']");


    @Override
    public List<WebElement> clickNext(){
        driver.findElement(NEXT_CENTURY).click();
        return driver.findElements(CENTURY_OPTIONS);
    }

    @Override
    public List<WebElement> clickPrev(){
        driver.findElement(PREV_CENTURY).click();
        return driver.findElements(CENTURY_OPTIONS);
    }

    @Override
    public DatePickerLevel_4 switchToNextLevel(){
        driver.findElement(HEADER).click();
        return new DatePickerLevel_4(driver);
    }
}

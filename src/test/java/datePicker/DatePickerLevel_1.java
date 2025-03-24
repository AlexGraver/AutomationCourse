package datePicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DatePickerLevel_1 implements IDatePicker{

    private WebDriver driver;

    public DatePickerLevel_1(WebDriver driver){
        this.driver = driver;
    }

    private static final By SWITCH_TO_LEVEL_2 = By.xpath("(//th[@class='datepicker-switch'])[1]");
    private static final By DAY_OPTIONS = By.xpath("//*[@class=\"day\"]");
    private static final By PREV_MONTH = By.xpath("(//th[@class=\"prev\"])[1]");
    private static final By NEXT_MONTH = By.xpath("(//th[@class=\"next\"])[1]");

    @Override
    public List<WebElement> clickNext(){
        driver.findElement(NEXT_MONTH).click();
        return driver.findElements(DAY_OPTIONS);
    }

    @Override
    public List<WebElement> clickPrev(){
        driver.findElement(PREV_MONTH).click();
        return driver.findElements(DAY_OPTIONS);
    }

    @Override
    public DatePickerLevel_2 switchToNextLevel(){
        driver.findElement(SWITCH_TO_LEVEL_2).click();
        return new DatePickerLevel_2(driver);
    }

    public void selectDay(String day){
        List<WebElement> days = driver.findElements(DAY_OPTIONS);
        int dayNumber = Integer.parseInt(day);
        if(dayNumber > days.size() || dayNumber < 1){
            throw new IllegalArgumentException("Current month doesn't have such date");
        }
        for(WebElement d: days){
            if(d.getText().equals(day)){
                d.click();
                break;
            }
        }
    }
}

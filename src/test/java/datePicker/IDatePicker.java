package datePicker;

import org.openqa.selenium.WebElement;

import java.util.List;

public interface IDatePicker {
    List<WebElement> clickNext();
    List<WebElement> clickPrev();
    Object switchToNextLevel();
}

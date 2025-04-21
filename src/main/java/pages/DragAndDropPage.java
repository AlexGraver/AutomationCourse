package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage extends BasePage {

    public DragAndDropPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='display-6']")
    private WebElement headerDragDrop;

    @FindBy(id = "draggable")
    private WebElement draggableElement;

    @FindBy(id = "target")
    private WebElement targetElement;

    public WebElement getDraggableElement() {
        return draggableElement;
    }

    public WebElement getTargetElement() {
        return targetElement;
    }

    public WebElement getHeader() {
        return headerDragDrop;
    }
}

package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DragAndDropPage extends BasePage {


    private static final By HEADER_DRAG_DROP = By.xpath("//h1[@class=\"display-6\"]");
    private static final By DRAG_FROM = By.xpath("//div[@id=\"draggable\"]");
    private static final By DROP_TO = By.xpath("//div[@id=\"target\"]");

    public DragAndDropPage(WebDriver driver){
        super(driver);
    }

    public WebElement getDraggableElement(){
        return findElement(DRAG_FROM);
    }

    public WebElement getTargetElement(){
        return findElement(DROP_TO);
    }






}

package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class InfiniteScrollPage extends BasePage {

    public InfiniteScrollPage(WebDriver driver){
        super(driver);
    }

    private static final By PARAGRAPH = By.xpath("//p[@class=\"lead\"]");


    public int getParagraphCount(){
        return findElements(PARAGRAPH).size();
    }
}

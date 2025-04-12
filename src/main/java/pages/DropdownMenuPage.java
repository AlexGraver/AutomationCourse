package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropdownMenuPage extends BasePage {

    public DropdownMenuPage(WebDriver driver){
        super(driver);
    }
    private static final By HEADER_DROPDOWN = By.xpath("//h1[@class=\"display-6\"]");
    private static final By LEFT_CLICK_MENU = By.xpath("//button[@id=\"my-dropdown-1\"]");
    private static final By RIGHT_CLICK_MENU = By.xpath("//button[@id=\"my-dropdown-2\"]");
    private static final By RIGHT_CLICK_CONTEXT_MENU = By.xpath("//ul[@id=\"context-menu-2\"]");
    private static final By DOUBLE_CLICK_MENU = By.xpath("//button[@id=\"my-dropdown-3\"]");
    private static final By DOUBLE_CLICK_CONTEXT_MENU = By.xpath("//ul[@id=\"context-menu-3\"]");

    public void openLeftMenu(){
        findElement(LEFT_CLICK_MENU);
        mouseLeftClick(LEFT_CLICK_MENU);
    }

    public boolean leftMenuIsExpanded(){
        return findElement(LEFT_CLICK_MENU)
                .getDomProperty("ariaExpanded")
                .equalsIgnoreCase("true");
    }

    public void openRightMenu(){
        findElement(RIGHT_CLICK_MENU);
        mouseRightClick(RIGHT_CLICK_MENU);
    }

    public boolean rightMenuIsExpanded(){
        boolean isExpanded = false;
        String style = findElement(RIGHT_CLICK_CONTEXT_MENU)
                .getDomProperty("style");

        if(style.equalsIgnoreCase("[]")){
            isExpanded = false;
        }else if(style.equalsIgnoreCase("[display]")){
            isExpanded = true;
        }
        return isExpanded;
    }

    public void openDoubleMenu(){
        mouseDoubleClick(DOUBLE_CLICK_CONTEXT_MENU);
    }

    public boolean doubleMenuIsExpanded(){
        boolean isExpanded = false;
        String style = findElement(DOUBLE_CLICK_CONTEXT_MENU)
                .getDomProperty("style");

        if(style.equalsIgnoreCase("[]")){
            isExpanded = false;
        }else if(style.equalsIgnoreCase("[display]")){
            isExpanded = true;
        }
        return isExpanded;
    }

}

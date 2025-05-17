package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import java.util.Objects;

public class DropdownMenuPage {

    private static final String LEFT_CLICK_MENU = "//button[@id=\"my-dropdown-1\"]";
    private static final String RIGHT_CLICK_MENU = "//button[@id=\"my-dropdown-2\"]";
    private static final String DOUBLE_CLICK_MENU = "//button[@id=\"my-dropdown-3\"]";
    private static final String RIGHT_CLICK_CONTEXT_MENU = "//ul[@id=\"context-menu-2\"]";
    private static final String DOUBLE_CLICK_CONTEXT_MENU = "//ul[@id=\"context-menu-3\"]";

    public void openLeftMenu(){
        Selenide.$x(LEFT_CLICK_MENU).click();
    }

    public boolean leftMenuIsExpanded(){
        return Objects.requireNonNull(Selenide.$x(LEFT_CLICK_MENU)
                        .shouldBe(Condition.visible)
                        .getDomProperty("ariaExpanded"))
                .equalsIgnoreCase("true");
    }

    public void openRightMenu(){
        Selenide.$x(RIGHT_CLICK_MENU).contextClick();
    }

    public boolean rightMenuIsExpanded(){
        String style = Selenide.$x(RIGHT_CLICK_CONTEXT_MENU)
                .shouldBe(Condition.visible)
                .getDomProperty("style");
        if(style.equalsIgnoreCase("[display]")){
            return true;
        }else{
            return false;
        }
    }

    public void openDoubleMenu(){
        Selenide.$x(DOUBLE_CLICK_MENU).doubleClick();
    }

    public boolean doubleMenuIsExpanded(){
        String style = Selenide.$x(DOUBLE_CLICK_CONTEXT_MENU)
                .getDomProperty("style");
        if(style.equalsIgnoreCase("[display]")){
            return true;
        }else{
            return false;
        }
    }

}

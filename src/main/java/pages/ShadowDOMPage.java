package pages;

import core.BasePage;
import org.openqa.selenium.*;

public class ShadowDOMPage extends BasePage {

    public ShadowDOMPage(WebDriver driver){
        super(driver);
    }

    private static final By CONTENT = By.cssSelector("#content");
    private static final By SHADOW_CONTENT = By.cssSelector("p");

    public void getShadowContentDirectly(){
        findElement(SHADOW_CONTENT);
    }

    public String getShadowTextViaRoot(){
        WebElement content = findElement(CONTENT);
        SearchContext shadowRoot = content.getShadowRoot();
        return shadowRoot.findElement(SHADOW_CONTENT).getText();
    }

}

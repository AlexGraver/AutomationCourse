package core;

import core.driver.TestDriver;
import core.helpers.WaitHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;
import java.util.List;

public class BasePage {

    public Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private WaitHelper waitHelper;
    private JavascriptExecutor jsExecutor;
    private Actions action;
    protected static WebDriver driver = TestDriver.getDriver();
    Select select;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitHelper = new WaitHelper(driver);
        jsExecutor = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }

    protected static void openPage(String url){
        driver.get(url);
    }

    protected String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    protected void navigateBack(){
        driver.navigate().back();
    }

    protected void sleep(int milliseconds){
        waitHelper.sleep(milliseconds);
    }

    protected String getDomProperty(By locator, String property){
        return driver.findElement(locator).getDomProperty(property);
    }

    protected void setTextInToElement(By locator, String text){
        WebElement textField = findElement(locator);
        String defaultText = textField.getDomProperty("defaultValue");
        if(!(defaultText.equals(""))){
            textField.clear();
        }else{
            textField.sendKeys(text);
        }
    }

    protected void mouseClickAndMove(By locator, int horizont, int vertical){
        action.clickAndHold(findElement(locator))
                .moveByOffset(horizont, vertical)
                .release()
                .perform();
    }

    public void clickKeyBoardButton(Keys key){
        action.sendKeys(key).perform();
    }

    protected WebElement findElement(By locator){
        return waitUntilElementIsPresentInDOM(locator);
    }

    protected List<WebElement> findElements(By by) {
        return waitHelper.findElements(by);
    }

    protected WebElement waitUntilElementIsPresentInDOM(By locator){
        return waitHelper.waitUntilElementIsPresentInDOM(locator);
    }

    protected WebElement waitUntilElementClickable(By locator){
        return waitHelper.waitUntilElementClickable(locator);
    }

    protected WebElement waitUntilElementDisplayed(By locator){
        return waitHelper.waitUntilElementDisplayed(locator);
    }

    protected void waitUntilElementNotDisplayed(By locator){
        waitHelper.waitUntilElementNotDisplayed(locator);
    }

    protected void waitUntilAlertIsPresent(){
        waitHelper.waitUntilAlertIsPresent();
    }

    public void dragAndDrop(WebElement draggable, WebElement target){
        action.dragAndDrop(draggable, target).perform();
    }

    protected void mouseLeftClick(By locator){
        action.click(findElement(locator)).perform();
    }

    protected void mouseRightClick(By locator){
        action.contextClick(findElement(locator));
    }

    protected void mouseDoubleClick(By locator){
        action.doubleClick(findElement(locator)).perform();
    }


}

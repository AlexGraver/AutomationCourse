package core;

import core.driver.TestDriver;
import core.helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.lang.invoke.MethodHandles;

public class BasePage {

    public Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private WaitHelper waitHelper;
    private JavascriptExecutor jsExecutor;
    private Actions action;
    private static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver = TestDriver.getDriver();
        waitHelper = new WaitHelper(driver);
        jsExecutor = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }

    protected static void openPage(String url){
        driver.get(url);
    }

    public WebElement waitUntilElementIsPresentInDOM(By locator){
        return waitHelper.waitUntilElementIsPresentInDOM(locator);
    }

    public WebElement waitUntilElementClickable(By locator){
        return waitHelper.waitUntilElementClickable(locator);
    }

    public WebElement waitUntilElementDisplayed(By locator){
        return waitHelper.waitUntilElementDisplayed(locator);
    }

    public void waitUntilElementNotDisplayed(By locator){
        waitHelper.waitUntilElementNotDisplayed(locator);
    }

    public void waitUntilAlertIsPresent(){
        waitHelper.waitUntilAlertIsPresent();
    }




}

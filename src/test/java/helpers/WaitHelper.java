package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {

    private WebDriver driver;
    private WebDriverWait wait;
    private FluentWait<WebDriver> fluentWait;
    private static final int IMPLICIT_WAIT_MILLISEC = 500;
    private static final int EXPLICIT_WAIT_SEC = 10;
    private static final int FLUENT_TIMEOUT = 30;
    private static final int FLUENT_POLLING = 10;


    public WaitHelper(WebDriver driver){
        this.driver = driver;
        initImplicitWait(IMPLICIT_WAIT_MILLISEC);
        initWebDriverWait(EXPLICIT_WAIT_SEC);
    }

    private void initImplicitWait(int millisec){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(millisec));
    }

    private void initWebDriverWait(int sec){
        wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
    }

    public FluentWait<WebDriver> getFluentWait(){
        return new FluentWait<>(driver).withTimeout(Duration.ofSeconds(FLUENT_TIMEOUT))
                .pollingEvery(Duration.ofMillis(FLUENT_POLLING))
                .ignoring(TimeoutException.class)
                .ignoring(ElementClickInterceptedException.class);
    }


    public WebElement waitUntilElementIsPresentInDOM(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitUntilElementClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitUntilElementDisplayed(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilElementNotDisplayed(By locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitUntilAlertIsPresent(){
        wait.until(ExpectedConditions.alertIsPresent());
    }




}

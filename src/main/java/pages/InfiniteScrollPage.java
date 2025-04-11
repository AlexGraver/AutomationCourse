package pages;

import core.helpers.WaitHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InfiniteScrollPage {

    private static final By PARAGRAPH = By.xpath("//p[@class=\"lead\"]");
    private static WebDriver driver;
    private static WaitHelper waitHelper;

    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        waitHelper = new WaitHelper(driver);
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/infinite-scroll.html");
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void scrollTest(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int current = 0;
        int afterScroll = 1000;

        while(current < afterScroll){
            current = driver.findElements(PARAGRAPH).size();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            waitHelper.waitUntilElementDisplayed(PARAGRAPH);
        }
        Assertions.assertTrue(afterScroll <= driver.findElements(PARAGRAPH).size());
    }
}

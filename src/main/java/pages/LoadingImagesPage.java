//package pages;
//
//import core.helpers.WaitHelper;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class LoadingImagesPage {
//
//    private static final By COMPASS = By.xpath("//img[@id='compass']");
//    private static final By CALENDAR = By.xpath("//img[@id='calendar']");
//    private static final By AWARD = By.xpath("//img[@id='award']");
//    private static final By LANDSCAPE = By.xpath("//img[@id='landscape']");
//
//    private static WaitHelper waitHelper;
//    private static WebDriver driver;
//
//    @BeforeAll
//    static void setUp(){
//        driver = new ChromeDriver();
//        waitHelper = new WaitHelper(driver);
//        driver.manage().window().maximize();
//        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
//    }
//
//    @Test
//    void checkCompassDisplayed(){
//        checkImageDisplayed(COMPASS);
//    }
//
//    @Test
//    void checkCalendarDisplayed(){
//        checkImageDisplayed(CALENDAR);
//    }
//
//    @Test
//    void checkCalendarAward(){
//        checkImageDisplayed(AWARD);
//    }
//
//    @Test
//    void checkCalendarLandscape(){
//        checkImageDisplayed(LANDSCAPE);
//    }
//
//    @AfterAll
//    static void tearDown(){
//        driver.quit();
//    }
//
//
//
//    void checkImageDisplayed(By locator){
//        WebElement element = waitHelper.waitUntilElementIsPresentInDOM(locator);
//        Assertions.assertTrue(element.isDisplayed(), "Element " + locator.toString() + " should be displayed");
//    }
//
//}

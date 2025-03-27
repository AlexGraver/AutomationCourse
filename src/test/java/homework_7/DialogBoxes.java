package homework_7;

import helpers.WaitHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DialogBoxes {

    private static WebDriver driver;
    private static WaitHelper waitHelper;

    private static final By ALERT = By.xpath("//button[@id=\"my-alert\"]");
    private static final By CONFIRM = By.xpath("//button[@id=\"my-confirm\"]");
    private static final By PROMPT = By.xpath("//button[@id=\"my-prompt\"]");
    private static final By MODAL = By.xpath("//button[@id=\"my-modal\"]");



    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        waitHelper = new WaitHelper(driver);
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void checkAlertTest(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
        driver.findElement(ALERT).click();
        waitHelper.waitUntilAlertIsPresent();

        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        Assertions.assertEquals(text, "Hello world!");
    }


}

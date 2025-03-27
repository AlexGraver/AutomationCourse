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
    private static final By CONFIRM_RESULT = By.xpath("//p[@id=\"confirm-text\"]");
    private static final By PROMPT = By.xpath("//button[@id=\"my-prompt\"]");
    private static final By PROMPT_RESULT = By.xpath("//p[@id=\"prompt-text\"]");
    private static final By MODAL = By.xpath("//button[@id=\"my-modal\"]");
    private static final By MODAL_CONTENT = By.xpath("//div[@class=\"modal-body\"]");
    private static final By MODAL_CLOSE = By.xpath("(//button[@data-bs-dismiss=\"modal\"])[1]");
    private static final By MODAL_SAVE = By.xpath("(//button[@data-bs-dismiss=\"modal\"])[2]");
    private static final By MODAL_RESULT = By.xpath("//p[@id=\"modal-text\"]");


    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        waitHelper = new WaitHelper(driver);
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void switchToAlertTest(){
        driver.findElement(ALERT).click();
        waitHelper.waitUntilAlertIsPresent();
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        Assertions.assertEquals(text, "Hello world!");
    }

    @Test
    void acceptConfirmTest(){
        driver.findElement(CONFIRM).click();
        waitHelper.waitUntilAlertIsPresent();
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();

        Assertions.assertEquals(text, "Is this correct?");
        alert.accept();
        String result = driver.findElement(CONFIRM_RESULT).getText();
        Assertions.assertEquals(result,"You chose: true");
    }

    @Test
    void cancelConfirmTest(){
        driver.findElement(CONFIRM).click();
        waitHelper.waitUntilAlertIsPresent();
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();

        Assertions.assertEquals("Is this correct?", text);
        alert.dismiss();
        String result = driver.findElement(CONFIRM_RESULT).getText();
        Assertions.assertEquals(result,"You chose: false");
    }

    @Test
    void promptTest(){
        driver.findElement(PROMPT).click();
        waitHelper.waitUntilAlertIsPresent();
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();

        Assertions.assertEquals("Please enter your name", text);
        alert.sendKeys("Alex");
        alert.accept();
        String result = driver.findElement(PROMPT_RESULT).getText();
        Assertions.assertEquals(result,"You typed: Alex");
    }

    @Test
    void modalCloseTest(){
        driver.findElement(MODAL).click();
        String text = waitHelper.waitUntilElementDisplayed(MODAL_CONTENT).getText();
        driver.findElement(MODAL_CLOSE).click();
        String result = driver.findElement(MODAL_RESULT).getText();

        Assertions.assertTrue(text.contains("This is the modal body"), "Text not as expected");
        Assertions.assertEquals(result, "You chose: Close");
    }

    @Test
    void modalSaveTest(){
        driver.findElement(MODAL).click();
        String text = waitHelper.waitUntilElementDisplayed(MODAL_CONTENT).getText();
        driver.findElement(MODAL_SAVE).click();
        String result = driver.findElement(MODAL_RESULT).getText();

        Assertions.assertTrue(text.contains("This is the modal body"), "Text not as expected");
        Assertions.assertEquals(result, "You chose: Save changes");
    }


}

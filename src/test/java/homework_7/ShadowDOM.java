package homework_7;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOM {

    private static final By CONTENT = By.cssSelector("#content");
    private static final By SHADOW_CONTENT = By.cssSelector("p");
    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void checkShadowContentIsUnavailable() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");
        WebElement content = driver.findElement(CONTENT);
        SearchContext shadowRoot = content.getShadowRoot();

        Assertions.assertThrows(NoSuchElementException.class,
                () -> driver.findElement(SHADOW_CONTENT));
    }

    @Test
    void checkAbilityToReachShadowContentTest() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html");
        WebElement content = driver.findElement(CONTENT);
        SearchContext shadowRoot = content.getShadowRoot();
        WebElement shadowContent = shadowRoot.findElement(SHADOW_CONTENT);
        String shadowText = shadowContent.getText();

        Assertions.assertNotNull(shadowText, "Shadow content was not found!");
        System.out.println("Shadow DOM text: " + shadowText);
    }
}

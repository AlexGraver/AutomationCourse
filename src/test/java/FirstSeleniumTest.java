import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FirstSeleniumTest {

    private WebDriver driver;
    List<WebElement> elements;
    private final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";
    private final By CHAPTER_3_BLOCK = By.xpath("//h5[@class=\"card-title\" and text() = \"Chapter 3. WebDriver Fundamentals\"]");
    private final By CHAPTER_BLOCK_CONTENT = By.xpath(".//a[@class=\"btn btn-outline-primary mb-2\"]");
    private final By HEADER = By.xpath("//h1[contains (@class, \"display-6\")]");

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of("web-form.html", "Web form", 1),
                Arguments.of("navigation1.html", "Navigation example", 2),
                Arguments.of("dropdown-menu.html","Dropdown menu", 3),
                Arguments.of("mouse-over.html", "Mouse over", 4),
                Arguments.of("drag-and-drop.html", "Drag and drop", 5),
                Arguments.of("draw-in-canvas.html", "Drawing in canvas", 6),
                Arguments.of("loading-images.html", "Loading images", 7),
                Arguments.of("slow-calculator.html", "Slow calculator", 8),
                Arguments.of("long-page.html", "This is a long page", 9),
                Arguments.of("infinite-scroll.html", "Infinite scroll", 10),
                Arguments.of("shadow-dom.html", "Shadow DOM", 11),
                Arguments.of("cookies.html", "Cookies", 12),
                Arguments.of("frames.html", "Frames", 13),
                Arguments.of("iframes.html", "IFrame", 14),
                Arguments.of("dialog-boxes.html", "Dialog boxes", 15),
                Arguments.of("web-storage.html", "Web storage", 16),
                Arguments.of("geolocation.html", "Geolocation", 17),
                Arguments.of("notifications.html", "Notifications", 18),
                Arguments.of("get-user-media.html", "Get user media", 19),
                Arguments.of("multilanguage.html", "Multilanguage page", 20),
                Arguments.of("console-logs.html", "Console logs", 21),
                Arguments.of("login-form.html", "Login form", 22),
                Arguments.of("login-slow.html", "Slow login form", 23),
                Arguments.of("random-calculator.html", "Random calculator", 24),
                Arguments.of("download.html", "Download files", 25),
                Arguments.of("ab-testing.html", "A/B Testing", 26),
                Arguments.of("data-types.html", "Data types", 27)

        );
    }

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        elements = new ArrayList<>();
    }

    @Test
    void openHomePageTest(){
        By baseHeader = By.xpath("//*[@class=\"display-4\"]");
        driver.get(BASE_URL);

        String actualURL = driver.getCurrentUrl();
        String expectedHeader = "Hands-On Selenium WebDriver with Java";
        String actualHeader = driver.findElement(baseHeader).getText();

        Assertions.assertAll(
                () -> Assertions.assertEquals(BASE_URL, actualURL),
                () -> Assertions.assertEquals(expectedHeader, actualHeader)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void checkClickAbilityOfAllLinksTest(String endpoint, String header, int order){
        driver.get(BASE_URL);
        openLinkAndCheckUrlAndHeader(endpoint, header, order);
    }

    @Test
    void checkAllLinksDependsToChapter_3_Test(){
        driver.get(BASE_URL);
        WebElement parent_3_chapter = driver.findElement(CHAPTER_3_BLOCK);
        List<WebElement> expectedElements = parent_3_chapter.findElements(CHAPTER_BLOCK_CONTENT);
        List<WebElement> actualElements = new ArrayList<>();

        elements = driver.findElements(CHAPTER_BLOCK_CONTENT);
        for(WebElement element: elements){
            WebElement actualParent = element.findElement(By.xpath(".."));
            if(actualParent.equals(parent_3_chapter)){
                actualElements.add(element);
            }
        }

        Assertions.assertEquals(expectedElements, actualElements);

    }

    @Step
    void openLinkAndCheckUrlAndHeader(String endpoint, String expectedHeader, int order){
        By modifiedLocator = By.xpath(modifyXpath(CHAPTER_BLOCK_CONTENT, order));
        driver.findElement(modifiedLocator).click();

        String actualURL = driver.getCurrentUrl();
        String actualHeader = driver.findElement(HEADER).getText();

        Assertions.assertAll(
                () -> Assertions.assertEquals(BASE_URL + endpoint, actualURL),
                () -> Assertions.assertEquals(expectedHeader, actualHeader)
        );
    }

    @Step
    String modifyXpath(By locator, int order){
        String locatorXpath = locator.toString().replace("By.xpath: ", "");
        return   "("+locatorXpath+")["+String.valueOf(order)+"]";
    }

    @AfterEach
    void  tearDown(){
        driver.quit();
    }


}

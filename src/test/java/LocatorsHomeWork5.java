import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class LocatorsHomeWork5 {

    private static WebDriver driver;

    //Locators
    private static final By HEADER = By.xpath("//h1[@class=\"display-4\"]");
    private static final By PAGE_NAME = By.xpath("//h1[@class=\"display-6\"]");
    private static final By TEXT_INPUT = By.xpath("//input[@id=\"my-text-id\"]");
    private static final By PASSWORD = By.xpath("//input[@name=\"my-password\"]");
    private static final By TEXT_AREA = By.xpath("//textarea[@name=\"my-textarea\"]");
    private static final By DISABLED_INPUT = By.xpath("//input[@name=\"my-disabled\"]");
    private static final By READONLY_INPUT = By.xpath("//input[@name=\"my-readonly\"]");
    private static final By DROPDOWN_SELECT = By.xpath("//select[@name=\"my-select\"]");
    private static final By DROPDOWN_DATA_LIST = By.xpath("//input[@name=\"my-datalist\"]");
    private static final By FILE_INPUT = By.xpath("//input[@name=\"my-file\"]");
    private static final By CHECKED_CHECKBOX = By.xpath("//input[@id=\"my-check-1\"]");
    private static final By DEFAULT_CHECKBOX = By.xpath("//input[@id=\"my-check-2\"]");
    private static final By CHECKED_RADIO = By.xpath("//input[@id=\"my-radio-1\"]");
    private static final By DEFAULT_RADIO = By.xpath("//input[@id=\"my-radio-2\"]");
    private static final By SUBMIT = By.xpath("//button[@type=\"submit\"]");
    private static final By COLOR_PICKER = By.xpath("//input[@name=\"my-colors\"]");
    private static final By DATE_PICKER = By.xpath("//input[@name=\"my-date\"]");
    private static final By EXAMPLE_RANGE = By.xpath("//input[@name=\"my-range\"]");



    @BeforeAll
    static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
    }



    static Stream<Arguments> dataProvider(){
       return Stream.of(
               Arguments.of(HEADER.toString().replace("By.xpath: ", ""), "Hands-On Selenium WebDriver with Java"),
               Arguments.of(PAGE_NAME.toString().replace("By.xpath: ", ""), "Web form"),
               Arguments.of(TEXT_INPUT.toString().replace("By.xpath: ", ""), "Text input"),
               Arguments.of(PASSWORD.toString().replace("By.xpath: ", ""), "Password"),
               Arguments.of(TEXT_AREA.toString().replace("By.xpath: ", ""), "Textarea"),
               Arguments.of(DISABLED_INPUT.toString().replace("By.xpath: ", ""), "Disabled input"),
               Arguments.of(READONLY_INPUT.toString().replace("By.xpath: ", ""), "Readonly input"),
               Arguments.of(DROPDOWN_SELECT.toString().replace("By.xpath: ", ""), "Open this select menu"),
               Arguments.of(DROPDOWN_DATA_LIST.toString().replace("By.xpath: ", ""), "Dropdown (datalist)"),
               Arguments.of(FILE_INPUT.toString().replace("By.xpath: ", ""), "File input"),
               Arguments.of(CHECKED_CHECKBOX.toString().replace("By.xpath: ", ""), "Checked checkbox"),
               Arguments.of(DEFAULT_CHECKBOX.toString().replace("By.xpath: ", ""), "Default checkbox"),
               Arguments.of(CHECKED_RADIO.toString().replace("By.xpath: ", ""), "Checked radio"),
               Arguments.of(DEFAULT_RADIO.toString().replace("By.xpath: ", ""), "Default radio"),
               Arguments.of(SUBMIT.toString().replace("By.xpath: ", ""), "Submit"),
               Arguments.of(COLOR_PICKER.toString().replace("By.xpath: ", ""), "Color picker"),
               Arguments.of(DATE_PICKER.toString().replace("By.xpath: ", ""), "Date picker"),
               Arguments.of(EXAMPLE_RANGE.toString().replace("By.xpath: ", ""), "Example range")
        );
    }

    @MethodSource("dataProvider")
    @ParameterizedTest
    void findElement(String xpath, String expected){
        try{
            String actual = driver.findElement(By.xpath(xpath)).getText();
            if(actual.length() == 0){
                actual = driver.findElement(By.xpath(xpath)).findElement(By.xpath("..")).getText();
            }
            Assertions.assertTrue(actual.contains(expected));
        }catch(NoSuchElementException e){
            System.out.println("Element with locator: " + xpath + "not found");
        }
    }

    @AfterAll
    static  void tearDown(){
        driver.quit();
    }



}


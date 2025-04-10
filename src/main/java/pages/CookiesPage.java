package pages;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesPage {

    private static final By REFRESH_COOKIE = By.xpath("//button[@id=\"refresh-cookies\"]");
    private static final By COOKIE_LIST = By.xpath("//p[@id=\"cookies-list\"]");
    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/cookies.html");
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void cookieTest(){
        WebElement refresh = driver.findElement(REFRESH_COOKIE);
        WebElement cookie_list = driver.findElement(COOKIE_LIST);
        refresh.click();
        String textBefore = cookie_list.getText();

        Assertions.assertEquals("username=John Doe\n" +
                "date=10/07/2018", textBefore);

        driver.manage().addCookie(new Cookie("age", "30"));
        driver.manage().addCookie(new Cookie("position","Manager"));

        refresh.click();
        String textAfter = cookie_list.getText();

        Assertions.assertEquals("username=John Doe\n" +
                "date=10/07/2018\n" +
                "age=30\n" +
                "position=Manager", textAfter);

        driver.manage().deleteAllCookies();
        refresh.click();
        String clearedCookie = cookie_list.getText();

        Assertions.assertEquals("", clearedCookie);
    }
}

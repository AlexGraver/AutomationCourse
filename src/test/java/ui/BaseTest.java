package ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import core.BasePage;
import core.configs.Configs;
import core.driver.TestDriver;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import ui.testExtensions.ScreenshotOnFailureExtension;

import static core.BasePage.openPage;

@ExtendWith(ScreenshotOnFailureExtension.class)
public class BaseTest {

    private static final Configs CONFIGS = ConfigFactory.create(Configs.class);

    static public HomePage initUiTest(){
        WebDriver driver = TestDriver.getDriver();
        new BasePage(driver);
        openPage(CONFIGS.baseUrl());
        return new HomePage(driver);
    }

    static public HomePage initUiTestSelenide(){
        Selenide.open(CONFIGS.baseUrl());
        new BasePage(WebDriverRunner.getWebDriver());
        return new HomePage(WebDriverRunner.getWebDriver());
    }

    @AfterAll
    public static void tearDown(){
        TestDriver.quitDriver();
    }

}

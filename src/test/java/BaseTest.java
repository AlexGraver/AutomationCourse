import core.configs.Configs;
import core.driver.TestDriver;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.HomePage;
import testExtensions.ScreenshotOnFailureExtension;

import static core.BasePage.openPage;

@ExtendWith(ScreenshotOnFailureExtension.class)
public class BaseTest {

    private static final Configs CONFIGS = ConfigFactory.create(Configs.class);

    static public HomePage initUiTest(){
        openPage(CONFIGS.baseUrl());
        return new HomePage(TestDriver.getDriver());
    }

    @AfterAll
    public static void tearDown(){
        TestDriver.quitDriver();
    }

}

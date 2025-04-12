import core.configs.Configs;
import core.driver.TestDriver;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import pages.HomePage;
import static core.BasePage.openPage;

public class BaseTest {

    private static Configs configs = ConfigFactory.create(Configs.class);

    static public HomePage initUiTest(){
        openPage(configs.baseUrl());
        return new HomePage(TestDriver.getDriver());
    }

    @AfterAll
    public static void tearDown(){
        TestDriver.quitDriver();
    }

}

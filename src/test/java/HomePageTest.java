import core.configs.Configs;
import core.driver.TestDriver;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest {

    private Configs configs = ConfigFactory.create(Configs.class);

    @Test
    void homePageIsOpenedTest(){
        initUiTest();
        Assertions.assertEquals(configs.baseUrl(), TestDriver.getDriver().getCurrentUrl());
    }


}

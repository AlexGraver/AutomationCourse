import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest {

    @Test
    void homePageIsOpenedTest(){
        initUiTest().openWebFormTab();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}

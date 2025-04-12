import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.SlowCalculatorPage;

public class SlowCalculatorPageTest extends BaseTest{

    SlowCalculatorPage slowCalculatorPage;

    @BeforeEach
    void setUp(){
        slowCalculatorPage = initUiTest().openSlowCalculatorTab();
    }

    @Test
    void checkSumTest(){
        slowCalculatorPage.reset();
        slowCalculatorPage.pressNumber(3);
        slowCalculatorPage.sum();
        slowCalculatorPage.pressNumber(3);
        slowCalculatorPage.pressResult();

        Assertions.assertEquals(6, slowCalculatorPage.getResult());
    }

    @Test
    void checkMultiplyTest(){
        slowCalculatorPage.reset();
        slowCalculatorPage.pressNumber(6);
        slowCalculatorPage.multiply();
        slowCalculatorPage.pressNumber(3);
        slowCalculatorPage.pressResult();

        Assertions.assertEquals(18, slowCalculatorPage.getResult());
    }

    @Test
    void checkSubtract(){
        slowCalculatorPage.reset();
        slowCalculatorPage.pressNumber(1);
        slowCalculatorPage.pressNumber(0);
        slowCalculatorPage.subtract();
        slowCalculatorPage.pressNumber(3);
        slowCalculatorPage.pressResult();

        Assertions.assertEquals(7, slowCalculatorPage.getResult());
    }

    @Test
    void checkDevision(){
        slowCalculatorPage.reset();
        slowCalculatorPage.pressNumber(1);
        slowCalculatorPage.pressNumber(0);
        slowCalculatorPage.devide();
        slowCalculatorPage.pressNumber(2);
        slowCalculatorPage.pressResult();

        Assertions.assertEquals(5, slowCalculatorPage.getResult());
    }

    @Test
    void checkChainActions(){
        slowCalculatorPage.reset();
        slowCalculatorPage.pressNumber(9);
        slowCalculatorPage.sum();
        slowCalculatorPage.pressNumber(4);
        slowCalculatorPage.subtract();
        slowCalculatorPage.pressNumber(3);
        slowCalculatorPage.pressResult();

        Assertions.assertEquals(10, slowCalculatorPage.getResult());
    }

    @Test
    void checkDoubleResult(){
        slowCalculatorPage.reset();
        slowCalculatorPage.pressNumber(9);
        slowCalculatorPage.devide();
        slowCalculatorPage.pressNumber(2);
        slowCalculatorPage.pressResult();

        Assertions.assertEquals(4.5, slowCalculatorPage.getResult());
    }

}

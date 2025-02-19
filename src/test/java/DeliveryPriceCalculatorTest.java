import deliveryOrder.DeliveryLoad;
import deliveryOrder.DeliveryOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DeliveryPriceCalculatorTest {
    private static  DeliveryPriceCalculator calculator;

    @BeforeAll
    static void setUp(){
        calculator = new DeliveryPriceCalculator();
    }


    @Test
    void deliveryIsNotPossibleCalculatorTest(){
        DeliveryOrder order = new DeliveryOrder(30.01, false, true, DeliveryLoad.NORMAL);
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                        () -> calculator.calculateDeliveryPrice(order));
                assertEquals("Fragile product delivery is possible only to distance less then 30 km",
                        exception.getMessage());
   }

   @Test
    void deliveryIsPossibleCalculatorTest(){
        DeliveryOrder order = new DeliveryOrder(30, false, true, DeliveryLoad.NORMAL);
        Assertions.assertDoesNotThrow(() -> calculator.calculateDeliveryPrice(order));
   }

   @Test
   void maxDeliveryPriceTest(){
        DeliveryOrder order = new DeliveryOrder(30, true, true, DeliveryLoad.VERY_HIGH);
        double minimalDeliveryPrice = 400;
        double expectedPrice = (minimalDeliveryPrice + 200 + 200 + 300)*1.6;
        Assertions.assertEquals(expectedPrice, calculator.calculateDeliveryPrice(order));
   }

    @Test
    void negativeDistanceValidationTest(){
        DeliveryOrder order = new DeliveryOrder(-1, true, true, DeliveryLoad.HIGH);
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateDeliveryPrice(order));
        assertEquals("Distance should be a positive number",
                exception.getMessage());
    }

    @Test
    void distanceBoundaryValueTest(){
        Assertions.assertEquals(400+100, calculator.calculateDeliveryPrice(new DeliveryOrder(0, false, false, DeliveryLoad.NORMAL)));
        Assertions.assertEquals(400+100+50, calculator.calculateDeliveryPrice(new DeliveryOrder(2, false, false, DeliveryLoad.NORMAL)));
        Assertions.assertEquals(400+100+100, calculator.calculateDeliveryPrice(new DeliveryOrder(10, false, false, DeliveryLoad.NORMAL)));
        Assertions.assertEquals(400+100+200, calculator.calculateDeliveryPrice(new DeliveryOrder(30, false, false, DeliveryLoad.NORMAL)));
        Assertions.assertEquals(400+100+300, calculator.calculateDeliveryPrice(new DeliveryOrder(30.001, false, false, DeliveryLoad.NORMAL)));
    }

    @Test
    void sizeAmountTest(){
        Assertions.assertEquals(400+100, calculator.calculateDeliveryPrice(new DeliveryOrder(0, false, false, DeliveryLoad.NORMAL)));
        Assertions.assertEquals(400+200, calculator.calculateDeliveryPrice(new DeliveryOrder(0, true, false, DeliveryLoad.NORMAL)));
    }

    @Test
    void fragileAmountTest(){
        Assertions.assertEquals(400+100, calculator.calculateDeliveryPrice(new DeliveryOrder(0, false, false, DeliveryLoad.NORMAL)));
        Assertions.assertEquals(400+100+300, calculator.calculateDeliveryPrice(new DeliveryOrder(0, false, true, DeliveryLoad.NORMAL)));
    }

    @Test
    void loadAmountTest(){
        Assertions.assertEquals(400+100, calculator.calculateDeliveryPrice(new DeliveryOrder(0, false, false, DeliveryLoad.NORMAL)));
        Assertions.assertEquals((400+100)*1.2, calculator.calculateDeliveryPrice(new DeliveryOrder(0, false, false, DeliveryLoad.MODERATE)));
        Assertions.assertEquals((400+100)*1.4, calculator.calculateDeliveryPrice(new DeliveryOrder(0, false, false, DeliveryLoad.HIGH)));
        Assertions.assertEquals((400+100)*1.6, calculator.calculateDeliveryPrice(new DeliveryOrder(0, false, false, DeliveryLoad.VERY_HIGH)));

    }






   //Unit tests of private sub-methods using Reflection API
   @Test
   void deliveryIsPossibleTest(){
        assertAll(
                () -> assertFalse(invokePrivateDeliveryIsPossible(new DeliveryOrder(30.01, false, true, DeliveryLoad.NORMAL))),
                () -> assertTrue(invokePrivateDeliveryIsPossible(new DeliveryOrder(30.01, false, false, DeliveryLoad.NORMAL)))
                );
   }

    @Test
    void testExtraAmountForDistance() {
        assertThrows(IllegalArgumentException.class, () -> invokePrivateExtraAmountForDistance(new DeliveryOrder(-1, false, false, DeliveryLoad.NORMAL)));
        assertAll(
                () -> assertEquals(0, invokePrivateExtraAmountForDistance(new DeliveryOrder(0, false, false, DeliveryLoad.NORMAL))),
                () -> assertEquals(50, invokePrivateExtraAmountForDistance(new DeliveryOrder(0.001, false, false, DeliveryLoad.NORMAL))),
                () -> assertEquals(50, invokePrivateExtraAmountForDistance(new DeliveryOrder(1.999, false, false, DeliveryLoad.NORMAL))),
                () -> assertEquals(50, invokePrivateExtraAmountForDistance(new DeliveryOrder(2, false, false, DeliveryLoad.NORMAL))),
                () -> assertEquals(100, invokePrivateExtraAmountForDistance(new DeliveryOrder(2.001, false, false, DeliveryLoad.NORMAL))),
                () -> assertEquals(100, invokePrivateExtraAmountForDistance(new DeliveryOrder(10, false, false, DeliveryLoad.NORMAL))),
                () -> assertEquals(200, invokePrivateExtraAmountForDistance(new DeliveryOrder(10.001, false, false, DeliveryLoad.NORMAL))),
                () -> assertEquals(200, invokePrivateExtraAmountForDistance(new DeliveryOrder(30, false, false, DeliveryLoad.NORMAL))),
                () -> assertEquals(300, invokePrivateExtraAmountForDistance(new DeliveryOrder(30.001, false, false, DeliveryLoad.NORMAL)))
        );
    }

    @Test
    void testExtraAmountForSize() {
        assertAll(
                () -> assertEquals(200, invokePrivateExtraAmountForSize(new DeliveryOrder(5, true, false, DeliveryLoad.NORMAL))),
                () -> assertEquals(100, invokePrivateExtraAmountForSize(new DeliveryOrder(5, false, false, DeliveryLoad.NORMAL)))
        );
    }

    @Test
    void testExtraAmountForFragile() {
        assertAll(
                () -> assertEquals(300, invokePrivateExtraAmountForFragile(new DeliveryOrder(5, false, true, DeliveryLoad.NORMAL))),
                () -> assertEquals(0, invokePrivateExtraAmountForFragile(new DeliveryOrder(5, false, false, DeliveryLoad.NORMAL)))
        );
    }

    @Test
    void testExtraCoefficientForLoad() {
        assertEquals(1.6, invokePrivateExtraCoefficientForLoad(new DeliveryOrder(5, false, false, DeliveryLoad.VERY_HIGH)));
        assertEquals(1.4, invokePrivateExtraCoefficientForLoad(new DeliveryOrder(5, false, false, DeliveryLoad.HIGH)));
        assertEquals(1.2, invokePrivateExtraCoefficientForLoad(new DeliveryOrder(5, false, false, DeliveryLoad.MODERATE)));
        assertEquals(1.0, invokePrivateExtraCoefficientForLoad(new DeliveryOrder(5, false, false, DeliveryLoad.NORMAL)));
    }

    private boolean invokePrivateDeliveryIsPossible(DeliveryOrder order){
        try{
            var method = DeliveryPriceCalculator.class.getDeclaredMethod("deliveryIsPossible", DeliveryOrder.class);
            method.setAccessible(true);
            return (boolean) method.invoke(calculator, order);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    private double invokePrivateExtraAmountForDistance(DeliveryOrder order) {
        try {
            var method = DeliveryPriceCalculator.class.getDeclaredMethod("extraAmountForDistance", DeliveryOrder.class);
            method.setAccessible(true);
            return (double) method.invoke(calculator, order);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    private double invokePrivateExtraAmountForSize(DeliveryOrder order) {
        try {
            var method = DeliveryPriceCalculator.class.getDeclaredMethod("extraAmountForSize", DeliveryOrder.class);
            method.setAccessible(true);
            return (double) method.invoke(calculator, order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private double invokePrivateExtraAmountForFragile(DeliveryOrder order) {
        try {
            var method = DeliveryPriceCalculator.class.getDeclaredMethod("extraAmountForFragile", DeliveryOrder.class);
            method.setAccessible(true);
            return (double) method.invoke(calculator, order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private double invokePrivateExtraCoefficientForLoad(DeliveryOrder order) {
        try {
            var method = DeliveryPriceCalculator.class.getDeclaredMethod("extraCoefficientForLoad", DeliveryOrder.class);
            method.setAccessible(true);
            return (double) method.invoke(calculator, order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}

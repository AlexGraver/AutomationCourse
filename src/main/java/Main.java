import deliveryOrder.DeliveryLoad;
import deliveryOrder.DeliveryOrder;

public class Main {
    public static void main(String[] args){
        DeliveryPriceCalculator calculator = new DeliveryPriceCalculator();
        DeliveryOrder order_1 = new DeliveryOrder(30.0, true, true, DeliveryLoad.NORMAL);

        try {
            double price = calculator.calculateDeliveryPrice(order_1);
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }


    }



}

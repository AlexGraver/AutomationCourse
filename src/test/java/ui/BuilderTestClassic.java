package ui;

import builders.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuilderTestClassic {

    @Test
    void testCarBuilder() {
        Car car = new Car.Builder()
                .setEngine("V6")
                .setWheels(4)
                .setColor("Black")
                .build();

        assertEquals("V6", car.getEngine());
        assertEquals(4, car.getWheels());
        assertEquals("Black", car.getColor());
    }
}

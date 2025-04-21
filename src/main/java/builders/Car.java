package builders;

public class Car {
    private String engine;
    private int wheels;
    private String color;

    private Car(Builder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.color = builder.color;
    }

    public String getEngine() {
        return engine;
    }

    public int getWheels() {
        return wheels;
    }

    public String getColor() {
        return color;
    }


    //Inserted class builder
    public static class Builder {
        private String engine;
        private int wheels;
        private String color;

        public Builder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder setWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }



}

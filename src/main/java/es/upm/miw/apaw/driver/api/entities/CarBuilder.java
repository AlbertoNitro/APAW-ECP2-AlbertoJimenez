package es.upm.miw.apaw.driver.api.entities;

public class CarBuilder {
    private Car car;

    public CarBuilder(int id) {
        this.car = new Car(id);
    }

    public CarBuilder() {
        this(0);
    }

    public CarBuilder id(int id) {
        this.car = new Car(id);
        return this;
    }

    public CarBuilder registration(String registration) {
        this.car.setRegistration(registration);
        return this;
    }

    public CarBuilder model(String model) {
        this.car.setModel(model);
        return this;
    }

    public Car build() {
        return this.car;
    }

}

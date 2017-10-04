package es.upm.miw.apaw.driver.api.entities;

public class DriverBuilder {
    private Driver driver;

    public DriverBuilder(int id) {
        this.driver = new Driver(id);
    }

    public DriverBuilder() {
        this(0);
    }

    public DriverBuilder id(int id) {
        this.driver = new Driver(id);
        return this;
    }

    public DriverBuilder phone(long phone) {
        this.driver.setPhone(phone);
        return this;
    }

    public DriverBuilder reference(String reference) {
        this.driver.setReference(reference);
        return this;
    }

    public DriverBuilder level(Level level) {
        this.driver.setLevel(level);
        return this;
    }

    public DriverBuilder car(Car car) {
        this.driver.setCar(car);
        return this;
    }

    public Driver build() {
        return this.driver;
    }

}

package es.upm.miw.apaw.driver.api.dtos;

import es.upm.miw.apaw.driver.api.entities.Car;
import es.upm.miw.apaw.driver.api.entities.Driver;
import es.upm.miw.apaw.driver.api.entities.Level;

public class DriverDto {

    private int id;

    private String reference;

    private long phone;

    private Level level;

    private Car car;

    public DriverDto() {
    }

    public DriverDto(Driver driver) {
        this.id = driver.getId();
        this.phone = driver.getPhone();
        this.reference = driver.getReference();
        this.level = driver.getLevel();
        this.car = driver.getCar();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPhone() {
        return this.phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "{\"id\":\"" + id + "\",\"phone\":\"" + phone + "\",\"reference\":\"" + reference + "\",\"level\":\"" + level + "\",\"car\":\"" + car + "\"}";
        
    }

}

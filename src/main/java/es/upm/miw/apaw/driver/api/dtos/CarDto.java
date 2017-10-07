package es.upm.miw.apaw.driver.api.dtos;

import es.upm.miw.apaw.driver.api.entities.Car;

public class CarDto {
    private int id;

    private String registration;

    private String model;

    public CarDto() {
    }

    public CarDto(Car car) {
        this.id = car.getId();
        this.registration = car.getRegistration();
        this.model = car.getModel();
    }

    public int getId() {
        return this.id;
    }

    public String getRegistration() {
        return this.registration;
    }
    
    public String getModel() {
        return this.model;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    @Override
    public String toString() {
        return "{\"id\":\"" + id + "\",\"model\":\"" + model + "\",\"registration\":\"" + registration + "\"}";
    }
}

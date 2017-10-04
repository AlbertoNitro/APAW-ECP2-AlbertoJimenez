package es.upm.miw.apaw.driver.api.dtos;

import es.upm.miw.apaw.driver.api.entities.Driver;

public class DriverDto {

    private int id;

    public DriverDto() {
    }

    public DriverDto(Driver driver) {
        this.id = driver.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + "\"}";
    }

}

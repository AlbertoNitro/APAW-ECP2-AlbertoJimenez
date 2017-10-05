package es.upm.miw.apaw.driver.api.dtos;

import es.upm.miw.apaw.driver.api.entities.Driver;

public class DriverDto {

    private int id;
    
    private long phone;

    public DriverDto() {
    }

    public DriverDto(Driver driver) {
        this.id = driver.getId();
        this.phone = driver.getPhone();
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

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"phone\":\"" + phone + "\"}";
    }

}

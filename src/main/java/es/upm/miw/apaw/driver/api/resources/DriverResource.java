package es.upm.miw.apaw.driver.api.resources;

import java.util.List;
import java.util.Optional;

import es.upm.miw.apaw.driver.api.controllers.DriverController;
import es.upm.miw.apaw.driver.api.resources.exceptions.DriverIdInvalidException;

public class DriverResource {

    public static final String DRIVERS = "drivers";

    public void createDriver(String driverId) throws DriverIdInvalidException {
        this.validateId(driverId);
        int id = Integer.parseInt(driverId);
        new DriverController().createDriver(id);
    }

    private void validateId(String driverId) throws DriverIdInvalidException {
        try {
            Integer.parseInt(driverId);
        } catch (Exception e) {
            throw new DriverIdInvalidException(driverId);
        }

    }

    public Object readDriver(Integer valueOf) {
        // TODO Auto-generated method stub
        return null;
    }

}

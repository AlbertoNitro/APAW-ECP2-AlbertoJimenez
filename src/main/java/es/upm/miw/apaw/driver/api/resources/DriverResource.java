package es.upm.miw.apaw.driver.api.resources;

import java.util.List;
import java.util.Optional;

import es.upm.miw.apaw.driver.api.controllers.DriverController;
import es.upm.miw.apaw.driver.api.resources.exceptions.DriverIdInvalidException;

public class DriverResource {

    public static final String DRIVERS = "drivers";

    public void createDriver(String driverId) throws DriverIdInvalidException {
        this.validateId(driverId);
        new DriverController().createDriver(driverId);
    }

    private void validateId(String driverId) throws DriverIdInvalidException {
        try {
            driverId = String.valueOf(driverId);
        } catch (Exception e) {
            throw new DriverIdInvalidException(driverId);
        }

    }

}

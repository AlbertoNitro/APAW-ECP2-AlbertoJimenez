package es.upm.miw.apaw.driver.api.resources;

import java.util.Optional;

import es.upm.miw.apaw.driver.api.controllers.DriverController;
import es.upm.miw.apaw.driver.api.dtos.DriverDto;
import es.upm.miw.apaw.driver.api.resources.exceptions.DriverIdInvalidException;
import es.upm.miw.apaw.driver.api.resources.exceptions.DriverIdNotFoundException;

public class DriverResource {

    public static final String DRIVERS = "drivers";

    public static final String ID = "/{id}";

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

    public DriverDto readDriver(int driverId) throws DriverIdNotFoundException {
        Optional<DriverDto> optional = new DriverController().readDriver(driverId);
        return optional.orElseThrow(() -> new DriverIdNotFoundException(Integer.toString(driverId)));
    }

}

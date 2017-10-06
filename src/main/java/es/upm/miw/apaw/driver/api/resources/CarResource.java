package es.upm.miw.apaw.driver.api.resources;

import es.upm.miw.apaw.driver.api.controllers.DriverController;
import es.upm.miw.apaw.driver.api.resources.exceptions.CarIdInvalidException;

public class CarResource {

    public static final String CARS = "cars";

    public static final String ID = "/{id}";

    public void createCar(String carId) throws CarIdInvalidException {
        this.validateId(carId);
        int id = Integer.parseInt(carId);
        new DriverController().createDriver(id);
    }

    private void validateId(String carId) throws CarIdInvalidException {
        try {
            Integer.parseInt(carId);
        } catch (Exception e) {
            throw new CarIdInvalidException(carId);
        }
    }

}

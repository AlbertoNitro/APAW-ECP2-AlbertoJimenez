package es.upm.miw.apaw.driver.api.resources;

import java.util.Optional;

import es.upm.miw.apaw.driver.api.controllers.CarController;
import es.upm.miw.apaw.driver.api.controllers.DriverController;
import es.upm.miw.apaw.driver.api.dtos.CarDto;
import es.upm.miw.apaw.driver.api.resources.exceptions.CarIdInvalidException;
import es.upm.miw.apaw.driver.api.resources.exceptions.CarIdNotFoundException;

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

    public CarDto readCar(Integer carId) throws CarIdNotFoundException {
        Optional<CarDto> optional = new CarController().readDriver(carId);
        return optional.orElseThrow(() -> new CarIdNotFoundException(Integer.toString(carId)));
    }

}

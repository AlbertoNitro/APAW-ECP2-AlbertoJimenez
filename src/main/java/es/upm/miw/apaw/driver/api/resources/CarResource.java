package es.upm.miw.apaw.driver.api.resources;

import java.util.Optional;

import es.upm.miw.apaw.driver.api.controllers.CarController;
import es.upm.miw.apaw.driver.api.dtos.CarDto;
import es.upm.miw.apaw.driver.api.resources.exceptions.CarIdInvalidException;
import es.upm.miw.apaw.driver.api.resources.exceptions.CarIdNotFoundException;
import es.upm.miw.apaw.driver.api.resources.exceptions.FieldNullOrEmptyException;

public class CarResource {

    public static final String CARS = "cars";

    public static final String ID = "/{id}";

    public void createCar(String carId) throws CarIdInvalidException, FieldNullOrEmptyException {
        this.validateId(carId);
        int id = Integer.parseInt(carId);
        new CarController().createCar(id);
    }

    public CarDto readCar(String carId) throws CarIdNotFoundException, CarIdInvalidException, FieldNullOrEmptyException {
        this.validateId(carId);
        int id = Integer.parseInt(carId);
        Optional<CarDto> optional = new CarController().readCar(id);
        return optional.orElseThrow(() -> new CarIdNotFoundException(carId));
    }

    private void validateId(String carId) throws CarIdInvalidException, FieldNullOrEmptyException {
        try {
            Integer.parseInt(carId);
        } catch (Exception e) {
            throw new CarIdInvalidException(carId);
        }
        this.validateField(carId);
    }
    
    private void validateField(String field) throws FieldNullOrEmptyException {
        if (field == null || field.isEmpty()) {
            throw new FieldNullOrEmptyException(field);
        }
    }

}

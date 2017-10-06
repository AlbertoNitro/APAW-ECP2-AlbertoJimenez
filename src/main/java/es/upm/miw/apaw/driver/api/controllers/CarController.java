package es.upm.miw.apaw.driver.api.controllers;

import java.util.Optional;

import es.upm.miw.apaw.driver.api.daos.DaoFactory;
import es.upm.miw.apaw.driver.api.dtos.CarDto;
import es.upm.miw.apaw.driver.api.dtos.DriverDto;
import es.upm.miw.apaw.driver.api.entities.Car;

public class CarController {

    public void createCar(int carId) {
        DaoFactory.getFactory().getCarDao().create(new Car(carId));
    }

    public Optional<CarDto> readDriver(Integer carId) {
        // TODO Auto-generated method stub
        return null;
    }

}

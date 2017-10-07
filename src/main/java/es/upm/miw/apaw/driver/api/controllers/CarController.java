package es.upm.miw.apaw.driver.api.controllers;

import java.util.Optional;

import es.upm.miw.apaw.driver.api.daos.DaoFactory;
import es.upm.miw.apaw.driver.api.dtos.CarDto;
import es.upm.miw.apaw.driver.api.entities.CarBuilder;

public class CarController {

    public void createCar(int carId) {
        DaoFactory.getFactory().getCarDao().create(new CarBuilder().id(1).model("Renault Megane").build());
    }

    private boolean existCarId(int carId) {
        return DaoFactory.getFactory().getCarDao().read(carId) != null;
    }

    public Optional<CarDto> readCar(int carId) {
        if (existCarId(carId)) {
            return Optional.of(new CarDto(DaoFactory.getFactory().getCarDao().read(carId)));
        } else {
            return Optional.empty();
        }
    }

}

package es.upm.miw.apaw.driver.api.controllers;

import es.upm.miw.apaw.driver.api.daos.DaoFactory;
import es.upm.miw.apaw.driver.api.entities.Car;

public class CarController {

    public void createCar(int carId) {
        DaoFactory.getFactory().getCarDao().create(new Car(carId));
    }

}

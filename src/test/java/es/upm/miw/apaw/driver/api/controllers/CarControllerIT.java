package es.upm.miw.apaw.driver.api.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.driver.api.daos.DaoFactory;
import es.upm.miw.apaw.driver.api.daos.memory.DaoMemoryFactory;

public class CarControllerIT {
    private CarController carController;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        carController = new CarController();
        carController.createCar(1);
    }

}

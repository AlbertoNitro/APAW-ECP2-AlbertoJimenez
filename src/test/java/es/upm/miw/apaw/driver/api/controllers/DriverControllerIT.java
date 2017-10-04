package es.upm.miw.apaw.driver.api.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.driver.api.daos.DaoFactory;
import es.upm.miw.apaw.driver.api.daos.memory.DaoMemoryFactory;

public class DriverControllerIT {
    private DriverController driverController;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        driverController = new DriverController();
        driverController.createDriver(1);
    }

}

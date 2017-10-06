package es.upm.miw.apaw.driver.api.controllers;

import static org.junit.Assert.*;

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

    @Test
    public void testReadDriver() {
        assertEquals(1, driverController.readDriver(1).get().getId());
    }

    @Test
    public void testReadDriverNonExistId() {
        assertFalse(driverController.readDriver(2).isPresent());
    }
    
    @Test
    public void testUpdatePhoneDriver() {
        assertEquals(665129265, driverController.updatePhoneDriver(1, 665129265).get().getPhone());
    }
    
    @Test
    public void testUpdatePhoneDriverNonExistId() {
        assertFalse(driverController.updatePhoneDriver(56, 665129265).isPresent());
    }
    
    @Test
    public void testDeleteDriverNonExistId() {
        assertFalse(driverController.deleteDriver(6778));
    }
    
    @Test
    public void testDeleteDriver() {
        assertTrue(driverController.deleteDriver(1));
    }
}

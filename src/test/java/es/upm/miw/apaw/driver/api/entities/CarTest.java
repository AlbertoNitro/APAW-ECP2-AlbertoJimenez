package es.upm.miw.apaw.driver.api.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarTest {
    private Car car;

    @Before
    public void before() {
        this.car = new Car(1);
        this.car.setModel("Renault Megane");
        this.car.setRegistration("Madrid");
    }

    @Test
    public void testCar() {
        assertEquals(1, this.car.getId());
        assertEquals("Madrid", this.car.getRegistration());
        assertEquals("Renault Megane", this.car.getModel());
    }

    @Test
    public void testGetModel() {
        assertEquals("Renault Megane", this.car.getModel());
    }

    @Test
    public void testGetId() {
        assertEquals(1, this.car.getId());
    }

    @Test
    public void testGetRegistration() {
        assertEquals("Madrid", this.car.getRegistration());
    }

    @Test
    public void testSetId() {
        this.car.setId(77);
        assertEquals(77, this.car.getId());
    }

    @Test
    public void testSetRegistration() {
        this.car.setRegistration("Barcelona");
        assertEquals("Barcelona", this.car.getRegistration());
    }

    @Test
    public void testSetModel() {
        this.car.setModel("Renault Clio");
        assertEquals("Renault Clio", this.car.getModel());
    }

}

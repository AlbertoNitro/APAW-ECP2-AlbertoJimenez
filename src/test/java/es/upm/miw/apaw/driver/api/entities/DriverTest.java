package es.upm.miw.apaw.driver.api.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DriverTest {
    private Driver driver;

    private Car car;

    @Before
    public void before() {
        this.car = new CarBuilder().id(1).model("Renault Megane").registration("Madrid").build();
        this.driver = new Driver(22);
        this.driver.setReference("AJGM");
        this.driver.setPhone(665129265);
    }

    @Test
    public void testDriver() {
        assertEquals(22, this.driver.getId());
        assertEquals("AJGM", this.driver.getReference());
        assertEquals(665129265, this.driver.getPhone());
        assertEquals(Level.BEGINNER, this.driver.getLevel());
        assertEquals(null, this.driver.getCar());
    }

    @Test
    public void testGetId() {
        assertEquals(22, this.driver.getId());
        this.driver.setId(55);
        assertEquals(55, this.driver.getId());
    }

    @Test
    public void testGetReference() {
        assertEquals("AJGM", this.driver.getReference());
    }

    @Test
    public void testGetPhone() {
        assertEquals(665129265, this.driver.getPhone());
    }

    @Test
    public void testGetLevel() {
        this.driver.setLevel(Level.NORMAL);
        assertEquals(Level.NORMAL, this.driver.getLevel());
    }

    @Test
    public void testGetCar() {
        this.driver.setCar(this.car);
        assertEquals(this.car, this.driver.getCar());
    }

}

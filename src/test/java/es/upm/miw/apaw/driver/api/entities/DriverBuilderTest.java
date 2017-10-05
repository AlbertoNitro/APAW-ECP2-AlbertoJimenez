package es.upm.miw.apaw.driver.api.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DriverBuilderTest {
    private Car car;

    private Driver driver;

    @Before
    public void before() {
        this.car = new CarBuilder().id(1).model("Renault Megane").registration("Madrid").build();
        this.driver = new DriverBuilder().id(1).car(car).level(Level.EXPERT).phone(665129265).reference("AJGM").build();
    }

    @Test
    public void testDriverBuilderInt() {
        this.driver = new DriverBuilder(4).car(car).build();
        assertEquals(4, driver.getId());
        assertEquals(car, driver.getCar());
        assertEquals(Level.BEGINNER, driver.getLevel());
    }

    @Test
    public void testDriverBuilder() {
        this.driver = new DriverBuilder().id(4).car(car).build();
        assertEquals(4, driver.getId());
        assertEquals(car, driver.getCar());
        assertEquals(Level.BEGINNER, driver.getLevel());
    }

    @Test
    public void testId() {
        assertEquals(1, driver.getId());
    }

    @Test
    public void testPhone() {
        assertEquals(665129265, driver.getPhone());
    }

    @Test
    public void testReference() {
        assertEquals("AJGM", driver.getReference());
    }

    @Test
    public void testLevel() {
        assertEquals(Level.EXPERT, driver.getLevel());
    }

    @Test
    public void testCar() {
        assertEquals(this.car, driver.getCar());
    }

}

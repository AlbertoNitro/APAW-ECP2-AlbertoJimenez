package es.upm.miw.apaw.driver.api.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarBuilderTest {
    private Car car;

    @Before
    public void before() {
        this.car = new CarBuilder().id(1).model("Seat Leon").registration("Madrid").build();
    }

    @Test
    public void testCarBuilderInt() {
        this.car = new CarBuilder(3).build();
        assertEquals(3, car.getId());
        assertEquals(null, car.getModel());
        assertEquals(null, car.getRegistration());
    }

    @Test
    public void testCarBuilder() {
        assertEquals(1, car.getId());
        assertEquals("Seat Leon", car.getModel());
        assertEquals("Madrid", car.getRegistration());
        this.car = new CarBuilder().build();
        assertEquals(0, car.getId());
        assertEquals(null, car.getModel());
        assertEquals(null, car.getRegistration());
    }

    @Test
    public void testId() {
        assertEquals(1, car.getId());
    }

    @Test
    public void testRegistration() {
        assertEquals("Madrid", car.getRegistration());
    }

    @Test
    public void testModel() {
        assertEquals("Seat Leon", car.getModel());
    }

}

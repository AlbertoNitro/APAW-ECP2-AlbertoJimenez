package es.upm.miw.apaw.driver.api.dtos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.driver.api.entities.Car;
import es.upm.miw.apaw.driver.api.entities.CarBuilder;

public class CarDtoTest {

    private CarDto carDto;

    @Before
    public void before() {
        Car car = new CarBuilder().id(1).model("Renault Megane").registration("1184CPL").build();
        this.carDto = new CarDto(car);
    }

    @Test
    public void testGetId() {
        assertEquals(1, carDto.getId());
    }

    @Test
    public void testGetRegistration() {
        assertEquals("Renault Megane", carDto.getModel());
    }

    @Test
    public void testGetModel() {
        assertEquals("1184CPL", carDto.getRegistration());
    }

    @Test
    public void testSetId() {
        carDto.setId(33);
        assertEquals(33, carDto.getId());
    }

    @Test
    public void testSetRegistration() {
        carDto.setRegistration("Renault Clio");
        assertEquals("Renault Clio", carDto.getRegistration());
    }

    @Test
    public void testSetModel() {
        carDto.setModel("1111CPL");
        assertEquals("1111CPL", carDto.getModel());
    }

}

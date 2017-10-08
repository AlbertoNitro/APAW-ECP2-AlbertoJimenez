package es.upm.miw.apaw.driver.api.dtos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.driver.api.entities.Car;
import es.upm.miw.apaw.driver.api.entities.CarBuilder;
import es.upm.miw.apaw.driver.api.entities.Driver;
import es.upm.miw.apaw.driver.api.entities.DriverBuilder;
import es.upm.miw.apaw.driver.api.entities.Level;

public class DriverDtoTest {

    private DriverDto driverDto;
    
    @Before
    public void before() {
        Driver driver = new DriverBuilder().id(1).phone(665129265).reference("AJGM").build();
        this.driverDto = new DriverDto(driver);
    }
    
    @Test
    public void testGetId() {
        assertEquals(1, driverDto.getId());
    }

    @Test
    public void testSetId() {
        driverDto.setId(44);
        assertEquals(44, driverDto.getId());
    }

    @Test
    public void testGetPhone() {
        assertEquals(665129265, driverDto.getPhone());
    }

    @Test
    public void testSetPhone() {
        driverDto.setPhone(665129266);
        assertEquals(665129266, driverDto.getPhone());
    }

    @Test
    public void testGetReference() {
        assertEquals("AJGM", driverDto.getReference());
    }

    @Test
    public void testSetReference() {
        driverDto.setReference("AAAA");
        assertEquals("AAAA", driverDto.getReference());
    }


}

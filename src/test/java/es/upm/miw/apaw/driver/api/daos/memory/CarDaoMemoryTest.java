package es.upm.miw.apaw.driver.api.daos.memory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.driver.api.daos.DaoFactory;
import es.upm.miw.apaw.driver.api.entities.Car;
import es.upm.miw.apaw.driver.api.entities.CarBuilder;

public class CarDaoMemoryTest {
    private Car car;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        this.car = new CarBuilder().id(1).model("Renault Megane").registration("1184CPL").build();
        DaoFactory.getFactory().getCarDao().create(this.car);
    }
    
    @Test
    public void testReadCar() {
        assertEquals(1, DaoFactory.getFactory().getCarDao().read(1).getId());
        assertEquals("Renault Megane", DaoFactory.getFactory().getCarDao().read(1).getModel());
        assertEquals("1184CPL", DaoFactory.getFactory().getCarDao().read(1).getRegistration());
    }

    @Test
    public void testReadCarNonExistId() {
        assertNull(DaoFactory.getFactory().getCarDao().read(2));
    }
}

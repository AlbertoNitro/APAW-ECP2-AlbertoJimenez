package es.upm.miw.apaw.driver.api.daos.memory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.driver.api.daos.DaoFactory;
import es.upm.miw.apaw.driver.api.entities.Driver;
import es.upm.miw.apaw.driver.api.entities.DriverBuilder;

public class DriverDaoMemoryTest {
    private Driver driver;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        this.driver = new DriverBuilder().id(1).phone(665129266).build();
        DaoFactory.getFactory().getDriverDao().create(driver);
    }

    @Test
    public void testReadDriver() {
        assertEquals(1, DaoFactory.getFactory().getDriverDao().read(1).getId());
        assertEquals(665129266, DaoFactory.getFactory().getDriverDao().read(1).getPhone());
    }

    @Test
    public void testReadDriverNonExistId() {
        assertNull(DaoFactory.getFactory().getDriverDao().read(2));
    }
    
    @Test
    public void testUpdatePhoneDriver() {
        assertEquals(665129265, DaoFactory.getFactory().getDriverDao().updatePhone(1, 665129265).getPhone());
    }

    @Test
    public void testDeleteDriver() {
        assertEquals(1, DaoFactory.getFactory().getDriverDao().read(1).getId());
        DaoFactory.getFactory().getDriverDao().deleteById(1);
        assertNull(DaoFactory.getFactory().getDriverDao().read(1));
    }

}

package es.upm.miw.apaw.driver.api.daos.memory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.driver.api.daos.DaoFactory;
import es.upm.miw.apaw.driver.api.entities.Driver;

public class DriverDaoMemoryTest {
    private Driver driver;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        driver = new Driver(1);
        DaoFactory.getFactory().getDriverDao().create(driver);
    }

    @Test
    public void testReadTheme() {
        assertEquals(1, DaoFactory.getFactory().getDriverDao().read(1).getId());
    }

    @Test
    public void testReadNonExistId() {
        assertNull(DaoFactory.getFactory().getDriverDao().read(2));
    }

}

package es.upm.miw.apaw.driver.api.daos.memory;

import java.util.HashMap;

import es.upm.miw.apaw.driver.api.daos.DriverDao;
import es.upm.miw.apaw.driver.api.entities.Driver;

public class DriverDaoMemory extends GenericDaoMemory<Driver> implements DriverDao {

    public DriverDaoMemory() {
        this.setMap(new HashMap<Integer, Driver>());
    }

    @Override
    protected Integer getId(Driver entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Driver entity, Integer id) {
        entity.setId(id);

    }

    @Override
    public Driver updatePhone(int driverId, long phoneDriver) {
        Driver driver = this.read(driverId);
        driver.setPhone(phoneDriver);
        this.update(driver);
        return driver;
    }

}

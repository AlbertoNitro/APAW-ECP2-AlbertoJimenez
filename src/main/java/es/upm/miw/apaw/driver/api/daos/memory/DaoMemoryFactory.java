package es.upm.miw.apaw.driver.api.daos.memory;

import es.upm.miw.apaw.driver.api.daos.CarDao;
import es.upm.miw.apaw.driver.api.daos.DaoFactory;
import es.upm.miw.apaw.driver.api.daos.DriverDao;

public class DaoMemoryFactory extends DaoFactory {

    private DriverDao driverDao;

    @Override
    public DriverDao getDriverDao() {
        if (driverDao == null) {
            driverDao = new DriverDaoMemory();
        }
        return driverDao;
    }

    @Override
    public CarDao getCarDao() {
        // TODO Auto-generated method stub
        return null;
    }

}

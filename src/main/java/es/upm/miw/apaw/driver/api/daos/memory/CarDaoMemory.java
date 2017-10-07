package es.upm.miw.apaw.driver.api.daos.memory;

import java.util.HashMap;

import es.upm.miw.apaw.driver.api.daos.CarDao;
import es.upm.miw.apaw.driver.api.entities.Car;

public class CarDaoMemory extends GenericDaoMemory<Car> implements CarDao {
    
    public CarDaoMemory() {
        this.setMap(new HashMap<Integer, Car>());
    }

    @Override
    protected Integer getId(Car entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Car entity, Integer id) {
        entity.setId(id);
    }

}

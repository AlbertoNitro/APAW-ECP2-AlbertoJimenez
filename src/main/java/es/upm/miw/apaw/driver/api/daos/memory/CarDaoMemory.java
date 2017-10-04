package es.upm.miw.apaw.driver.api.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.upm.miw.apaw.driver.api.daos.CarDao;
import es.upm.miw.apaw.driver.api.entities.Car;

public class CarDaoMemory extends GenericDaoMemory<Car> implements CarDao {

    @Override
    public List<Integer> findValueByThemeId(int themeId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Integer getId(Car entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void setId(Car entity, Integer id) {
        // TODO Auto-generated method stub
        
    }

}

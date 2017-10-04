package es.upm.miw.apaw.driver.api.daos;

import java.util.List;

import es.upm.miw.apaw.driver.api.entities.Car;

public interface CarDao extends GenericDao<Car, Integer> {

    List<Integer> findValueByThemeId(int themeId);
}

package es.upm.miw.apaw.driver.api.daos.memory;

import org.junit.Before;

import es.upm.miw.apaw.driver.api.daos.DaoFactory;
import es.upm.miw.apaw.driver.api.entities.Car;
import es.upm.miw.apaw.driver.api.entities.CarBuilder;

public class CarDaoMemoryTest {
    private Car car;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
        this.car = new CarBuilder().id(1).model("Renault Megane").build();
        DaoFactory.getFactory().getCarDao().create(car);
    }
}

package es.upm.miw.apaw.driver.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.upm.miw.apaw.driver.api.daos.DaoFactory;
import es.upm.miw.apaw.driver.api.dtos.DriverDto;
import es.upm.miw.apaw.driver.api.entities.Driver;
import es.upm.miw.apaw.driver.api.dtos.DriverCarListDto;

public class DriverController {

    public void createDriver(int driverId) {
        DaoFactory.getFactory().getDriverDao().create(new Driver(driverId));
    }

    private boolean existThemeId(int driverId) {
        return DaoFactory.getFactory().getDriverDao().read(driverId) != null;
    }

    public Optional<DriverDto> readDriver(int driverId) {
        // TODO Auto-generated method stub
        return null;
    }

}

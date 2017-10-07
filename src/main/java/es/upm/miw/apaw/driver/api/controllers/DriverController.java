package es.upm.miw.apaw.driver.api.controllers;

import java.util.Optional;

import es.upm.miw.apaw.driver.api.daos.DaoFactory;
import es.upm.miw.apaw.driver.api.dtos.DriverDto;
import es.upm.miw.apaw.driver.api.entities.DriverBuilder;

public class DriverController {

    public void createDriver(int driverId, long driverPhone) {
        DaoFactory.getFactory().getDriverDao().create(new DriverBuilder().id(driverId).phone(driverPhone).build());
    }

    private boolean existDriverId(int driverId) {
        return DaoFactory.getFactory().getDriverDao().read(driverId) != null;
    }

    public Optional<DriverDto> readDriver(int driverId) {
        if (existDriverId(driverId)) {
            return Optional.of(new DriverDto(DaoFactory.getFactory().getDriverDao().read(driverId)));
        } else {
            return Optional.empty();
        }
    }

    public Optional<DriverDto> updatePhoneDriver(Integer driverId, long phoneDriver) {
        if (existDriverId(driverId)) {
            return Optional.of(new DriverDto(DaoFactory.getFactory().getDriverDao().updatePhone(driverId, phoneDriver)));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteDriver(Integer driverId) {
        if (existDriverId(driverId)) {
           DaoFactory.getFactory().getDriverDao().deleteById(driverId);
           return true;
        } else {
            return false;
        }
    }

}

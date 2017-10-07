package es.upm.miw.apaw.driver.api.resources;

import java.util.Optional;

import es.upm.miw.apaw.driver.api.controllers.DriverController;
import es.upm.miw.apaw.driver.api.dtos.DriverDto;
import es.upm.miw.apaw.driver.api.resources.exceptions.DriverIdInvalidException;
import es.upm.miw.apaw.driver.api.resources.exceptions.DriverIdNotFoundException;
import es.upm.miw.apaw.driver.api.resources.exceptions.DriverPhoneInvalidException;
import es.upm.miw.apaw.driver.api.resources.exceptions.FieldNullOrEmptyException;

public class DriverResource {

    public static final String DRIVERS = "drivers";

    public static final String ID = "/{id}";

    public void createDriver(String driverId) throws DriverIdInvalidException, FieldNullOrEmptyException {
        this.validateId(driverId);
        int id = Integer.parseInt(driverId);
        new DriverController().createDriver(id);
    }

    public DriverDto readDriver(String driverId) throws DriverIdNotFoundException, DriverIdInvalidException, FieldNullOrEmptyException {
        this.validateId(driverId);
        int id = Integer.parseInt(driverId);
        Optional<DriverDto> optional = new DriverController().readDriver(id);
        return optional.orElseThrow(() -> new DriverIdNotFoundException(driverId));
    }

    public DriverDto updatePhoneDriver(String driverId, String driverPhone) throws DriverPhoneInvalidException, DriverIdInvalidException, DriverIdNotFoundException, FieldNullOrEmptyException {
        this.validateId(driverId);
        this.validatePhone(driverPhone);
        int id = Integer.parseInt(driverId);
        long phone = Long.parseLong(driverPhone);
        Optional<DriverDto> optional = new DriverController().updatePhoneDriver(id, phone);
        return optional.orElseThrow(() -> new DriverIdNotFoundException(driverId));
    }

    public boolean deleteDriver(String driverId) throws DriverIdInvalidException, FieldNullOrEmptyException {
        this.validateId(driverId);
        int id = Integer.parseInt(driverId);
        return new DriverController().deleteDriver(id);
    }

    private void validateId(String driverId) throws DriverIdInvalidException, FieldNullOrEmptyException {
        try {
            Integer.parseInt(driverId);
        } catch (Exception e) {
            throw new DriverIdInvalidException(driverId);
        }
        this.validateField(driverId);
    }

    private void validatePhone(String phone) throws DriverPhoneInvalidException, FieldNullOrEmptyException {
        try {
            Long.parseLong(phone);
        } catch (Exception e) {
            throw new DriverPhoneInvalidException(phone);
        }
        this.validateField(phone);
    }

    private void validateField(String field) throws FieldNullOrEmptyException {
        if (field == null || field.isEmpty()) {
            throw new FieldNullOrEmptyException(field);
        }
    }

}

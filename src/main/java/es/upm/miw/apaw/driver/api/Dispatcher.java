package es.upm.miw.apaw.driver.api;

import es.upm.miw.apaw.driver.api.resources.DriverResource;
import es.upm.miw.apaw.driver.api.resources.CarResource;
import es.upm.miw.apaw.driver.api.resources.exceptions.DriverIdNotFoundException;
import es.upm.miw.apaw.driver.api.resources.exceptions.RequestInvalidException;
import es.upm.miw.apaw.driver.http.HttpRequest;
import es.upm.miw.apaw.driver.http.HttpResponse;
import es.upm.miw.apaw.driver.http.HttpStatus;

public class Dispatcher {

    private DriverResource driverResource = new DriverResource();

    private CarResource carResource = new CarResource();

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        try {
            String id = request.paths()[1];
            if (request.isEqualsPath(DriverResource.DRIVERS + DriverResource.ID)) {
                response.setBody(driverResource.readDriver(id).toString());
                response.setStatus(HttpStatus.OK);
            } else if (request.isEqualsPath(CarResource.CARS + CarResource.ID)) {
                response.setBody(carResource.readCar(id).toString());
                response.setStatus(HttpStatus.OK);
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(DriverResource.DRIVERS)) {
                driverResource.createDriver(request.getBody());
                response.setStatus(HttpStatus.CREATED);
            } else if (request.isEqualsPath(CarResource.CARS)) {
                carResource.createCar(request.getBody());
                response.setStatus(HttpStatus.CREATED);
            } else {
                throw new RequestInvalidException(request.getPath());
            }

        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doPut(HttpRequest request, HttpResponse response) {
        responseError(response, new RequestInvalidException(request.getPath()));
    }

    public void doPatch(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(DriverResource.DRIVERS + DriverResource.ID + DriverResource.PHONE)) {
                String driverId = request.paths()[1];
                String driverPhone = request.getBody();
                response.setBody(driverResource.updatePhoneDriver(driverId, driverPhone).toString());
                response.setStatus(HttpStatus.OK);
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath(DriverResource.DRIVERS + DriverResource.ID)) {
                String driverId = request.paths()[1];
                boolean success = driverResource.deleteDriver(driverId);
                if (!success)
                    throw new DriverIdNotFoundException(driverId);
                else {
                    response.setStatus(HttpStatus.OK);
                }
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

}

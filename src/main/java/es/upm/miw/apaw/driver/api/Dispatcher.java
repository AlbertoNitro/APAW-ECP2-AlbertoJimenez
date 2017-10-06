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
            if (request.isEqualsPath(DriverResource.DRIVERS + DriverResource.ID)) {
                response.setBody(driverResource.readDriver(Integer.valueOf(request.paths()[1])).toString());
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
            if (request.isEqualsPath(DriverResource.DRIVERS + DriverResource.ID)) {
                int driverId = Integer.valueOf(request.paths()[1]);
                long phoneDriver = Long.valueOf(request.getBody());     
                response.setBody(driverResource.updatePhoneDriver(driverId, phoneDriver).toString());
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
                int driverId = Integer.valueOf(request.paths()[1]);
               boolean resultado = driverResource.deleteDriver(driverId);
               if (!resultado)
                   throw new DriverIdNotFoundException(Integer.toString(driverId));
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

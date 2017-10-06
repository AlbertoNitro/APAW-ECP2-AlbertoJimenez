package es.upm.miw.apaw.driver;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import es.upm.miw.apaw.driver.api.daos.DaoFactory;
import es.upm.miw.apaw.driver.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.driver.api.resources.CarResource;
import es.upm.miw.apaw.driver.api.resources.DriverResource;
import es.upm.miw.apaw.driver.http.HttpClientService;
import es.upm.miw.apaw.driver.http.HttpException;
import es.upm.miw.apaw.driver.http.HttpMethod;
import es.upm.miw.apaw.driver.http.HttpRequest;
import es.upm.miw.apaw.driver.http.HttpRequestBuilder;
import es.upm.miw.apaw.driver.http.HttpStatus;

public class CarResourceFunctionalTesting {
    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private void createCar() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CarResource.CARS).body("1").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateCar() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CarResource.CARS).body("1").build();
        assertEquals(HttpStatus.CREATED, new HttpClientService().httpRequest(request).getStatus());
    }

    @Test(expected = HttpException.class)
    public void testCreateCarIdEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CarResource.CARS).body("").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateWithoutCarId() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(CarResource.CARS).build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testReadCar() {
        this.createCar();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(CarResource.CARS).path(CarResource.ID).expandPath("1").build();
        assertEquals("{\"id\":1,\"model\":\"\"\", \"registration\":\"\"\"\"}", new HttpClientService().httpRequest(request).getBody());
    }

    @Test(expected = HttpException.class)
    public void testReadCarIdEmpty() {
        this.createCar();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(CarResource.CARS).path(CarResource.ID).build();
        new HttpClientService().httpRequest(request).getBody();
    }
}

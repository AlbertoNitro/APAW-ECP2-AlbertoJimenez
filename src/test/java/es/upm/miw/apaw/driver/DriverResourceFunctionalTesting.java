package es.upm.miw.apaw.driver;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.driver.api.daos.DaoFactory;
import es.upm.miw.apaw.driver.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.driver.api.resources.DriverResource;
import es.upm.miw.apaw.driver.api.resources.exceptions.DriverIdNotFoundException;
import es.upm.miw.apaw.driver.http.HttpClientService;
import es.upm.miw.apaw.driver.http.HttpException;
import es.upm.miw.apaw.driver.http.HttpMethod;
import es.upm.miw.apaw.driver.http.HttpRequest;
import es.upm.miw.apaw.driver.http.HttpRequestBuilder;

public class DriverResourceFunctionalTesting {

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private void createDriver() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(DriverResource.DRIVERS).body("1").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateDriver() {
        this.createDriver();
    }

    @Test(expected = HttpException.class)
    public void testCreateDriverIdEmpty() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(DriverResource.DRIVERS).body("").build();
        new HttpClientService().httpRequest(request);
    }

    @Test(expected = HttpException.class)
    public void testCreateWithoutDriverId() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(DriverResource.DRIVERS).build();
        new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testReadDriver() {
        this.createDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(DriverResource.DRIVERS).path(DriverResource.ID).expandPath("1").build();
        assertEquals("{\"id\":1,\"phone\":\"0\"}", new HttpClientService().httpRequest(request).getBody());
    }
    
    @Test(expected = HttpException.class)
    public void testReadDriverIdEmpty() {
        this.createDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(DriverResource.DRIVERS).path(DriverResource.ID).build();
        new HttpClientService().httpRequest(request).getBody();
    }
    
    @Test(expected = HttpException.class)
    public void testUpdatePhoneDriverIdNotFound() {
        this.createDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PATCH).path(DriverResource.DRIVERS).path(DriverResource.ID).expandPath("33").body("665129265").build();
        new HttpClientService().httpRequest(request).getBody();
    }
    
    /*
    @Test(expected = HttpException.class)
    public void testUpdatePhoneDriverEmpty() {
        this.createDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PATCH).path(DriverResource.DRIVERS).path(DriverResource.ID).expandPath("1").body("").build();
        new HttpClientService().httpRequest(request).getBody();
    }
    */
    
    
    @Test(expected = HttpException.class)
    public void testUpdatePhoneDriverInvalid() {
        this.createDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PATCH).path(DriverResource.DRIVERS).path(DriverResource.ID).expandPath("1").body("fgfgfghghj").build();
        new HttpClientService().httpRequest(request).getBody();
    }
    
    @Test(expected = HttpException.class)
    public void testUpdatePhoneDriver() {
        this.createDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PATCH).path(DriverResource.DRIVERS).path(DriverResource.ID).expandPath("1").body("665129265").build();
        new HttpClientService().httpRequest(request).getBody();
    }
    
    @Test(expected = HttpException.class)
    public void testDeleteDriverInvalid() {
        this.createDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.DELETE).path(DriverResource.DRIVERS).path(DriverResource.ID).expandPath("55").build();
        new HttpClientService().httpRequest(request).getBody();
    }
    
    @Test(expected = HttpException.class)
    public void testDeleteDriver() {
        this.createDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.DELETE).path(DriverResource.DRIVERS).path(DriverResource.ID).expandPath("1").build();
        new HttpClientService().httpRequest(request).getBody();
        request = new HttpRequestBuilder().method(HttpMethod.GET).path(DriverResource.DRIVERS).path(DriverResource.ID).expandPath("1").build();
        
    }
    
    @Test(expected = HttpException.class)
    public void testDeleteWithoutDriverId() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(DriverResource.DRIVERS).build();
        new HttpClientService().httpRequest(request);
    }
    
    
}

package es.upm.miw.apaw.driver;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.driver.api.daos.DaoFactory;
import es.upm.miw.apaw.driver.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.driver.api.resources.DriverResource;
import es.upm.miw.apaw.driver.http.HttpClientService;
import es.upm.miw.apaw.driver.http.HttpException;
import es.upm.miw.apaw.driver.http.HttpMethod;
import es.upm.miw.apaw.driver.http.HttpRequest;
import es.upm.miw.apaw.driver.http.HttpRequestBuilder;
import es.upm.miw.apaw.driver.http.HttpStatus;

public class DriverResourceFunctionalTesting {

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private void createDriver() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(DriverResource.DRIVERS).body("1:665129266").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateDriver() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(DriverResource.DRIVERS).body("1:665129266").build();
        assertEquals(HttpStatus.CREATED, new HttpClientService().httpRequest(request).getStatus());

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

    @Test(expected = HttpException.class)
    public void testCreateWithoutDriverPhone() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path(DriverResource.DRIVERS).body("1:fgfdfggdf").build();
        new HttpClientService().httpRequest(request);
    }

    @Test
    public void testReadDriver() {
        this.createDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(DriverResource.DRIVERS).path(DriverResource.ID)
                .expandPath("1").build();
        assertEquals("{\"id\":\"1\",\"phone\":\"665129266\",\"reference\":\"null\",\"level\":\"BEGINNER\",\"car\":\"null\"}",
                new HttpClientService().httpRequest(request).getBody());
    }

    @Test(expected = HttpException.class)
    public void testReadDriverIdEmpty() {
        this.createDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(DriverResource.DRIVERS).path(DriverResource.ID)
                .path(DriverResource.PHONE).build();
        new HttpClientService().httpRequest(request).getBody();
    }

    @Test(expected = HttpException.class)
    public void testUpdatePhoneDriverIdNotFound() {
        this.createDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PATCH).path(DriverResource.DRIVERS).path(DriverResource.ID)
                .path(DriverResource.PHONE).expandPath("33").body("665129265").build();
        new HttpClientService().httpRequest(request).getBody();
    }

    @Test(expected = HttpException.class)
    public void testUpdatePhoneDriverInvalid() {
        this.createDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PATCH).path(DriverResource.DRIVERS).path(DriverResource.ID)
                .path(DriverResource.PHONE).body("fgfgfghghj").build();
        new HttpClientService().httpRequest(request).getBody();
    }

    @Test(expected = HttpException.class)
    public void testUpdatePhoneInvalid() {
        this.createDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.PATCH).path(DriverResource.DRIVERS).path(DriverResource.ID)
                .path(DriverResource.PHONE).expandPath("1").body("fgfgfghghj").build();
        new HttpClientService().httpRequest(request).getBody();
    }

    @Test
    public void testUpdatePhoneDriver() {
        this.createDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.GET).path(DriverResource.DRIVERS).path(DriverResource.ID)
                .expandPath("1").build();
        assertEquals("{\"id\":\"1\",\"phone\":\"665129266\",\"reference\":\"null\",\"level\":\"BEGINNER\",\"car\":\"null\"}",
                new HttpClientService().httpRequest(request).getBody());
        HttpRequest request2 = new HttpRequestBuilder().method(HttpMethod.PATCH).path(DriverResource.DRIVERS).path(DriverResource.ID)
                .path(DriverResource.PHONE).expandPath("1").body("665129265").build();
        new HttpClientService().httpRequest(request2).getBody();
        HttpRequest request3 = new HttpRequestBuilder().method(HttpMethod.GET).path(DriverResource.DRIVERS).path(DriverResource.ID)
                .expandPath("1").build();
        assertEquals("{\"id\":\"1\",\"phone\":\"665129265\",\"reference\":\"null\",\"level\":\"BEGINNER\",\"car\":\"null\"}",
                new HttpClientService().httpRequest(request3).getBody());
    }

    @Test(expected = HttpException.class)
    public void testDeleteDriverInvalid() {
        this.createDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.DELETE).path(DriverResource.DRIVERS).path(DriverResource.ID)
                .expandPath("55").build();
        new HttpClientService().httpRequest(request).getBody();
    }

    @Test(expected = HttpException.class)
    public void testDeleteDriver() {
        this.createDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.DELETE).path(DriverResource.DRIVERS).path(DriverResource.ID)
                .expandPath("1").build();
        new HttpClientService().httpRequest(request).getBody();
        HttpRequest request2 = new HttpRequestBuilder().method(HttpMethod.GET).path(DriverResource.DRIVERS).path(DriverResource.ID)
                .expandPath("1").build();
        new HttpClientService().httpRequest(request2).getBody();
    }

    @Test(expected = HttpException.class)
    public void testDeleteWithoutDriverId() {
        this.createDriver();
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.DELETE).path(DriverResource.DRIVERS).path(DriverResource.ID)
                .build();
        new HttpClientService().httpRequest(request).getBody();
    }

}

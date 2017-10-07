package es.upm.miw.apaw.driver.api.resources.exceptions;

import java.io.Serializable;

public class CarIdNotFoundException extends Exception implements Serializable {

    private static final long serialVersionUID = -7854768100218583979L;

    public static final String DESCRIPTION = "El identificador del coche no existe";

    public CarIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public CarIdNotFoundException() {
        this("");
    }
}

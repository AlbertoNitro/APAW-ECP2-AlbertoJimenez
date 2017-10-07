package es.upm.miw.apaw.driver.api.resources.exceptions;

import java.io.Serializable;

public class DriverIdNotFoundException extends Exception implements Serializable {
    private static final long serialVersionUID = -6612873371829112749L;

    public static final String DESCRIPTION = "El identificador del conductor no existe";

    public DriverIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public DriverIdNotFoundException() {
        this("");
    }
}

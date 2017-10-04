package es.upm.miw.apaw.driver.api.resources.exceptions;

import java.io.Serializable;

public class DriverIdInvalidException extends Exception implements Serializable {

    private static final long serialVersionUID = -4552574363295154553L;

    public static final String DESCRIPTION = "Identificador de conductor no valido";

    public DriverIdInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public DriverIdInvalidException() {
        this("");
    }

}

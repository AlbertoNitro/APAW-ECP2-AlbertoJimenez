package es.upm.miw.apaw.driver.api.resources.exceptions;

import java.io.Serializable;

public class CarIdInvalidException extends Exception implements Serializable {

    private static final long serialVersionUID = -7073589778557552768L;
    
    public static final String DESCRIPTION = "Identificador de coche no valido";

    public CarIdInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public CarIdInvalidException() {
        this("");
    }

}

package es.upm.miw.apaw.driver.api.resources.exceptions;

import java.io.Serializable;

public class DriverPhoneInvalidException extends Exception implements Serializable {

    private static final long serialVersionUID = 7216612834600090798L;

    public static final String DESCRIPTION = "Telefono de conductor no valido)";

    public DriverPhoneInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public DriverPhoneInvalidException() {
        this("");
    }

}

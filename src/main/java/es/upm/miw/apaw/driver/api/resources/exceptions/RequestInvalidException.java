package es.upm.miw.apaw.driver.api.resources.exceptions;

import java.io.Serializable;

public class RequestInvalidException extends Exception implements Serializable {

    private static final long serialVersionUID = 7333607233144853052L;

    public static final String DESCRIPTION = "Petición no implementada";

    public RequestInvalidException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public RequestInvalidException() {
        this("");
    }

}

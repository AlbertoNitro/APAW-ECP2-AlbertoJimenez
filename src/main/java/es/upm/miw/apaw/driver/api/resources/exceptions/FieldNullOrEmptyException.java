package es.upm.miw.apaw.driver.api.resources.exceptions;

import java.io.Serializable;

public class FieldNullOrEmptyException extends Exception implements Serializable {

    private static final long serialVersionUID = 5819572763196811815L;

    public static final String DESCRIPTION = "Parametro de la peticion nulo o vacio";

    public FieldNullOrEmptyException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public FieldNullOrEmptyException() {
        this("");
    }

}

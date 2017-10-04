package es.upm.miw.apaw.driver.api.resources.exceptions;

public class DriverIdNotFoundException extends Exception {
    private static final long serialVersionUID = -3893110892899234744L;

    public static final String DESCRIPTION = "El id del tema no existe";

    public DriverIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public DriverIdNotFoundException() {
        this("");
    }
}

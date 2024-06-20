package BackendC3.ClinicaOdontologica.exceptions.customExceptions;

public class OdontologoNotFoundException extends RuntimeException {

    public OdontologoNotFoundException(String message) {
        super(message);
    }
}

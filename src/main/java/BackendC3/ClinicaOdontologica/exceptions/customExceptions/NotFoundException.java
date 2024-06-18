package BackendC3.ClinicaOdontologica.exceptions.customExceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}

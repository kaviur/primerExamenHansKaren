package BackendC3.ClinicaOdontologica.exceptions.customExceptions;

public class TurnoNotFoundException extends RuntimeException {
    public TurnoNotFoundException(String message) {
        super(message);
    }
}

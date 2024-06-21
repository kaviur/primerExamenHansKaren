package BackendC3.ClinicaOdontologica.exceptions.customExceptions;

public class PacienteNotFoundException extends RuntimeException {
    public PacienteNotFoundException(String message) {
        super(message);
    }
}

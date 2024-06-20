package BackendC3.ClinicaOdontologica.repository;

import BackendC3.ClinicaOdontologica.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository<Turno, Integer> {
}

package BackendC3.ClinicaOdontologica.repository;

import BackendC3.ClinicaOdontologica.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITurnoRepository extends JpaRepository<Turno, Long> {

    List<Turno> findAllByPacienteId(Long idPaciente);

    List<Turno> findAllByOdontologoId(Long idOdontologo);

}

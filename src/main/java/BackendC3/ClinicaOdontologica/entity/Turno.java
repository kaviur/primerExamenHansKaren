package BackendC3.ClinicaOdontologica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

}

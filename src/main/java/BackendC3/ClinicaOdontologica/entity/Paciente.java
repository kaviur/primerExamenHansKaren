package BackendC3.ClinicaOdontologica.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String apellido;

    @Column(unique = true)
    private String cedula;

    @Column(unique = true)
    private String email;

    private LocalDate fechaIngreso;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;

    @PrePersist
    public void fechaIngreso() {
        this.fechaIngreso = LocalDate.now();
    }

}

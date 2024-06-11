package BackendC3.ClinicaOdontologica.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String apellido;

    @Column(unique = true)
    private String cedula;

    private LocalDate fechaIngreso;

    @OneToOne
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;

    @Column(unique = true)
    private String email;

    @PrePersist
    public void fechaIngreso() {
        this.fechaIngreso = LocalDate.now();
    }

}

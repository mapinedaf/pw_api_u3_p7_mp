package uce.edu.web.api.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="persona")
@Getter
@Setter
@Builder
public class Persona {

    @Id
    @SequenceGenerator(name ="sec_persona",sequenceName = "sec_persona",allocationSize = 1 )
    @GeneratedValue(generator = "sec_persona", strategy = GenerationType.SEQUENCE)
    @Column(name = "pers_id")
    private Integer id;

    @Column(name = "pers_nombre")
    private String nombre;

    @Column(name = "pers_apellido")
    private String apellido;

    @Column(name = "pers_fecha_nacimiento")
    private LocalDateTime fechaNacimiento;

    
}

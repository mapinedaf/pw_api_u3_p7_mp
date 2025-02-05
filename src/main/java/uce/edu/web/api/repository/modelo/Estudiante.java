package uce.edu.web.api.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name ="estudiante")

public class Estudiante {

    @Id
    @SequenceGenerator(name ="sec_estudiante",sequenceName = "sec_estudiante",allocationSize = 1 )
    @GeneratedValue(generator = "sec_estudiante", strategy = GenerationType.SEQUENCE)
    @Column(name = "estu_id")
    private Integer id;

    public Estudiante() {
    }

    @Column(name = "estu_nombre")
    private String nombre;

    @Column(name = "estu_apellido")
    private String apellido;

    @Column(name = "estu_semestre")
    private Integer semestre;

    @Column(name = "estu_direccion")
    private String  direccion;

    

    public Estudiante(Integer id, String nombre, String apellido, Integer semestre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.semestre = semestre;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    
}

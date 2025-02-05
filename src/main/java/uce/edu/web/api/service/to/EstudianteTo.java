package uce.edu.web.api.service.to;

public class EstudianteTo {
    
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer semestre;
    private String  direccion;
    public String getNombre() {
        return nombre;
    }
    public EstudianteTo(Integer id,String nombre, String apellido, Integer semestre, String direccion) {
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
    public EstudianteTo() {
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

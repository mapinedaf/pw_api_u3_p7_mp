package uce.edu.web.api.service;

import java.util.List;

import uce.edu.web.api.service.to.EstudianteTo;

public interface IEstudianteService {


    public EstudianteTo buscarPorId(Integer id);
    public void guardar(EstudianteTo estudianteTo);
    public void actualizar(EstudianteTo estudianteTo);
    public void borrar(Integer id);
    public List<EstudianteTo> buscarTodos();
    public List<EstudianteTo> buscarPorNombre(String nombre);
    public List<EstudianteTo> buscarNombreApellido(String nombre, String apellido);

}

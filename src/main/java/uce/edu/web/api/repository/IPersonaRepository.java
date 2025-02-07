package uce.edu.web.api.repository;

import java.util.List;

import uce.edu.web.api.repository.modelo.Persona;

public interface IPersonaRepository {

    public List<Persona> buscarTodos();
    public List<Persona> buscarPorNombre(String nombre);
    public List<Persona> buscarNombreApellido(String nombre, String apellido);
    public Persona buscarPorId(Integer id);
    public void instertar(Persona persona);
    public void actualizar(Persona oersona);
    public void eliminar(Integer id);
    
}

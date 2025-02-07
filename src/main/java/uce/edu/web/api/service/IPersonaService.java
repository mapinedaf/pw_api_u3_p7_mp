package uce.edu.web.api.service;

import java.util.List;

import uce.edu.web.api.service.to.PersonaTo;

public interface IPersonaService {


    public PersonaTo buscarPorId(Integer id);
    public void guardar(PersonaTo persona);
    public void actualizar(PersonaTo oersona);
    public void borrar(Integer id);
    public List<PersonaTo> buscarTodos();
    public List<PersonaTo> buscarPorNombre(String nombre);
    public List<PersonaTo> buscarNombreApellido(String nombre, String apellido);
    
}

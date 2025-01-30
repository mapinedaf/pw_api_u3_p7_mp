package uce.edu.web.api.repository;

import uce.edu.web.api.repository.modelo.Persona;

public interface IPersonaRepository {

    public Persona buscarPorId(Integer id);
    public void instertar(Persona persona);
    public void actualizar(Persona oersona);
    public void eliminar(Integer id);
    
}

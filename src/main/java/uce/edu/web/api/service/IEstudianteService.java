package uce.edu.web.api.service;

import uce.edu.web.api.service.to.EstudianteTo;

public interface IEstudianteService {


    public EstudianteTo buscarPorId(Integer id);
    public void guardar(EstudianteTo estudianteTo);
    public void actualizar(EstudianteTo estudianteTo);
    public void borrar(Integer id);

}

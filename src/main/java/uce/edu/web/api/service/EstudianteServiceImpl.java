package uce.edu.web.api.service;

import java.util.function.Function;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IEstudianteRepository;
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.service.to.EstudianteTo;


@ApplicationScoped
public class EstudianteServiceImpl implements IEstudianteService {

    private Function<Estudiante,EstudianteTo> mapTo = e->{
        return new EstudianteTo(e.getId(),e.getNombre(),e.getApellido(),e.getSemestre(),e.getDireccion());
    }; 

    private Function<EstudianteTo,Estudiante> mapEstudiante = eTo ->{
        return new Estudiante(eTo.getId(),eTo.getNombre(),eTo.getApellido(),eTo.getSemestre(),eTo.getDireccion());
    };

    @Inject
    private IEstudianteRepository  repo;

    @Override
    public EstudianteTo buscarPorId(Integer id) {
        return this.mapTo.apply(repo.seleccionarPorId(id));
    }

    @Override
    public void guardar(EstudianteTo estudianteTo) {
        this.repo.instertar(this.mapEstudiante.apply(estudianteTo));
    }

    @Override
    public void actualizar(EstudianteTo estudianteTo) {
        this.repo.actualizar(this.mapEstudiante.apply(estudianteTo));
    }

    @Override
    public void borrar(Integer id) {
       this.repo.eliminar(id);
    }

    
}

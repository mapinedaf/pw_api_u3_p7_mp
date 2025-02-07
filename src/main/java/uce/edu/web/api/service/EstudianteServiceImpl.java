package uce.edu.web.api.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IEstudianteRepository;
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.service.to.EstudianteTo;
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

        @Override
    public List<EstudianteTo> buscarTodos() {
        return this.repo.buscarTodos()
                .stream()
                .map(mapTo)
                .collect(Collectors.toList());
    }
    @Override
    public List<EstudianteTo> buscarPorNombre(String nombre) {
        return this.repo.buscarPorNombre(nombre)
                .stream()
                .map(mapTo)
                .collect(Collectors.toList());
    }
    @Override
    public List<EstudianteTo> buscarNombreApellido(String nombre,String apellido) {
        return this.repo.buscarNombreApellido(nombre,apellido)
                .stream()
                .map(mapTo)
                .collect(Collectors.toList());
    }

}

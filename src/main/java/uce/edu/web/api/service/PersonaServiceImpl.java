package uce.edu.web.api.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IPersonaRepository;
import uce.edu.web.api.repository.modelo.Persona;
import uce.edu.web.api.service.to.PersonaTo;

@ApplicationScoped
public class PersonaServiceImpl implements IPersonaService {

    private Function<Persona,PersonaTo> mapTo = p ->{

        if(p!=null){
        return new PersonaTo(p.getId(),p.getNombre(),p.getApellido(),p.getFechaNacimiento());}
        System.out.println(
          "persona null"  
        );
        return new PersonaTo();
    };

    private Function<PersonaTo,Persona> mapPersona = pTo ->{
        return new Persona(pTo.getId(),pTo.getNombre(),pTo.getApellido(),pTo.getFechaNacimiento());
    };



    @Inject
    private IPersonaRepository repository;

    @Override
    public PersonaTo buscarPorId(Integer id) {
        return this.mapTo.apply(this.repository.buscarPorId(id));
    }

    @Override
    public void guardar(PersonaTo personaTo) {
        this.repository.instertar(this.mapPersona.apply(personaTo));
    }

    @Override
    public void actualizar(PersonaTo personaTo) {
        this.repository.actualizar(this.mapPersona.apply(personaTo));
    }

    @Override
    public void borrar(Integer id) {
        this.repository.eliminar(id);
    }
    @Override
    public List<PersonaTo> buscarTodos() {
        return this.repository.buscarTodos()
                .stream()
                .map(mapTo)
                .collect(Collectors.toList());
    }
    @Override
    public List<PersonaTo> buscarPorNombre(String nombre) {
        return this.repository.buscarPorNombre(nombre)
                .stream()
                .map(mapTo)
                .collect(Collectors.toList());
    }
    @Override
    public List<PersonaTo> buscarNombreApellido(String nombre,String apellido) {
        return this.repository.buscarNombreApellido(nombre,apellido)
                .stream()
                .map(mapTo)
                .collect(Collectors.toList());
    }
    
}

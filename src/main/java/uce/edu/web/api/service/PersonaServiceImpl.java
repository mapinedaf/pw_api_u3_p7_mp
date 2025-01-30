package uce.edu.web.api.service;

import java.util.function.Function;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IPersonaRepository;
import uce.edu.web.api.repository.modelo.Persona;
import uce.edu.web.api.service.to.PersonaTo;

@ApplicationScoped
public class PersonaServiceImpl implements IPersonaService {

    private Function<Persona,PersonaTo> mapTo = p ->{
        return new PersonaTo(p.getId(),p.getNombre(),p.getApellido(),p.getFechaNacimiento());
    };

    private Function<PersonaTo,Persona> mapPersona = pTo ->{
        return new Persona(pTo.getId(),pTo.getNombre(),pto.getApellido,pTo.getFechaNacimiento());
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
    
}

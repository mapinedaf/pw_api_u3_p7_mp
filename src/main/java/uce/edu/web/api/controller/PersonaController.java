package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import uce.edu.web.api.service.IPersonaService;
import uce.edu.web.api.service.to.PersonaTo;

@Path("/personas")
public class PersonaController{

    @Inject
    IPersonaService service;

    @Path("/buscar")
    @GET
    public Response buscarPorId(){
        Integer id = 1;
        return  Response.ok(this.service.buscarPorId(id)).build();
    }
    public void gurdar(PersonaTo persona){
        this.service.guardar(persona);
    }
    public void actualizar(PersonaTo persona){
        this.service.actualizar(persona);

    }
    public void borrar(Integer id){
        this.service.borrar(id);
    }
}

package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import uce.edu.web.api.service.IPersonaService;
import uce.edu.web.api.service.to.PersonaTo;

@Path("/personas")
public class PersonaController {

    @Inject
    private IPersonaService personaService;

    @GET
    @Path("/buscar")
    public Response buscarPorId() {
        Integer id =1;
        return Response.ok(this.personaService.buscarPorId(id)).build();
    }

    @Path("/guardar")
    public void guardar(PersonaTo persona) {
        this.personaService.guardar(persona);;
    }

    @Path("/actualizar")
    public void actualizar(PersonaTo persona) {
       this.personaService.actualizar(persona);;
    }

    @Path("/borrar")
    public void borrar(Integer id) {
        this.personaService.borrar(id);;
    }


}
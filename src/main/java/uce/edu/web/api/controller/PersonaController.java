package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import uce.edu.web.api.service.IPersonaService;
import uce.edu.web.api.service.to.PersonaTo;

@Path("/personas")
public class PersonaController {

    @Inject
    private IPersonaService personaService;

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Integer id) {
        return Response.ok(this.personaService.buscarPorId(id)).build();
    }

    @POST
    @Path("")
    public void guardar(PersonaTo persona) {
        this.personaService.guardar(persona);;
    }

    @PUT
    @Path("/{id}")
    public void actualizar(PersonaTo persona,@PathParam("id") Integer id ) {
       this.personaService.actualizar(persona);;
    }

    @PATCH
    @Path("/{id}/nuevo/{cedula}")
    public void actualizarParcial(PersonaTo persona,@PathParam("id") Integer id,@PathParam("cedula") String cedula) {
    PersonaTo tmp = this.personaService.buscarPorId(persona.getId());
    System.out.println(cedula);
    tmp.setNombre(persona.getNombre());
       this.personaService.actualizar(tmp);
    }

    @DELETE
    @Path("/{id}")
    public void borrar(@PathParam("id")Integer id) {

        this.personaService.borrar(id);;
    }


}
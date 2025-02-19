package uce.edu.web.api.controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce.edu.web.api.service.IPersonaService;
import uce.edu.web.api.service.to.PersonaTo;

@Path("/personas")
public class PersonaController {

    @Inject
    private IPersonaService personaService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorId(@PathParam("id") Integer id) {

        return Response.status(Response.Status.OK).entity(personaService.buscarPorId(id)).header("valor1",500).header("Mensaje", "Persona creada pero en proceso de validación").build();
      //return Response.ok(this.personaService.buscarPorId(id)).build();
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    public void guardar(PersonaTo persona) {
        this.personaService.guardar(persona);;
    }

    @PUT
    @Path("/{id}")
    public void actualizar(PersonaTo persona,@PathParam("id") Integer id ) {
       this.personaService.actualizar(persona);
    }

    @PATCH
    @Path("/parcial/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonaTo actualizarParcial(PersonaTo persona,@PathParam("id") Integer id) {
    PersonaTo tmp = this.personaService.buscarPorId(id);
    tmp.setNombre(persona.getNombre());
    this.personaService.actualizar(tmp);
    return tmp;
    }

    @DELETE
    @Path("/{id}")
    public void borrar(@PathParam("id")Integer id) {

        this.personaService.borrar(id);;
    }
    @GET
    @Path("")
    public List<PersonaTo> buscarTodos() {
        return this.personaService.buscarTodos();
    }
    @GET
    @Path("/porNombre")
    public List<PersonaTo> buscarPorNombre(@QueryParam("nombre") String nombre) {
        return this.personaService.buscarPorNombre(nombre);
    }
    @GET
    @Path("/porNombreApellido")
    public List<PersonaTo> buscarNombreApellido(@QueryParam("nombre") String nombre,@QueryParam("apellido")String apellido){
        return this.personaService.buscarNombreApellido(nombre,apellido);
    }

}
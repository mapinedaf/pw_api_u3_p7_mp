package uce.edu.web.api.controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import uce.edu.web.api.service.IEstudianteService;
import uce.edu.web.api.service.to.EstudianteTo;
import uce.edu.web.api.service.to.EstudianteTo;

@Path("/estudiantes")
public class EstudianteController {

    @Inject
    private IEstudianteService estudianteService;

    @GET
    @Path("/buscar")
    public Response buscarPorId() {
        Integer id =2;
        return Response.ok(this.estudianteService.buscarPorId(id)).build();
    }

    @POST
    @Path("/guardar")
    public void guardar(EstudianteTo estudiante) {
        this.estudianteService.guardar(estudiante);;
    }

    @PUT
    @Path("/actualizar")
    public void actualizar(EstudianteTo estudiante) {
       this.estudianteService.actualizar(estudiante);;
    }

    @PATCH
    @Path("/actualizar/parcial")
    public void actualizarParcial(EstudianteTo estudiante) {
    EstudianteTo tmp = this.estudianteService.buscarPorId(estudiante.getId());
    tmp.setNombre(estudiante.getNombre());
       this.estudianteService.actualizar(tmp);
    }

    @DELETE
    @Path("/borrar")
    public void borrar() {
        Integer id =1;
        this.estudianteService.borrar(id);;
    }



    @GET
    @Path("")
    public List<EstudianteTo> buscarTodos() {
        return this.estudianteService.buscarTodos();
    }
    @GET
    @Path("/porNombre")
    public List<EstudianteTo> buscarPorNombre(@QueryParam("nombre") String nombre) {
        return this.estudianteService.buscarPorNombre(nombre);
    }
    @GET
    @Path("/porNombreApellido")
    public List<EstudianteTo> buscarNombreApellido(@QueryParam("nombre") String nombre,@QueryParam("apellido")String apellido){
        return this.estudianteService.buscarNombreApellido(nombre,apellido);
    }

}
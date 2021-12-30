/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inser.restful.restful_crud;

import inser.persistence.restful_crud.LinkedList_envuelta;
import static inser.persistence.restful_crud.PersistenceConfig.jdbc_contraseña;
import static inser.persistence.restful_crud.PersistenceConfig.jdbc_usuario;
import inser.persistence.restful_crud.Producto;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author informatica
 */
@javax.ejb.Stateless
@Path("inser.restful.restful_crud.producto")
public class ProductoFacadeREST extends AbstractFacade<Producto> {
    @Context
    // opción 1: private UriInfo context;
    // opción 2: 
    private HttpServletRequest context;
    
//    @PersistenceContext(unitName = "restful_crudPU")
    public EntityManager entityManager;
    public Map<String, String> propiedades_mapa = new HashMap();

    public ProductoFacadeREST() {
        super(Producto.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Producto entity) {
        String texto;     
        texto = context.getHeader(jdbc_usuario);
        propiedades_mapa.put(jdbc_usuario, texto);
        texto = context.getHeader(jdbc_contraseña);        
        propiedades_mapa.put(jdbc_contraseña, texto);
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Producto entity) {
        String texto;     
        texto = context.getHeader(jdbc_usuario);
        propiedades_mapa.put(jdbc_usuario, texto);
        texto = context.getHeader(jdbc_contraseña);        
        propiedades_mapa.put(jdbc_contraseña, texto);
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        String texto;     
        texto = context.getHeader(jdbc_usuario);
        propiedades_mapa.put(jdbc_usuario, texto);
        texto = context.getHeader(jdbc_contraseña);        
        propiedades_mapa.put(jdbc_contraseña, texto);
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Producto find(@PathParam("id") String id) {
        String texto;
        texto = context.getHeader(jdbc_usuario);
        propiedades_mapa.put(jdbc_usuario, texto);
        texto = context.getHeader(jdbc_contraseña);        
        propiedades_mapa.put(jdbc_contraseña, texto);
        Producto producto = super.find(id);
        return producto;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public LinkedList_envuelta<Producto> findAll_envuelta() {
        LinkedList_envuelta<Producto> linkedList_envuelta = new LinkedList_envuelta();
        String texto;     
        texto = context.getHeader(jdbc_usuario);
        propiedades_mapa.put(jdbc_usuario, texto);
        texto = context.getHeader(jdbc_contraseña);        
        propiedades_mapa.put(jdbc_contraseña, texto);
        List<Producto> productos_lista = new LinkedList<Producto>(super.findAll());
        linkedList_envuelta.lista = new LinkedList(productos_lista);
        return linkedList_envuelta;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public LinkedList_envuelta<Producto> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        LinkedList_envuelta<Producto> linkedList_envuelta = new LinkedList_envuelta();
        String texto;     
        texto = context.getHeader(jdbc_usuario);
        propiedades_mapa.put(jdbc_usuario, texto);
        texto = context.getHeader(jdbc_contraseña);        
        propiedades_mapa.put(jdbc_contraseña, texto);
        List<Producto> productos_lista = super.findRange(new int[]{from, to});
        linkedList_envuelta.lista = new LinkedList(productos_lista);
        return linkedList_envuelta;
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        String texto;     
        texto = context.getHeader(jdbc_usuario);
        propiedades_mapa.put(jdbc_usuario, texto);
        texto = context.getHeader(jdbc_contraseña);        
        propiedades_mapa.put(jdbc_contraseña, texto);
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        String usuario;
        String contraseña;
        String [] error = { "" };
        usuario = propiedades_mapa.get(jdbc_usuario);
        contraseña = propiedades_mapa.get(jdbc_contraseña);
        entityManager = ApplicationConfig.getEntityManager("restful_crudPU"
                , usuario, contraseña, propiedades_mapa, error);
        return entityManager;
    }
    
}

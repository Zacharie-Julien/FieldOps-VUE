/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package WAREndpoint;

import WARSecurity.Secured;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import sFEJB.FieldEJB;
import sFEJB.GroundTypeEJB;
import sFJPA.Champ;
import sFJPA.TypeSol;


/**
 * REST Web Service
 *
 * @author d4cd13ger
 */
@Path("/field")
@Stateless
public class FieldWAR {
    
    @Inject
    private FieldEJB ejb;
    
    @Inject
    private GroundTypeEJB groundTypeEjb;
    
    @PersistenceContext(unitName="simplyField-pu")
    private EntityManager em;
    
    @Secured
    @GET
    @Path("/allFields")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Champ> getAllFields(){
        return ejb.getAllField();
    }
    
    @Secured
    @GET
    @Path("/singleField/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Champ getFieldsById(@PathParam("id") Integer id){
        return ejb.getFieldById(id);
    }
    
    @Secured
    @GET
    @Path("/fieldByOwner/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Champ> getAllFieldsByOwnerId(@PathParam("id") Integer id){
        return ejb.getAllFieldsByOwnerId(id);
    }
    
    @Secured
    @DELETE
    @Path("/deleteField/{id}")
    public void deleteFieldById(@PathParam("id") Integer id){
        ejb.deleteFieldById(id);
    }
    
    
    @Secured
    @GET
    @Path("/getAllGroundType")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TypeSol> getAllGroundType(){
        return groundTypeEjb.getAllGroundType();
    }
    
    @Secured
    @PUT
    @Path("/updateField/id/{id}/label/{label}/surface/{surface}/typeSol/{typeSol}")
    public void updateFieldById(@PathParam("id") Integer id, 
                                @PathParam("label") String label, 
                                @PathParam("surface") Integer surface,
                                @PathParam("typeSol") Integer idTypeSol){
        TypeSol typeSol = em.find(TypeSol.class, idTypeSol);
        ejb.updateFieldById(id, label, surface, typeSol);
    }
       
    
    @Secured
    @POST
    @Path("/addField/{label}/{surface}/{idOwner}/{idType}/{idDomaine}")
    @Produces(MediaType.APPLICATION_JSON)
    public void addField(
            @PathParam("label") String label, 
            @PathParam("surface") Integer surface, 
            @PathParam("idOwner") Integer idOwner, 
            @PathParam("idType") Integer idType,
            @PathParam("idDomaine") Integer idDomaine
            ){
        ejb.addField(label, surface, idOwner, idType, idDomaine);
    }
}

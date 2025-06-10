/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package WAREndpoint;

import WARSecurity.Secured;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.Date;
import java.util.List;
import sFEJB.UsersEJB;
import sFJPA.Utilisateur;
import sFJPA.Ouvrier;
import sFJPA.Proprietaire;


/**
 * REST Web Service
 *
 * @author d4cd13ger
 */

@Path("/users")
@Stateless
public class UsersWAR {
    
    @Inject
    private UsersEJB ejb;
    
    
    @GET
    @Path("/allUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Utilisateur> getAllUsers(){
        return ejb.getAllUsers();
    }
        
    @Secured
    @GET
    @Path("/singleUser/{id}")    
    @Produces(MediaType.APPLICATION_JSON)
    public Utilisateur getUserById(@PathParam("id") Integer id){
        return ejb.getUserById(id);
    }
    
    @Secured
    @GET
    @Path("/allWorkers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ouvrier> getAllWorkers(){
        return ejb.getAllWorkers();
    }
    
    @Secured
    @GET
    @Path("/singleWorker/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ouvrier getWorkersById(@PathParam("id") Integer id){
        return ejb.getWorkersById(id);
    }
    
    @DELETE
    @Path("/deleteWorker/{id}")
    public void deleteWorkerById(@PathParam("id") Integer id){
        ejb.deleteWorkerById(id);
    }
    
    @Secured
    @GET
    @Path("/allOwners")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proprietaire> getAllOwners(){
        return ejb.getAllOwners();
    }
    
    @Secured
    @GET
    @Path("/singleOwner/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Proprietaire getOwnerById(@PathParam("id") Integer id){
        return ejb.getOwnerById(id);
    }
    
    @POST
    @Path("/addWorker/{id}/{id_domain}")
    public void addWorkerById(@PathParam("id") Integer id, @PathParam("id_domain") Integer id_domain){
        ejb.addWorkersById(id, id_domain);
    }    
}

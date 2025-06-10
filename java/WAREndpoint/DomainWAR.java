/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package WAREndpoint;

import WARSecurity.Secured;
import jakarta.inject.*;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import sFEJB.DomainEJB;
import sFJPA.Domaine;

/**
 * REST Web Service
 *
 * @author d4cd13ger
 */
@Path("/domain")
public class DomainWAR {

    @Inject
    private DomainEJB ejb;
    
    @Secured
    @GET
    @Path("/singleDomain/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Domaine getSingleDomainById(@PathParam("id") Integer id){
        return ejb.getSingleDomainById(id);
    }
    
    @DELETE
    @Path("/deleteWorker/{idWorker}/{idDomain}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delteWorkerFromDomain(
            @PathParam("idWorker") Integer idOuvrier, 
            @PathParam("idDomain") Integer idDomaine){
        ejb.deleteWorkerFromDomain(idOuvrier, idDomaine);
    }
}

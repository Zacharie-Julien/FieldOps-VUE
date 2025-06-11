/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WAREndpoint;

import WARSecurity.Secured;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import sFEJB.OperationEJB;
import sFJPA.Subit;
import java.sql.Timestamp;
import sFJPA.SubitPK;


/**
 *
 * @author d4cd13ger
 */

@Path("/operation")
@Stateless
public class OperationWAR {
    
    @Inject
    private OperationEJB ejb;
       
    @GET
    @Path("/allOperationById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Subit> getAllOperation(@PathParam("id") Integer id){
        return ejb.getAllOperation(id);
    }    
    
    @GET
    @Path("/allOperationByWorkerId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Subit> getAllOperationByWorkerd(@PathParam("id") Integer id){
        return ejb.getAllOperationByWorkerId(id);
    }   
    
    @POST
    @Path("/addOperation/{id_traitement}/{id_champ}/{id_ouvrier}/{statut}/{dateNow}")
    @Produces(MediaType.APPLICATION_JSON)
    public void addOperation(
            @PathParam("id_traitement") Integer id_traitement,
            @PathParam("id_champ") Integer id_champ,        
            @PathParam("id_ouvrier") Integer id_ouvrier,
            @PathParam("dateNow") Timestamp dateNow){
        ejb.addOperation(id_traitement, id_champ, id_ouvrier, true, dateNow);
    }   
    
    
    @DELETE
    @Path("/deleteSubit/{id_traitement}/{id_champ}/{id_ouvrier}/{dateNow}")
    public Response deleteSubit(
        @PathParam("id_traitement") Integer id_traitement,
        @PathParam("id_champ") Integer id_champ,
        @PathParam("id_ouvrier") Integer id_ouvrier,
        @PathParam("dateNow") String dateNow
    ) throws UnsupportedEncodingException {        
          
        Timestamp originalTimestamp = Timestamp.valueOf(dateNow);
        long milliseconds = (originalTimestamp.getTime() / 1000) * 1000;
        Timestamp preciseTimestamp = new Timestamp(milliseconds);

        SubitPK pk = new SubitPK();
        pk.setId_traitement(id_traitement);
        pk.setId_champ(id_champ);
        pk.setId_ouvrier(id_ouvrier);
        pk.setDateNow(preciseTimestamp);
            
        ejb.deleteSubitById(pk);
        return Response.ok().build();
    }
    
    @POST
    @Path("/valideOperation/{id_traitement}/{id_champ}/{id_ouvrier}/{dateNow}")
    @Produces(MediaType.APPLICATION_JSON)
    public void valideOperation(
            @PathParam("id_traitement") Integer id_traitement,
            @PathParam("id_champ") Integer id_champ,        
            @PathParam("id_ouvrier") Integer id_ouvrier,
            @PathParam("dateNow") String dateNow) 
        throws UnsupportedEncodingException{
        
        Timestamp originalTimestamp = Timestamp.valueOf(dateNow);
        long milliseconds = (originalTimestamp.getTime() / 1000) * 1000;
        Timestamp preciseTimestamp = new Timestamp(milliseconds);

        SubitPK pk = new SubitPK();
        pk.setId_traitement(id_traitement);
        pk.setId_champ(id_champ);
        pk.setId_ouvrier(id_ouvrier);
        pk.setDateNow(preciseTimestamp);
            
        ejb.valideOperation(pk);
    }   
}

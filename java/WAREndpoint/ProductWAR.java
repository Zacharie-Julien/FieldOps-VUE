/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package WAREndpoint;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;
import sFEJB.ProductEJB;
import sFJPA.Produit;


/**
 * REST Web Service
 *
 * @author d4cd13ger
 */

@Path("/product")
@Stateless
public class ProductWAR {
    
    @Inject
    private ProductEJB ejb;
    
    
    
    @GET
    @Path("/allProducts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produit> getAllProducts(){
        return ejb.getAllProduct();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sFEJB;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import sFJPA.Produit;



/**
 *
 * @author d4cd13ger
 */

@Stateless
public class ProductEJB {
    
    @PersistenceContext(unitName="simplyField-pu")
    private EntityManager em;
    
    public List<Produit> getAllProduct(){
        return em.createNamedQuery("Product.getAllProduct", Produit.class).getResultList();
    }
    
}

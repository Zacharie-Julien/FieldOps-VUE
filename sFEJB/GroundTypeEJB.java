package sFEJB;


import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import sFJPA.TypeSol;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author d4cd13ger
 */

@Stateless
public class GroundTypeEJB {

    @PersistenceContext(unitName="simplyField-pu")
    private EntityManager em;
    
   public List<TypeSol> getAllGroundType(){
       return em.createNamedQuery("GroundType.getAllGroundType", TypeSol.class).getResultList();
   }    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sFEJB;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.List;
import sFJPA.Domaine;
import sFJPA.Ouvrier;



/**
 *
 * @author d4cd13ger
 */

@Stateless
public class DomainEJB {
      
    @PersistenceContext(unitName="simplyField-pu")
    private EntityManager em;
    
    public Domaine getSingleDomainById(Integer id){
        return em.createNamedQuery("Domain.getSingleDomainById", Domaine.class).setParameter("id", id).getSingleResult();
    }    
    
   public void deleteWorkerFromDomain(Integer idWorker, Integer idDomain) {
        Domaine currentDomain = em.find(Domaine.class, idDomain);
        if (currentDomain == null) {
            throw new IllegalArgumentException("Domaine introuvable avec l'ID : " + idDomain);
        }

        List<Ouvrier> ouvriers = currentDomain.getListeOuvriers();
        boolean removed = ouvriers.removeIf(worker -> idWorker.equals(worker.getId()));

        if (removed) {
            em.merge(currentDomain); // enregistre la modification
        }
    }
}

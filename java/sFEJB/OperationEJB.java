/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sFEJB;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import sFJPA.Champ;
import sFJPA.Ouvrier;
import sFJPA.Subit;
import sFJPA.Traitement;
import java.sql.Timestamp;
import sFJPA.SubitPK;

/**
 *
 * @author d4cd13ger
 */

@Stateless
public class OperationEJB {
    
    @PersistenceContext(unitName="simplyField-pu")
    private EntityManager em;
 
    public List<Subit> getAllOperation(Integer id){
        return em.createNamedQuery("Operation.getAllOperationById", Subit.class).setParameter("id", id).getResultList();
    }
    
    public List<Subit> getAllOperationByWorkerId(Integer id){
        return em.createNamedQuery("Operation.getAllOperationByWorkerId", Subit.class).setParameter("id", id).getResultList();
    }
    
    public void addOperation(Integer id_traitement, Integer id_champ, Integer id_ouvrier, Boolean statut, Timestamp dateNow){
        Subit addOperation = new Subit();
        Traitement addTreatment = em.find(Traitement.class, id_traitement);
        Champ addField = em.find(Champ.class, id_champ);
        Ouvrier addWorker = em.find(Ouvrier.class, id_ouvrier);
        
        
        addOperation.setTraitement(addTreatment);
        addOperation.setChamp(addField);
        addOperation.setOuvrier(addWorker);
        addOperation.setStatus(statut);
        addOperation.setDateNow(dateNow);
        
        em.persist(addOperation);
    }
    
    public void deleteSubitById(Integer id_traitement, Integer id_champ, Integer id_ouvrier, Boolean statut, Timestamp dateNow) {
        Subit addOperation = new Subit();
        Traitement addTreatment = em.find(Traitement.class, id_traitement);
        Champ addField = em.find(Champ.class, id_champ);
        Ouvrier addWorker = em.find(Ouvrier.class, id_ouvrier);        
        
        addOperation.setTraitement(addTreatment);
        addOperation.setChamp(addField);
        addOperation.setOuvrier(addWorker);
        addOperation.setStatus(statut);
        addOperation.setDateNow(dateNow);
        
        em.remove(addOperation);
    }
    
    
    public void valideOperation(SubitPK pk){
        Subit currentOperation = em.find(Subit.class, pk);
        currentOperation.setStatus(Boolean.FALSE);
        em.merge(currentOperation);
    }    
}

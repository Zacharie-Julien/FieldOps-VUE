
package sFEJB;

import java.util.List;
import jakarta.ejb.*;
import jakarta.persistence.*;
import sFJPA.Champ;
import sFJPA.Domaine;
import sFJPA.Proprietaire;
import sFJPA.TypeSol;

/**
 *
 * @author d4cd13ger
 */

@Stateless
public class FieldEJB {
    
    @PersistenceContext(unitName="simplyField-pu")
    private EntityManager em;
    
    public List<Champ> getAllField(){
       return em.createNamedQuery("Field.getAllFields", Champ.class).getResultList();
    }
    
    public Champ getFieldById(Integer id){
        return em.createNamedQuery("Field.getFieldById", Champ.class).setParameter("id", id).getSingleResult();
    }
    
    public List<Champ> getAllFieldsByOwnerId(Integer id){
        return em.createNamedQuery("Field.getFieldByOnwerId", Champ.class).setParameter("id", id).getResultList();
    }
    
    public void deleteFieldById(Integer id){
        em.createNamedQuery("Field.deleteFieldById").setParameter("id", id).executeUpdate();
    }
    
    public void updateFieldById(Integer id, String label, Integer surface, TypeSol typeSol){
        em.createNamedQuery("Field.updateFieldById")
                .setParameter("id", id)
                .setParameter("label", label)
                .setParameter("surface", surface)
                .setParameter("typeSol", typeSol)
                .executeUpdate();
    }
    
    public void addField(String label, Integer surface, Integer idOwner, Integer idType, Integer idDomain){
        Champ addChamp = new Champ();
        Proprietaire addOwner = em.find(Proprietaire.class, idOwner);
        TypeSol addType = em.find(TypeSol.class, idType);
        Domaine addDomain = em.find(Domaine.class, idDomain);
        
        
        addChamp.setSurface(surface);
        addChamp.setLabel(label);
        addChamp.setProprietaire(addOwner);
        addChamp.setTypeSol(addType);
        addChamp.setDomaine(addDomain);
        
        em.persist(addChamp);        
    }    
}

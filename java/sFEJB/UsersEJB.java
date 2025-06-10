package sFEJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import sFJPA.Domaine;
import sFJPA.Utilisateur;
import sFJPA.Ouvrier;
import sFJPA.Proprietaire;


/**
 *
 * @author d4cd13ger
 */


@Stateless
public class UsersEJB {

    @PersistenceContext(unitName="simplyField-pu")
    private EntityManager em;
    
    
    public List<Utilisateur> getAllUsers(){                 
        return em.createNamedQuery("User.getAllUsers", Utilisateur.class).getResultList();
    }
    
    public Utilisateur getUserById(Integer id){
        return em.createNamedQuery("User.getUserById", Utilisateur.class).setParameter("id", id).getSingleResult();
    }
        
    public List<Ouvrier> getAllWorkers(){
        return em.createNamedQuery("Workers.getAllWorkers", Ouvrier.class).getResultList();
    }
    
    public Ouvrier getWorkersById(Integer id){
        return em.createNamedQuery("Workers.getWorkersById", Ouvrier.class).setParameter("id", id).getSingleResult();
    }
    
    public List<Proprietaire> getAllOwners(){
        return em.createNamedQuery("Owners.getAllOwner", Proprietaire.class).getResultList();
    }
    
    public Proprietaire getOwnerById(Integer id){
        return em.createNamedQuery("Owners.getOwnerById", Proprietaire.class).setParameter("id", id).getSingleResult();
    }
    
    public Utilisateur getUserByLogin(String login){
        return em.createNamedQuery("User.getUserByLogin", Utilisateur.class).setParameter("login", login).getSingleResult();
    }
    
    public void deleteWorkerById(Integer id){
        em.createNamedQuery("Workers.deleteWorkerById").setParameter("id", id).executeUpdate();
    }
    
    public void deleteOwnerById(Integer id){
        em.createNamedQuery("Owners.deleteOwnerById").setParameter("id", id).executeUpdate();
    }
    
    public void addWorkersById(Integer id, Integer domainId){
        Ouvrier addWorker = em.find(Ouvrier.class, id);
        Domaine domaine = em.find(Domaine.class, domainId);
        
        domaine.addWorker(addWorker);
        em.persist(domaine);        
    }    
    
}

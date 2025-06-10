
package sFEJB;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sFJPA.Proprietaire;
import sFJPA.Utilisateur;

/**
 *
 * @author d4cd13ger
 */

@Stateless
public class AuthEJB {
    
    @Inject 
    private UsersEJB ejb;
       
    @PersistenceContext(unitName="simplyField-pu")
    private EntityManager em;
    
    // Le type Boolean est éphémère ce n'est que pour les testes
    public Boolean verifyAuth(String login, String passwd){
        Boolean response = false;
        
        // Il faut aussi ajouté la fonction de Hachage
        if(ejb.getUserByLogin(login).getMdp().equals(passwd)){                    
            response = true;
        }
        
        return response;
    }
    
    public String verifAdmin(Utilisateur user){
        String response = "utilisateur";
        
        Proprietaire searchedAdministrator = em.find(Proprietaire.class, user.getId());
        
        if(searchedAdministrator != null){
            response = "admin";
        }           
        
        return response;
    }
    
}

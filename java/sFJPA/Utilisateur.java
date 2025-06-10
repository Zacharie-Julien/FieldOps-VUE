
package sFJPA;
import jakarta.persistence.*;
import java.io.Serializable;

/**
 *
 * @author d4cd13ger
 */



@Entity
@NamedQueries(
    {
        @NamedQuery(name = "User.getAllUsers", query = "SELECT u FROM Utilisateur u"),
        @NamedQuery(name = "User.getUserById", query = "SELECT u FROM Utilisateur u WHERE u.id = :id"),
        @NamedQuery(name = "User.getUserByLogin", query = "SELECT u FROM Utilisateur u WHERE u.login = :login")
    }
)
@Table(name = "Utilisateur")
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "nom")
    private String nom;
    
    @Column(name = "prenom")
    private String prenom;
    
    @Column(name = "telephone")
    private String telephone;
    
    @Column(name = "code_postal")
    private String code_postal;
    
    @Column(name = "numero")
    private Integer numero;
    
    @Column(name = "rue")
    private String rue;
    
    @Column(name = "mdp")
    private String mdp;
    
    @Column(name = "login")
    private String login;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}

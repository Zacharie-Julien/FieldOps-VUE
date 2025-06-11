/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sFJPA;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author d4cd13ger
 */


@Entity
@NamedQueries(
    {
        @NamedQuery(name = "Domain.getAllDomain", query = "SELECT d FROM Domaine d"),
        @NamedQuery(name = "Domain.getSingleDomainById", query = "SELECT d FROM Domaine d WHERE d.id = :id")
    } 
)
@Table(name="Domaine")
public class Domaine implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "label")
    private String label;
    
    @Column(name = "code_postal")
    private String code_postal;
    
    @Column(name = "numero")
    private Integer numero;
    
    @Column(name = "rue")
    private String rue;
    
    @ManyToOne
    @JoinColumn(name="id_proprietaire")
    private Proprietaire proprietaire;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "Employer",
        joinColumns = @JoinColumn(name = "id_domaine"),
        inverseJoinColumns = @JoinColumn(name = "id_ouvrier")
    )
    private List<Ouvrier> listeOuvriers;    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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

    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    public List<Ouvrier> getListeOuvriers() {
        return listeOuvriers;
    }

    public void setListeOuvriers(List<Ouvrier> listeOuvriers) {
        this.listeOuvriers = listeOuvriers;
    }
    
    public void addWorker(Ouvrier ouvrier){
        this.listeOuvriers.add(ouvrier);
    }
}

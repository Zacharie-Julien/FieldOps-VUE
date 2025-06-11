/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sFJPA;
import jakarta.persistence.*;
import java.util.List;

/**
 *
 * @author d4cd13ger
 */


@Entity
@NamedQueries({
    @NamedQuery(name = "Field.getAllFields", query = "SELECT c FROM Champ c"),
    @NamedQuery(name = "Field.getFieldById", query = "SELECT c FROM Champ c WHERE c.id = :id"),
    @NamedQuery(name = "Field.getFieldByOnwerId", 
            query = "SELECT c FROM Champ c, Proprietaire p WHERE c.proprietaire.id = p.id AND p.id = :id"),
    @NamedQuery(name= "Field.deleteFieldById", query = "DELETE FROM Champ c WHERE c.id = :id"),
    @NamedQuery(name= "Field.updateFieldById", 
            query = "UPDATE Champ c SET c.label = :label, c.surface = :surface, c.typeSol = :typeSol WHERE c.id = :id")
})
@Table(name = "Champ")
public class Champ {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name="label")
    private String label;
    
    @Column(name="surface")
    private Integer surface;
    
    @ManyToOne
    @JoinColumn(name = "id_domaine")
    private Domaine domaine;
    
    @ManyToOne
    @JoinColumn(name = "id_proprietaire")
    private Proprietaire proprietaire;
    
    @ManyToOne
    @JoinColumn(name = "id_type_de_sol")
    private TypeSol typeSol;   
    
    
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

    public Integer getSurface() {
        return surface;
    }

    public void setSurface(Integer surface) {
        this.surface = surface;
    }

    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Proprietaire proprietaire) {
        this.proprietaire = proprietaire;
    }

    public TypeSol getTypeSol() {
        return typeSol;
    }

    public void setTypeSol(TypeSol typeSol) {
        this.typeSol = typeSol;
    }         

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }
    
}

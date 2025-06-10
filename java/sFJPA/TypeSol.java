/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sFJPA;
import jakarta.persistence.*;

/**
 *
 * @author d4cd13ger
 */

@Entity
@NamedQueries(
    {
        @NamedQuery(name = "GroundType.getAllGroundType", query = "SELECT t FROM TypeSol t"),
    }
)
@Table(name = "Type_de_sol")
public class TypeSol {
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Column(name="label")
    private String label;
    
    @Column(name = "matiere_organique")
    private Integer matiereOrganique;
    
    @Column(name = "pH")
    private Integer pH;
    
    @Column(name = "retention_eau")
    private Integer retentionEau;
    
    @Column(name = "structure_sol")
    private String structureSol;
    
    @Column(name = "temp_sol")
    private Integer tempSol;

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

    public Integer getMatiereOrganique() {
        return matiereOrganique;
    }

    public void setMatiereOrganique(Integer matiereOrganique) {
        this.matiereOrganique = matiereOrganique;
    }

    public Integer getpH() {
        return pH;
    }

    public void setpH(Integer pH) {
        this.pH = pH;
    }

    public Integer getRetentionEau() {
        return retentionEau;
    }

    public void setRetentionEau(Integer retentionEau) {
        this.retentionEau = retentionEau;
    }

    public String getStructureSol() {
        return structureSol;
    }

    public void setStructureSol(String structureSol) {
        this.structureSol = structureSol;
    }

    public Integer getTempSol() {
        return tempSol;
    }

    public void setTempSol(Integer tempSol) {
        this.tempSol = tempSol;
    }
    
}

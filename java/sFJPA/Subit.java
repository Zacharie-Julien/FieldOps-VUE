/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sFJPA;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.sql.Timestamp;

/**
 *
 * @author d4cd13ger
 */

@Entity
@NamedQueries(
    {
        @NamedQuery(name = "Operation.getAllOperationById", query = "SELECT s FROM Subit s WHERE s.champ.id = :id"),   
        @NamedQuery(name = "Operation.getAllOperationByWorkerId", query = "SELECT s FROM Subit s WHERE s.ouvrier.id = :id")
    }
)
@Table(name = "Subit")
public class Subit {
    
    
    @EmbeddedId
    private SubitPK subitPk;

    @MapsId("id_traitement")
    @ManyToOne
    @JoinColumn(name = "id_traitement")
    private Traitement traitement;

    @MapsId("id_champ")
    @ManyToOne
    @JoinColumn(name = "id_champ")
    private Champ champ;

    @MapsId("id_ouvrier")
    @ManyToOne
    @JoinColumn(name = "id_ouvrier")
    private Ouvrier ouvrier;
    
    @Column(name = "statut")
    private Boolean status;

    public SubitPK getSubitPk() {
        return subitPk;
    }

    public void setSubitPk(SubitPK subitPk) {
        this.subitPk = subitPk;
    }

    public Traitement getTraitement() {
        return traitement;
    }

    public void setTraitement(Traitement traitement) {
        this.traitement = traitement;
    }

    public Champ getChamp() {
        return champ;
    }

    public void setChamp(Champ champ) {
        this.champ = champ;
    }

    public Ouvrier getOuvrier() {
        return ouvrier;
    }

    public void setOuvrier(Ouvrier ouvrier) {
        this.ouvrier = ouvrier;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    public Timestamp getDateNow() {
    return subitPk != null ? subitPk.getDateNow() : null;
}

    public void setDateNow(Timestamp dateNow) {
        if (subitPk == null) {
            subitPk = new SubitPK(); // instancier si null
        }
        subitPk.setDateNow(dateNow);
    }
    
}

package sFJPA;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Embeddable
public class SubitPK implements Serializable {

    private Integer id_traitement;
    private Integer id_champ;
    private Integer id_ouvrier;
    private Timestamp dateNow;

    public Integer getId_traitement() {
        return id_traitement;
    }

    public void setId_traitement(Integer id_traitement) {
        this.id_traitement = id_traitement;
    }

    public Integer getId_champ() {
        return id_champ;
    }

    public void setId_champ(Integer id_champ) {
        this.id_champ = id_champ;
    }

    public Integer getId_ouvrier() {
        return id_ouvrier;
    }

    public void setId_ouvrier(Integer id_ouvrier) {
        this.id_ouvrier = id_ouvrier;
    }

    public Timestamp getDateNow() {
        return dateNow;
    }

    public void setDateNow(Timestamp dateNow) {
        this.dateNow = dateNow;
    }
}
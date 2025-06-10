

package sFJPA;
import jakarta.persistence.*;
import java.sql.Timestamp;

/**
 *
 * @author d4cd13ger
 */
 
@Entity
@NamedQueries(
    {
        @NamedQuery(name = "Product.getAllProduct", query = "SELECT p FROM Produit p")
    }
)
@Table(name = "Produit")
public class Produit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "residualite")
    private Timestamp residualite;
    
    @Column(name = "meteo")
    private String meteo;
    
    @Column(name = "dre")
    private Timestamp dre;
    
    @Column(name = "dra")
    private Timestamp dra;
    
    @Column(name = "stade_phenologique")
    private String stade_phenologique;
    
    @Column(name = "Label")
    private String Label;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getResidualite() {
        return residualite;
    }

    public void setResidualite(Timestamp residualite) {
        this.residualite = residualite;
    }

    public String getMeteo() {
        return meteo;
    }

    public void setMeteo(String meteo) {
        this.meteo = meteo;
    }

    public Timestamp getDre() {
        return dre;
    }

    public void setDre(Timestamp dre) {
        this.dre = dre;
    }

    public Timestamp getDra() {
        return dra;
    }

    public void setDra(Timestamp dra) {
        this.dra = dra;
    }

    public String getStade_phenologique() {
        return stade_phenologique;
    }

    public void setStade_phenologique(String stade_phenologique) {
        this.stade_phenologique = stade_phenologique;
    }   

    public String getLabel() {
        return Label;
    }

    public void setLabel(String Label) {
        this.Label = Label;
    }
    
}


package sFJPA;
import jakarta.persistence.*;

/**
 *
 * @author d4cd13ger
 */


@Entity
@Table(name = "Traitement")
public class Traitement {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "volume")
    private Integer volume;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
        name = "Soumis",
        joinColumns = @JoinColumn(name = "id_produit"),
        inverseJoinColumns = @JoinColumn(name = "id_traitement")
    )
    private Produit produit;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    
    
}

package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Misaina
 * @version 1.0
 * @created 26-mai-2017 18:53:12
 */
@Entity
public class Categorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @OneToMany(mappedBy = "categorie")
    private List<CategorieMagasin> categorieMagasin;
    private String libelle;
    
    @OneToMany(mappedBy = "categorie")
    private List<Produit> produits;

    public Categorie() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CategorieMagasin> getCategorieMagasin() {
        return categorieMagasin;
    }

    public void setCategorieMagasin(List<CategorieMagasin> categorieMagasin) {
        this.categorieMagasin = categorieMagasin;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}//end Categorie

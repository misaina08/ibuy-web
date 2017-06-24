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
public class PointDeVente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String adresse;
    private String contact;
    private String email;
    private long latitude;
    private long longitude;
    private Magasin magasin;

    @OneToMany(mappedBy = "pointDeVente")
    private List<ProduitPointDeVente> produitPointDeVente;

    public PointDeVente() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public List<ProduitPointDeVente> getProduitPointDeVente() {
        return produitPointDeVente;
    }

    public void setProduitPointDeVente(List<ProduitPointDeVente> produitPointDeVente) {
        this.produitPointDeVente = produitPointDeVente;
    }

}//end PointDeVente

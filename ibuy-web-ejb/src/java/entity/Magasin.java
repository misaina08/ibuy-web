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
public class Magasin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private Integer nbVues;
    
    
    @OneToMany(mappedBy = "magasin")
    private List<Abonnement> abonnements;
    
    @OneToMany(mappedBy = "magasin")
    private List<AdminMagasin> adminsMagasin;
    
    @OneToMany(mappedBy = "magasin")
    private List<CategorieMagasin> categorieMagasin;
    private String description;
    
    @OneToMany(mappedBy = "magasin")
    private List<EvenementMagasin> evenementsMagasin;
    private String logo;
    private String nom;
    @OneToMany(mappedBy = "magasin")
    private List<PointDeVente> pointsDeVente;

    @OneToMany(mappedBy = "magasin")
    private List<ViewMagasin> vues;
    
    @OneToMany(mappedBy = "magasin")
    private List<Produit> produits;
    
    public Magasin() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Abonnement> getAbonnements() {
        return abonnements;
    }

    public void setAbonnements(List<Abonnement> abonnements) {
        this.abonnements = abonnements;
    }

    public List<AdminMagasin> getAdminsMagasin() {
        return adminsMagasin;
    }

    public void setAdminsMagasin(List<AdminMagasin> adminsMagasin) {
        this.adminsMagasin = adminsMagasin;
    }

    public List<CategorieMagasin> getCategorieMagasin() {
        return categorieMagasin;
    }

    public void setCategorieMagasin(List<CategorieMagasin> categorieMagasin) {
        this.categorieMagasin = categorieMagasin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EvenementMagasin> getEvenementsMagasin() {
        return evenementsMagasin;
    }

    public void setEvenementsMagasin(List<EvenementMagasin> evenementsMagasin) {
        this.evenementsMagasin = evenementsMagasin;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<PointDeVente> getPointsDeVente() {
        return pointsDeVente;
    }

    public void setPointsDeVente(List<PointDeVente> pointsDeVente) {
        this.pointsDeVente = pointsDeVente;
    }

    public List<ViewMagasin> getVues() {
        return vues;
    }

    public void setVues(List<ViewMagasin> vues) {
        this.vues = vues;
    }

    public Integer getNbVues() {
        return nbVues;
    }

    public void setNbVues(Integer nbVues) {
        this.nbVues = nbVues;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
    

}//end Magasin

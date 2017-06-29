/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongo.modele.recherche;


import java.util.List;
import mongo.modele.Categorie;
import mongo.modele.Magasin;
import mongo.modele.MongoModele;

/**
 *
 * @author Misaina
 */
public class RechercheAvancee extends MongoModele {

    private Integer id;
    private String motCle;
    private Float prixMin;
    private Float prixMax;
    private String detail;
    private Magasin magasin;
    private Categorie categorie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    public Float getPrixMin() {
        return prixMin;
    }

    public void setPrixMin(Float prixMin) {
        this.prixMin = prixMin;
    }

    public Float getPrixMax() {
        return prixMax;
    }

    public void setPrixMax(Float prixMax) {
        this.prixMax = prixMax;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Magasin getMagasin() {
         return magasin;
    }

    public void setMagasin(Magasin magasins) {
        this.magasin = magasins;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categories) {
        this.categorie = categories;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongo.modele;

import entity.Categorie;
import entity.Magasin;
import java.util.List;

/**
 *
 * @author Misaina
 */

public class Produit extends MongoModele {

    private Integer id;
    private String designation;
    private Float qteStock;
    private String unite;
    private Double prix;
    /*
    private Magasin magasin;
    
    private List<Categorie> categories;
    
    private Integer nbVisit;          
    
*/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Float getQteStock() {
        return qteStock;
    }

    public void setQteStock(Float qteStock) {
        this.qteStock = qteStock;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

   /*


    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    public Integer getNbVisit() {
        return nbVisit;
    }

    public void setNbVisit(Integer nbVisit) {
        this.nbVisit = nbVisit;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }
*/    
}

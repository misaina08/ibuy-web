/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbean;

import ejb.MagasinBean;
import ejb.ProduitBean;
import entity.Magasin;
import entity.Produit;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Misaina
 * 
 * Backing bean pour représenter le fil d'actualité. 
 * - Liste des 10 produits récemment ajoutés
 * - Liste des 10 produits les plus vus
 * - Liste des produits des magasins favoris si le client est connecté
 * - Liste des 10 magasins plus populaires
 */
@Named(value = "filActusMB")
@ViewScoped
public class FilActusMB implements Serializable{

    @EJB
    private ProduitBean produitBean;

    @EJB
    private MagasinBean magasinBean;

    private List<Produit> produitsRecents;
    private List<Produit> produitsPopulaires;
    private List<Produit> produitsMagasinsFavoris;
    private List<Magasin> magasinsPopulaires;
    
    /**
     * Creates a new instance of FilActusMB
     */
    public FilActusMB() {
    }

    public List<Produit> getProduitsRecents() {
        if(produitsRecents == null){
            produitsRecents = produitBean.getDerniersAjout();
            System.out.println("_______"+produitsRecents.size());
        }
        return produitsRecents;
    }

    public void setProduitsRecents(List<Produit> produitsRecents) {
        this.produitsRecents = produitsRecents;
    }

    public List<Produit> getProduitsPopulaires() {
        if(produitsPopulaires == null){
            produitsPopulaires = produitBean.getDerniersAjout();
        }
        return produitsPopulaires;
    }

    public void setProduitsPopulaires(List<Produit> produitsPopulaires) {
        this.produitsPopulaires = produitsPopulaires;
    }

    public List<Produit> getProduitsMagasinsFavoris() {
        return produitsMagasinsFavoris;
    }

    public void setProduitsMagasinsFavoris(List<Produit> produitsMagasinsFavoris) {
        this.produitsMagasinsFavoris = produitsMagasinsFavoris;
    }

    public List<Magasin> getMagasinsPopulaires() {
        if(magasinsPopulaires == null){
            magasinsPopulaires = magasinBean.getPlusVus();
        }
        return magasinsPopulaires;
    }

    public void setMagasinsPopulaires(List<Magasin> magasinsPopulaires) {
        this.magasinsPopulaires = magasinsPopulaires;
    }
    
    
}

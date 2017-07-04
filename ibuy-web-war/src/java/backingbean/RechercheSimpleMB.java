/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbean;

import ejb.ProduitBean;
import entity.Produit;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import mongo.modele.recherche.RechercheAvancee;

/**
 *
 * @author Misaina
 */
@Named(value = "rechercheSimpleMB")
@RequestScoped
public class RechercheSimpleMB {

    @EJB
    private ProduitBean produitBean;

    
    private String search = "";
    private List<Produit> resultat;

    /**
     * Creates a new instance of RechercheSimpleMB
     */
    public RechercheSimpleMB() {
    }
    
    public String rechercher(){
        RechercheAvancee recherche = new RechercheAvancee();
        recherche.setMotCle(search);
        resultat = produitBean.rechercher(recherche);
        return "/front/recherche/resultatRechercheSimple";
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public List<Produit> getResultat() {
        return resultat;
    }

    public void setResultat(List<Produit> resultat) {
        this.resultat = resultat;
    }
    

}

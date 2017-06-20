/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbean;

import ejb.ProduitBean;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import mongo.modele.Produit;

/**
 *
 * @author Misaina
 */
@Named(value = "produitMB")
@RequestScoped
public class ProduitMB {

    @EJB
    private ProduitBean produitBean;

    /**
     * Creates a new instance of ProduitMB
     */
    public ProduitMB() {
    }
    
    private Produit produit = new Produit();

    public String insertProduit(){
        produit.setQteStock(new Float(30));
        produit.setUnite("kg");
        produitBean.save(produit);
        return "";
    }
    
    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    
    
}

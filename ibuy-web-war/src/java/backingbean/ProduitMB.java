/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbean;

import ejb.ProduitBean;
import entity.Produit;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

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
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbean;

import ejb.PointdeventeBean;
import ejb.ProduitBean;
import entity.Categorie;
import entity.Magasin;
import entity.PointDeVente;
import entity.Produit;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import util.MessageUtil;

/**
 *
 * @author Misaina
 */
@Named(value = "produitMB")
@RequestScoped
public class ProduitMB {

    @EJB
    private PointdeventeBean pointdeventeBean;

    @EJB
    private ProduitBean produitBean;

    
    
    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    
    

    private Produit produit = new Produit();
    /**
     * Creates a new instance of ProduitMB
     */
    private int idPointdevente;
    PointDeVente pointdevente = new PointDeVente();

    public PointDeVente getPointdevente() {
        return pointdevente;
    }

    public void setPointdevente(PointDeVente pointdevente) {
        this.pointdevente = pointdevente;
    }
    

    public int getIdPointdevente() {
        return idPointdevente;
    }

    public void setIdPointdevente(int idPointdevente) {
        this.idPointdevente = idPointdevente;
    }
    public void loadPointDeVente() {
        this.pointdevente = pointdeventeBean.findById(new Integer(idPointdevente));
    }
    
    
   
    
    public ProduitMB() {
    }
    
     public String ajoutProduit() {
        FacesContext context = FacesContext.getCurrentInstance();
        Magasin a = (Magasin) context.getExternalContext().getSessionMap().get("magasinSession");
        produit.setMagasin(a);
        Categorie cat = new Categorie();
        cat.setId(1);
        produit.setCategorie(cat);
        produit.setNbVues(0);
        produit.setDateAjout(new Date());
        
        produitBean.save(produit, idPointdevente);

        MessageUtil.addFlashInfoMessage("Ajout effectué");
        return "/back-magasin/liste-produit?idPointdevente="+idPointdevente+"faces-redirect=true";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbean;

import ejb.MagasinBean;
import ejb.ProduitBean;
import entity.CategorieMagasin;
import entity.Magasin;
import entity.Produit;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import util.MessageUtil;

/**
 *
 * @author kiashi
 */
@Named(value = "magasinMB")
@RequestScoped
public class MagasinMB {

    @EJB
    private ProduitBean produitBean;

    @EJB
    private MagasinBean magasinBean;
    
    
    
    

    /**
     * Creates a new instance of MagasinMB
     */
    
    public MagasinMB() {
    }
    
    private List<Magasin> listeMagasin;
    Magasin magasin = new Magasin();
    private int idMagasin;
    private List<CategorieMagasin> categoriemagasin;
    private List<Produit> listeproduit;

    public List<Produit> getListeproduit() {
        if (listeproduit == null){
            listeproduit = produitBean.getListProduitParMagasin(idMagasin);
        }
       
        return listeproduit;
    }

    public void setListeproduit(List<Produit> listeproduit) {
        this.listeproduit = listeproduit;
    }
    
    
    public List<CategorieMagasin> getCategoriemagasin() {
        return categoriemagasin;
    }

    public void setCategoriemagasin(List<CategorieMagasin> categoriemagasin) {
        this.categoriemagasin = categoriemagasin;
    }

    public void loadcategorieMagasin(){
        categoriemagasin=magasinBean.getCategorieMagasin(magasin);
    }
   

    public List<Magasin> getListeMagasin() {
        if(listeMagasin == null){
            listeMagasin = magasinBean.getListMagasin();
        }
        return listeMagasin;
    }

    public void setListeMagasin(List<Magasin> listeMagasin) {
        this.listeMagasin = listeMagasin;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    public int getIdMagasin() {
        return idMagasin;
    }

    public void setIdMagasin(int idMagasin) {
        this.idMagasin = idMagasin;
    }
    public void loadMagasin() {
        this.magasin = magasinBean.findMagasinById(new Integer(idMagasin));
    }
    
    public String ajouter() {
         magasinBean.addMagasin(magasin);
        
        MessageUtil.addFlashInfoMessage("Modification effectué");
        return "/super_admin/listemagasin?faces-redirect=true";
    }
     public String modifier() {
      
         
        magasin = magasinBean.updateMagasin(magasin);
        
        MessageUtil.addFlashInfoMessage("Modification effectué");
        return "/super_admin/listemagasin?faces-redirect=true";
    }
     
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbean;

import ejb.MagasinBean;
import entity.CategorieMagasin;
import entity.Magasin;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import util.Util;

/**
 *
 * @author kiashi
 */
@Named(value = "magasinMB")
@RequestScoped
public class MagasinMB {

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
        
        Util.addFlashInfoMessage("Modification effectué");
        return "/super_admin/listemagasin?faces-redirect=true";
    }
     public String modifier() {
      
         
        magasin = magasinBean.updateMagasin(magasin);
        
        Util.addFlashInfoMessage("Modification effectué");
        return "/super_admin/listemagasin?faces-redirect=true";
    }
     
}

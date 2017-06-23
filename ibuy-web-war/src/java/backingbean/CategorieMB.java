/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbean;

import ejb.SuperadminBean;
import entity.Categorie;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import util.Util;

/**
 *
 * @author kiashi
 */
@Named(value = "categorieMB")
@RequestScoped
public class CategorieMB {

    @EJB
    private SuperadminBean superadminBean;

    /**
     * Creates a new instance of CategorieMB
     */
    Categorie categorie = new Categorie();
    private List<Categorie> listecategorie;
    private int idCategorie;

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Categorie> getListecategorie() {
        if (listecategorie == null){
            listecategorie = superadminBean.getListCategorie();
        }
        return listecategorie;
    }

    public void setListecategorie(List<Categorie> listecategorie) {
        this.listecategorie = listecategorie;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }
    
    public void loadCategorie() {
        this.categorie = superadminBean.findCatId(new Integer(idCategorie));
    }
    
    public CategorieMB() {
    }
    
    public String ajouter() {
         superadminBean.addCategorie(categorie);
        
        Util.addFlashInfoMessage("Modification effectué");
        return "/super_admin/accueil?faces-redirect=true";
    }
     public String modifier() {
      
        
        categorie = superadminBean.update(categorie);
        
        Util.addFlashInfoMessage("Modification effectué");
        return "/super_admin/accueil?faces-redirect=true";
    }
}

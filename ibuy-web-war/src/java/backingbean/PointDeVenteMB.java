/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbean;

import ejb.PointdeventeBean;
import entity.Magasin;
import entity.PointDeVente;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import util.MessageUtil;

/**
 *
 * @author kiashi
 */
@Named(value = "pointDeVenteMB")
@RequestScoped
public class PointDeVenteMB {

    @EJB
    private PointdeventeBean pointdeventeBean;

    PointDeVente pointdevente = new PointDeVente();
    private List<PointDeVente> listepointdevente;
    private int idPointdevente;

     public PointDeVenteMB() {
        }
    
    public List<PointDeVente> getListepointdevente() {
       if(listepointdevente == null){
            listepointdevente = pointdeventeBean.getListPointdevente();
        }
        return listepointdevente;
    }

    public void setListepointdevente(List<PointDeVente> listepointdevente) {
        this.listepointdevente = listepointdevente;
    }

    public int getIdPointdevente() {
        return idPointdevente;
    }

    public void setIdPointdevente(int idPointdevente) {
        this.idPointdevente = idPointdevente;
    }
    
    
    public PointDeVente getPointdevente() {
        return pointdevente;
    }

    public void setPointdevente(PointDeVente pointdevente) {
        this.pointdevente = pointdevente;
    }
    
    /**
     * Creates a new instance of PointDeVenteMB
     */
    
   
    public void loadPointDeVente() {
        this.pointdevente = pointdeventeBean.findById(new Integer(idPointdevente));
    }
    
    public String ajouter(){
        FacesContext context = FacesContext.getCurrentInstance();
        Magasin a =(Magasin) context.getExternalContext().getSessionMap().get("magasinSession");
        pointdevente.setMagasin(a);
        pointdeventeBean.creerPointdvente(pointdevente);
        
        MessageUtil.addFlashInfoMessage("Ajout effectué");
        return "/back-magasin/accueil?faces-redirect=true";
    }
    public String modifier() {
       FacesContext context = FacesContext.getCurrentInstance();
        Magasin a =(Magasin) context.getExternalContext().getSessionMap().get("magasinSession");
        pointdevente.setMagasin(a);
        pointdevente = pointdeventeBean.update(pointdevente);
        
        MessageUtil.addFlashInfoMessage("Modification effectué");
        return "/back-magasin/accueil?faces-redirect=true";
    }
}

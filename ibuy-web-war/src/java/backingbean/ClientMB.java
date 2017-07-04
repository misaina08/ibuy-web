/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbean;

import ejb.ClientBean;
import entity.Abonnement;
import entity.Client;
import entity.Magasin;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import util.MessageUtil;

/**
 *
 * @author kiashi
 */
@Named(value = "clientMB")
@ViewScoped
public class ClientMB implements Serializable{

    @EJB
    private ClientBean clientBean;
    
    /**
     * Creates a new instance of ClientMB
     */
    
    private List<Abonnement> abonne;

    public List<Abonnement> getAbonne() {
       if(abonne == null){
           
           FacesContext context = FacesContext.getCurrentInstance();
            Client c = (Client)context.getExternalContext().getSessionMap().get("clientSession");
            
           abonne = clientBean.getListAbonnement(c.getId());
        }
        return abonne;
    }

    public String ajoutabonne(Integer id){
        Magasin a= new Magasin();
       a.setId(id);
       FacesContext context = FacesContext.getCurrentInstance();
       Client c = (Client)context.getExternalContext().getSessionMap().get("clientSession");
       Abonnement ab = new Abonnement();
       ab.setMagasin(a);
       ab.setClient(c);
        clientBean.addAbonne(ab);
        
        MessageUtil.addFlashInfoMessage("Vous etes maintenant abonne");
         return "/front/abonnement?faces-redirect=true";
    }
    
    public void setAbonne(List<Abonnement> abonne) {
        this.abonne = abonne;
    }
    
    public ClientMB() {
    }
    
}

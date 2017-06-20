/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbean;

import ejb.AdminMagasinBean;
import ejb.ClientBean;
import ejb.SuperadminBean;
import entity.AdminMagasin;
import entity.Client;
import entity.Magasin;
import entity.SuperAdmin;
import entity.Utilisateur;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import mongo.MongoDao;
import mongo.modele.Produit;

/**
 *
 * @author Misaina
 */
@Named(value = "utilisateurMB")
@RequestScoped
public class UtilisateurMB {

    @EJB
    private ClientBean clientBean;

    @EJB
    private AdminMagasinBean adminMagasinBean;

    @EJB
    private SuperadminBean superadminBean;

    /**
     * Creates a new instance of UtilisateurMB
     */
    public UtilisateurMB() {
    }

    private SuperAdmin superAdmin = new SuperAdmin();
    private Utilisateur adminMagasin = new Utilisateur();
    private Client client = new Client();

    public String connectAdminMagasin() {
        try {
            AdminMagasin adminMag = adminMagasinBean.findUtilisateur(adminMagasin.getLogin(), adminMagasin.getMdp());
            Magasin magasinGere = adminMag.getMagasin();
            Utilisateur admin = adminMag.getAdmin();

            // test find mongodb
            Produit p = new Produit();
            p.setDesignation("ts");
            p.setPrix(new Double(11));
            MongoDao dao = new MongoDao();
            dao.find(p);
            
            

            /*if (magasinGere != null && admin != null) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.getExternalContext().getSessionMap().put("adminMagasinSession", admin);
                context.getExternalContext().getSessionMap().put("magasinSession", magasinGere);

                return "/back-magasin/accueil?faces-redirect=true";
            } else {
                return "/back-magasin/login?faces-redirect=true";
            }*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";

    }

    public String connectSuperAdmin() {
        SuperAdmin superAd = superadminBean.findAdmin(superAdmin.getLogin(), superAdmin.getMdp());

        if (superAd != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put("superAdminSession", superAd);
            return "/super_admin/accueil?faces-redirect=true";
        } else {
            return "/super_admin/login?faces-redirect=true";
        }
    }

    public String deconnectAdminMagasin() {
        return "/back-magasin/login?faces-redirect=true";
    }

    public String deconnectSuperAdmin() {
        return "/super_admin/login?faces-redirect=true";
    }

    public SuperAdmin getSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(SuperAdmin superAdmin) {
        this.superAdmin = superAdmin;
    }

    public Utilisateur getAdminMagasin() {
        return adminMagasin;
    }

    public void setAdminMagasin(Utilisateur adminMagasin) {
        this.adminMagasin = adminMagasin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbean;

import ejb.CategorieBean;
import ejb.MagasinBean;
import ejb.ProduitBean;

import entity.Produit;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import mongo.MongoDao;
import mongo.modele.recherche.RechercheAvancee;

/**
 *
 * @author Misaina
 */
@Named(value = "rechercheAvanceeMB")
@RequestScoped
public class RechercheAvanceeMB {

    @EJB
    private CategorieBean categorieBean;

    @EJB
    private MagasinBean magasinBean;

    @EJB
    private ProduitBean produitBean;

    private RechercheAvancee rechercheAvancee = new RechercheAvancee();
    private List<Produit> resultatRecherche;
    private List<entity.Magasin> magasins;
    private List<entity.Categorie> categories;

    private entity.Magasin magasinSelectionne;
    private entity.Categorie categorieSelectionne;

    private Boolean divShow = false;

    private Converter magasinConverter = new Converter() {
        /**
         * Convertit une String en Magasin.
         *
         * @param value valeur à convertir
         */
        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            return magasinBean.findMagasinById(new Integer(value));
        }

        /**
         * Convertit un Magasin en String.
         *
         * @param value valeur à convertir
         */
        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            entity.Magasin magasin = (entity.Magasin) value;
            return magasin.getId() + "";
        }
    };

    /**
     * Creates a new instance of RechercheAvanceeMB
     */
    public RechercheAvanceeMB() {
    }

    public void rechercher() {
        System.out.println("produit "+rechercheAvancee.getMotCle());
        resultatRecherche = produitBean.rechercher(rechercheAvancee);
        divShow = true;
//        return "/front/recherche/resultatRechercheAvancee";
    }

    public String sauvegarder() {
        MongoDao mongoDao = new MongoDao();
        try {
            mongo.modele.Magasin m = new mongo.modele.Magasin();
            m.setNom(magasinSelectionne.getNom());
            rechercheAvancee.setMagasin(m);
            mongoDao.save(rechercheAvancee);
//            JSONUtil jsonUtil = new JSONUtil();
////            rechercheAvancee.setMagasins(new ArrayList<Magasin>());
////            rechercheAvancee.setCategories(new ArrayList<Categorie>());
//            System.out.println("_________________________"+jsonUtil.parseObjectToJson(rechercheAvancee));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public RechercheAvancee getRechercheAvancee() {
        return rechercheAvancee;
    }

    public void setRechercheAvancee(RechercheAvancee rechercheAvancee) {
        this.rechercheAvancee = rechercheAvancee;
    }

    public List<Produit> getResultatRecherche() {
        return resultatRecherche;
    }

    public void setResultatRecherche(List<Produit> resultatRecherche) {
        this.resultatRecherche = resultatRecherche;
    }

    public List<entity.Magasin> getMagasins() {
        if (magasins == null) {
            magasins = magasinBean.getListMagasin();
        }
        return magasins;
    }

    public void setMagasins(List<entity.Magasin> magasins) {
        this.magasins = magasins;
    }

    public List<entity.Categorie> getCategories() {
        if (categories == null) {
            categories = categorieBean.getAll();
        }
        return categories;
    }

    public void setCategories(List<entity.Categorie> categories) {
        this.categories = categories;
    }

    public Converter getMagasinConverter() {
        return magasinConverter;
    }

    public void setMagasinConverter(Converter magasinConverter) {
        this.magasinConverter = magasinConverter;
    }

    public entity.Magasin getMagasinSelectionne() {
        return magasinSelectionne;
    }

    public void setMagasinSelectionne(entity.Magasin magasinSelectionne) {
        this.magasinSelectionne = magasinSelectionne;
    }

    public entity.Categorie getCategorieSelectionne() {
        return categorieSelectionne;
    }

    public void setCategorieSelectionne(entity.Categorie categorieSelectionne) {
        this.categorieSelectionne = categorieSelectionne;
    }

    public Boolean getDivShow() {
        return divShow;
    }

    public void setDivShow(Boolean divShow) {
        this.divShow = divShow;
    }
}

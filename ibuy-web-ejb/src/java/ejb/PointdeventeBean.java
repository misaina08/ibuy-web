/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Magasin;
import entity.PointDeVente;
import entity.ProduitPointDeVente;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kiashi
 */
@Stateless
@LocalBean
public class PointdeventeBean {

    @PersistenceContext(unitName = "ibuy-web-ejbPU")
    private EntityManager em;

    public void creerPointdvente(PointDeVente point) {
        em.persist(point);
    }

    public PointDeVente update(PointDeVente point) {
        return em.merge(point);
    }

    public void delete(PointDeVente point) {
        em.remove(point);
    }

    public PointDeVente findById(Integer id) {
        return em.find(PointDeVente.class, id);
    }

    public List<PointDeVente> getListPointdevente() {
        FacesContext context = FacesContext.getCurrentInstance();
        Magasin a = (Magasin) context.getExternalContext().getSessionMap().get("magasinSession");
        try {

            Query cl = em.createQuery("SELECT c FROM PointDeVente c WHERE c.magasin.id = :id ");
            cl.setParameter("id", a.getId());

            return (List<PointDeVente>) cl.getResultList();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

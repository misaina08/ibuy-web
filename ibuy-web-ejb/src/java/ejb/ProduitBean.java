/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.PointDeVente;
import entity.Produit;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Misaina
 */
@Stateless
@LocalBean
public class ProduitBean {

    @PersistenceContext(unitName = "ibuy-web-ejbPU")
    private EntityManager em;

    public void save(Produit produit) {
        em.persist(produit);
    }
    
    public List<Produit> getDerniersAjout(){
        Query query = em.createQuery("SELECT p FROM Produit p ORDER BY p.dateAjout DESC");
        query.setMaxResults(20);
        return (List<Produit>)query.getResultList();
    }

    public List<Produit> getPlusVus(){
        Query query = em.createQuery("SELECT p FROM Produit p ORDER BY p.nbVues DESC");
        query.setMaxResults(20);
        return (List<Produit>)query.getResultList();
    }
    
    public List<Produit> getListProduit(PointDeVente a){
        Query cl = em.createQuery("SELECT p FROM ProduitPointDeVente p WHERE p.pointDeVente.id = :a");
        cl.setParameter("a", a.getId());
        return (List<Produit>)cl.getResultList();
    }
    
}

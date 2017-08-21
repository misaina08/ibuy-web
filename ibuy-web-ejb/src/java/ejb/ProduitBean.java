/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Magasin;
import entity.PointDeVente;
import entity.Produit;
import entity.ProduitPointDeVente;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mongo.modele.recherche.RechercheAvancee;

/**
 *
 * @author Misaina
 */
@Stateless
@LocalBean
public class ProduitBean {

    @PersistenceContext(unitName = "ibuy-web-ejbPU")
    private EntityManager em;

    public void save(Produit produit, Integer idPointDeVente) {
        Produit p = em.merge(produit);
        PointDeVente a = new PointDeVente();
        a.setId(idPointDeVente);
        ProduitPointDeVente b = new ProduitPointDeVente();
        b.setProduit(p);
        b.setPointDeVente(a);
        em.persist(b);
    }
    

    public List<Produit> getDerniersAjout() {
        Query query = em.createQuery("SELECT p FROM Produit p ORDER BY p.dateAjout DESC");
        query.setMaxResults(20);
        return (List<Produit>) query.getResultList();
    }

    public List<Produit> getPlusVus() {
        Query query = em.createQuery("SELECT p FROM Produit p ORDER BY p.nbVues DESC");
        query.setMaxResults(20);
        return (List<Produit>) query.getResultList();
    }

    public List<Produit> rechercher(RechercheAvancee recherche) {
        String whereQuery = "";
        List<String> criteres = new ArrayList<String>();

        if (recherche.getPrixMax() != null) {
            criteres.add(" p.prix <= " + recherche.getPrixMax());
        }
        if (recherche.getPrixMin() != null) {
            criteres.add(" p.prix >= " + recherche.getPrixMin());
        }
        if (recherche.getMotCle() != null) {
            criteres.add(" p.designation like '%" + recherche.getMotCle() + "%'");
        }
        if (recherche.getCategorie() != null) {
            criteres.add(" p.categorie like '%" + recherche.getCategorie() + "%'");
        }
        if (recherche.getMagasin() != null) {
            criteres.add(" p.magasin like '%" + recherche.getMagasin() + "%'");
        }
        if (criteres.size() != 0) {
            whereQuery = " WHERE " + whereQuery;
        }
        int i = 0;
        for (String s : criteres) {
            whereQuery += s;
            if (i < criteres.size() - 1) {
                whereQuery += " and ";
            }
            i++;
        }
        System.out.println("query _______-----------" + whereQuery);
        Query query = em.createQuery("SELECT p FROM Produit p " + whereQuery + " ORDER BY p.nbVues DESC");

        return (List<Produit>) query.getResultList();
    }

    
    public List<Produit> getListProduit(PointDeVente a){
        Query cl = em.createQuery("SELECT p FROM ProduitPointDeVente p WHERE p.pointDeVente.id = :a");
        cl.setParameter("a", a.getId());
        return (List<Produit>)cl.getResultList();
    }
    
    public List<Produit> getListProduitParMagasin(Integer a){
         Query cl = em.createQuery("SELECT p FROM Produit p WHERE p.magasin.id = :a");
        cl.setParameter("a", a);
        return (List<Produit>)cl.getResultList();
    }

    public List<ProduitPointDeVente> getProduitByPointDeVente(Integer idPointDeVente) {
        try {
            Query cl = em.createQuery("SELECT p FROM ProduitPointDeVente p WHERE p.pointDeVente.id = :id ");
            cl.setParameter("id", idPointDeVente);

            return (List<ProduitPointDeVente>) cl.getResultList();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }
    }


}

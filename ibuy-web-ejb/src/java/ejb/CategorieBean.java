/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Categorie;
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
public class CategorieBean {

    @PersistenceContext(unitName = "ibuy-web-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Categorie> getAll(){
        Query query = em.createQuery("SELECT c FROM Categorie c");
        return (List<Categorie>)query.getResultList();
    }
}

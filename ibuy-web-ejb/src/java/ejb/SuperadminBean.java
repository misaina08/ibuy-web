/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Categorie;
import entity.SuperAdmin;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kiashi
 */
@Stateless
@LocalBean

public class SuperadminBean {

    @PersistenceContext(unitName = "ibuy-web-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

     public Categorie update(Categorie point) {
        return em.merge(point);
    }
     
     public void delete(Categorie point) {
        em.remove(point);
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
     public SuperAdmin findAdmin(String login, String mdp){
        try{
            Query query=em.createQuery("SELECT c FROM SuperAdmin c WHERE c.login = :login and c.mdp = :mdp ");
            query.setParameter("login", login);
            query.setParameter("mdp", mdp);
            return ((SuperAdmin) query.getSingleResult());       
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
     }
     
     public List<Categorie> getListCategorie(){
        try{
            
            Query cl=em.createQuery("SELECT c FROM Categorie c");
            return (List<Categorie>) cl.getResultList();
        }
        catch(RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }
     
      public Categorie findCatId(Integer id) {
        return em.find(Categorie.class, id);
    }
    
}

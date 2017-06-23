/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.AdminMagasin;
import entity.Magasin;
import entity.Utilisateur;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mia74
 */
@Stateless
@LocalBean
public class AdminMagasinBean {

    @PersistenceContext(unitName = "ibuy-web-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public AdminMagasin findUtilisateur(String login, String mdp){
        try{
            Query query=em.createQuery("SELECT c FROM AdminMagasin c WHERE c.admin.login = :login and c.admin.mdp = :mdp ");
            query.setParameter("login", login);
            query.setParameter("mdp", mdp);
            return ((AdminMagasin) query.getSingleResult());       
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

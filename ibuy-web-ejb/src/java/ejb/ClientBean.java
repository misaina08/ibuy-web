/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Abonnement;
import entity.Client;
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
public class ClientBean{

    @PersistenceContext(unitName = "ibuy-web-ejbPU")
    private EntityManager em;

    public void addAbonne(Abonnement abonne) {
        em.persist(abonne);
    }
     public Client findClient(String login, String mdp){
        try{
            Query query=em.createQuery("SELECT c FROM Client c WHERE c.login = :login and c.mdp = :mdp ");
            query.setParameter("login", login);
            query.setParameter("mdp", mdp);
            return ((Client) query.getSingleResult());       
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
     
     public List<Abonnement> getListAbonnement(Integer id) {
        try {

            Query cl = em.createQuery("SELECT c FROM Abonnement c WHERE c.client.id = :id");
            cl.setParameter("id", id);
            return (List<Abonnement>) cl.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     
  
    /*public List<Client> getListClient(){
        try{
            
            Query cl=em.createQuery("SELECT c FROM Client c");
            return (List<Client>) cl.getResultList();
        }
        catch(RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }*/
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

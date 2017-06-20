/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Client;
import entity.Personne;
import java.util.List;
import javax.ejb.EJBException;
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

    public void persist(Object object) {
        em.persist(object);
    }
    public List<Client> getListClient(){
        try{
            
            Query cl=em.createQuery("SELECT c FROM Client c");
            return (List<Client>) cl.getResultList();
        }
        catch(RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

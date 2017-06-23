/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.CategorieMagasin;
import entity.Magasin;
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
public class MagasinBean {

    @PersistenceContext(unitName = "ibuy-web-ejbPU")
    private EntityManager em;

    public void addMagasin(Magasin magasin) {
        em.persist(magasin);
    }
    public Magasin updateMagasin(Magasin magasin) {
        return em.merge(magasin);
    }
    public List<Magasin> getListMagasin(){
        try{
            
            Query cl=em.createQuery("SELECT c FROM Magasin c");
            return (List<Magasin>) cl.getResultList();
        }
        catch(RuntimeException e){
            e.printStackTrace();
            return null;
        }
    }
    public List<CategorieMagasin> getCategorieMagasin(Magasin magasin) {
    try{
       Query cl=em.createQuery("SELECT c FROM CategorieMagasin c WHERE c.magasin.id = :magasin ");
       cl.setParameter("magasin", magasin.getId());
           return (List<CategorieMagasin>) cl.getResultList();
        }
        catch(RuntimeException e){
            e.printStackTrace();
            return null;
        }

    
}
     
      public Magasin findMagasinById(Integer id) {
        return em.find(Magasin.class, id);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}

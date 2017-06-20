/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import mongo.MongoDao;
import mongo.modele.Produit;

/**
 *
 * @author Misaina
 */
@Stateless
@LocalBean
public class ProduitBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public void save(Produit produit){
        try{
            MongoDao mongoDao = new MongoDao();
            mongoDao.save(produit);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

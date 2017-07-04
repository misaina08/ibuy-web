/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import mongo.MongoDao;
import mongo.modele.Notification;
import mongo.modele.SuggestProduit;

/**
 *
 * @author Misaina
 */
@Stateless
@LocalBean
public class NotificationBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public List<Notification> find(Notification notification) throws Exception {
        MongoDao mongoDao = null;
        try {
            mongoDao = new MongoDao();
            return (List<Notification>) (List<?>) mongoDao.find(notification);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void save(Notification notif) throws Exception{
        MongoDao mongoDao = null;
        try {
            mongoDao = new MongoDao();
            mongoDao.save(notif);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void saveWithSuggestPdt(Notification notif, List<SuggestProduit> listeSuggestion) throws Exception{
        MongoDao mongoDao = null;
        try {
            mongoDao = new MongoDao();
            mongoDao.save(notif);
            for(SuggestProduit sugg : listeSuggestion){
                mongoDao.save(sugg);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
}

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
import mongo.modele.recherche.RechercheAvancee;

/**
 *
 * @author Misaina
 */
@Stateless
@LocalBean
public class RechercheBean {

    public List<RechercheAvancee> getRecherche(RechercheAvancee rechercheAvancee) throws Exception{
        MongoDao mongoDao = new MongoDao();
        return (List<RechercheAvancee>)(List<?>)mongoDao.find(rechercheAvancee);
    }
}

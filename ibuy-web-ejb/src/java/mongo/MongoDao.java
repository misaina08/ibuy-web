/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import java.util.ArrayList;
import java.util.List;
import mongo.modele.MongoModele;
import util.JSONUtil;
import util.MongoUtil;

/**
 *
 * @author Misaina
 */
public class MongoDao implements MongoOperation {

    @Override
    public void save(MongoModele mongoModele) throws Exception {
        MongoUtil mongoUtil = null;
        JSONUtil jsonUtil = null;
        try {
            mongoUtil = new MongoUtil();
            DBCollection collection = mongoUtil.getCollection(mongoModele);
            jsonUtil = new JSONUtil();
                    
            String json = jsonUtil.parseObjectToJson(mongoModele);
            System.out.println("-------------"+json);
            DBObject document = (DBObject) JSON.parse(json);

            collection.insert(document);

        } catch (Exception ex) {
            throw ex;
        }

    }

    @Override
    public void update(MongoModele mongoModele) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MongoModele> find(MongoModele mongoModele) throws Exception {
        List<MongoModele> res = null;
        BasicDBObject query = null;
        MongoUtil mongoUtil = null;
        JSONUtil jSONUtil = null;
        try{
            jSONUtil = new JSONUtil();
            mongoUtil = new MongoUtil();
            res =  new ArrayList<MongoModele>();
                        
            DBCollection collection = mongoUtil.getCollection(mongoModele);
            
            query = mongoModele.buildBasicQuery();          
            
            DBCursor cursor = collection.find(query);
            
            while(cursor.hasNext()){
//                System.out.println("_______"+cursor.next());
                MongoModele m = jSONUtil.parseJsonObjectStringToObject(cursor.next().toString(), mongoModele);
                res.add(m);
            }
//            for(MongoModele mo : res){
////                System.out.println("---"+((Produit)mo).getDesignation());
//            }
            
            return res;
        }
        catch(Exception ex){
            throw ex;
        }
    }

    @Override
    public void remove(MongoModele mongoModele) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

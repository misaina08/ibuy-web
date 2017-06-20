/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import mongo.modele.MongoModele;

/**
 *
 * @author Misaina
 */
public class MongoUtil {
    private static String host = "localhost";
    private static int port = 27017;
    private static String dbName = "ibuy";
    
    private MongoClient mongoClient;
    
    public MongoClient connect(){
        mongoClient = new MongoClient(host , port);
        return mongoClient;
    }
    
    public DB getDataBase(){
        this.mongoClient = connect();
        return this.mongoClient.getDB(dbName);
    }
    
    public DBCollection getCollection(String collectionName){
        DBCollection coll = getDataBase().getCollection(collectionName);
        return coll;
    }
    
    public DBCollection getCollection(MongoModele modele){
        System.out.println("______________"+modele.getClass().getSimpleName().toLowerCase());
        DBCollection coll = getDataBase().getCollection(modele.getClass().getSimpleName());
        return coll;
    }
    
}

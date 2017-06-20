/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongo;

import java.util.List;
import mongo.modele.MongoModele;

/**
 *
 * @author Misaina
 */
public interface MongoOperation {

    public abstract void save(MongoModele mongoModele) throws Exception;

    public abstract void update(MongoModele mongoModele) throws Exception;

    public abstract List<MongoModele> find(MongoModele mongoModele) throws Exception;

    public abstract void remove(MongoModele mongoModele) throws Exception;
}

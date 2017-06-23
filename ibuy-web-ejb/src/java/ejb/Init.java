/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import com.mongodb.MongoClient;
import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Misaina
 */
@DataSourceDefinition(
        className = "oracle.jdbc.pool.OracleDataSource",
        name = "jdbc/oracle",
        url = "jdbc:oracle:thin:@localhost:1521:XE",
        user = "shopping",
        password = "shopping",
        databaseName = "shopping"
)
@Singleton
@LocalBean
@Startup
public class Init {

    @PersistenceContext(unitName = "ibuy-web-ejbPU")
    private EntityManager em;
    
    @PostConstruct
    public void init() {
        MongoClient mongoClient = null;
        try {
//            mongoClient = new MongoClient();
//
//            List<String> databases = mongoClient.getDatabaseNames();
//
//            for (String dbName : databases) {
//                System.out.println("- Database: " + dbName);
//
//                DB db = mongoClient.getDB(dbName);
//
//                Set<String> collections = db.getCollectionNames();
//                for (String colName : collections) {
//                    System.out.println("\t + Collection: " + colName);
//                }
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (mongoClient != null) {
                mongoClient.close();
            }
        }
    }

    public void persist(Object object) {
        em.persist(object);
    }

}

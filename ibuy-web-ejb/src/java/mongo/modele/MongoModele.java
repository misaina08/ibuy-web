/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongo.modele;

import com.mongodb.BasicDBObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
import util.Util;

/**
 *
 * @author Misaina
 */
public class MongoModele {
    public BasicDBObject buildBasicQuery() throws Exception{
        Util util = new Util();
        BasicDBObject result = new BasicDBObject();
        
        Field[] fields = this.getClass().getDeclaredFields();
        for(int i=0; i < fields.length; i++){
            Method methodGet = this.getClass().getMethod("get"+util.premierMaj(fields[i].getName()), null);
            Object objet = methodGet.invoke(this, null);
            
            if(objet != null){
                Class[] arguments = new Class[2];
                
                arguments[0] = java.lang.String.class;
                arguments[1] = java.lang.Object.class;
                Method methodPutInQuery = result.getClass().getMethod("put", arguments);
                Object[] argPutQuery = new Object[2];
                argPutQuery[0] = fields[i].getName();
                Object value = objet;
                if(fields[i].getType().getName() == "java.lang.String"){
                    value = Pattern.compile(Pattern.quote(objet.toString()));
                }
                argPutQuery[1] = value;
                methodPutInQuery.invoke(result, argPutQuery);                
            }
            
        }
        System.out.println("query "+result);
        
        return result;
    }
    
}

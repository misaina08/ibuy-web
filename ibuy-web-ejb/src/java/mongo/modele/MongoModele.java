/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongo.modele;

import com.mongodb.BasicDBObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Time;
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
    public void initValues() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        Util util = new Util();
        Field[] champs = util.getFields(this.getClass());

        for (int i = 0; i < champs.length; i++) {
            Method met = this.getClass().getMethod("get" + util.premierMaj(champs[i].getName()), null);
            Object obj = met.invoke(this, null);

            if (obj == null) {
                Class[] type = new Class[1];
                type[0] = champs[i].getType();
                Method metSet = this.getClass().getMethod("set" + util.premierMaj(champs[i].getName()), type);
                Object param = null;

                if (champs[i].getType().getSimpleName().compareToIgnoreCase("Integer") == 0) {
                    param = new Integer(0);
                } else if (champs[i].getType().getSimpleName().compareToIgnoreCase("Boolean") == 0) {
                    param = new Boolean(false);
                } else if (champs[i].getType().getSimpleName().compareToIgnoreCase("Float") == 0) {
                    param = new Float(0.00);
                } else if (champs[i].getType().getSimpleName().compareToIgnoreCase("Time") == 0) {
                    param = new Time(0, 0, 0);
                } else {
                    param = champs[i].getType().newInstance();
                }
                metSet.invoke(this, param);

            }

        }
    }
    
}

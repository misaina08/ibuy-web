/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.Gson;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import mongo.modele.MongoModele;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Misaina
 */
public class JSONUtil {

    public String parseObjectToJson(MongoModele baseModele) throws Exception {
        try {
            Gson gson = new Gson();
            return gson.toJson(baseModele);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<MongoModele> parseJsonArrayToList(String jsonArrayStr, MongoModele baseModele) throws Exception {
        List<MongoModele> result = null;
        try {
            result = new ArrayList<MongoModele>();
            JSONArray jsonArray = new JSONArray(jsonArrayStr);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                result.add(parseJsonObjectToObject(jsonObject, baseModele));
            }
            return result;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public MongoModele parseJsonObjectToObject(JSONObject jsonObject, MongoModele baseModele) throws Exception {
        Field[] fieldsMongoModele = null;
        MongoModele result = baseModele.getClass().newInstance();
        Util util = null;
        try {
            util = new Util();
            fieldsMongoModele = baseModele.getClass().getDeclaredFields();
            //Log.i("taille ", fieldsMongoModele.length+"");
            for (int i = 0; i < fieldsMongoModele.length; i++) {
                if (fieldsMongoModele[i].getName().compareToIgnoreCase("serialVersionUID") == 0
                        || fieldsMongoModele[i].getName().compareToIgnoreCase("$change") == 0) {
                    continue;
                }
                Class[] type = new Class[1];
                type[0] = fieldsMongoModele[i].getType();

                Method method = result.getClass().getMethod("set" + util.premierMaj(fieldsMongoModele[i].getName()), type);
                Object param = util.setValueInString(fieldsMongoModele[i], jsonObject.getString(fieldsMongoModele[i].getName()));
                Object objet = method.invoke(result, param);
            }

            return result;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public MongoModele parseJsonObjectStringToObject(String jsonStr, MongoModele baseModele) throws Exception {
        Field[] fieldsMongoModele = null;
        MongoModele result = baseModele.getClass().newInstance();
        Util util = null;
        try {
            util = new Util();
            fieldsMongoModele = baseModele.getClass().getDeclaredFields();
            //Log.i("taille ", fieldsMongoModele.length+"");
            JSONObject jsonObject = new JSONObject(jsonStr);
            for (int i = 0; i < fieldsMongoModele.length; i++) {
                if (fieldsMongoModele[i].getName().compareToIgnoreCase("serialVersionUID") == 0
                        || fieldsMongoModele[i].getName().compareToIgnoreCase("$change") == 0) {
                    continue;
                }
                Class[] type = new Class[1];
                type[0] = fieldsMongoModele[i].getType();
                //Log.i("field : ",fieldsMongoModele[i].getName());

                Method method = result.getClass().getMethod("set" + util.premierMaj(fieldsMongoModele[i].getName()), type);
                Object param = util.setValueInString(fieldsMongoModele[i], jsonObject.getString(fieldsMongoModele[i].getName()));
                Object objet = method.invoke(result, param);
            }

            return result;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public String listToArrayJson(List<MongoModele> liste) throws Exception {
        String res = "[";
        int i = 1;
        for (MongoModele m : liste) {
            res += parseObjectToJson(m);
            if (i < liste.size()) {
                res += ",";
            }
            i++;
        }
        return res + "]";
    }
}

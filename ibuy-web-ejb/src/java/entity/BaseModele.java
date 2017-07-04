/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Time;
import util.Util;

/**
 *
 * @author Misaina
 */
public class BaseModele {
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

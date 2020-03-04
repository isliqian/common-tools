package com.github.isliqian.tools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Author:liqian
 * Date:2020/3/3
 * Desc:properties文件读取存储类
 */
public class PropertiesTools {

    private static Properties props;


    public static void loadProps(String prop){
        props = new Properties();
        InputStream in = null;
        try {
            in = PropertiesTools.class.getClassLoader().getResourceAsStream(prop);
            props.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getProperty(String key){
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }
}

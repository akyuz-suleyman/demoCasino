package com.demo_casino.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    public static Properties properties;


    static{
        try{

            FileInputStream fileInputStream=new FileInputStream("configuration.properties");
            properties=new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();

        }catch (Exception e){
            System.out.println("Failed to load properties file!");
            e.printStackTrace();
        }
    }

    public static String get(String keyName){return properties.getProperty(keyName);}


}

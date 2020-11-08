package com.techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader<fileInputStream> {
    // This class will READ THE DATA FROM configuration.properties file!!!!!!!!!!!!!

    //create a properties instance. Data type=Properties instance name=properties
    private static Properties properties;

    static {
        //path of the configuration.properties file
        String path = "configuration.properties";

        {
            try {
                //Opening the configuration.properties file
                FileInputStream fileInputStream = new FileInputStream(path);
                //loading the file
                properties = new Properties();
                properties.load(fileInputStream);
                //closing the file
                fileInputStream.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //Create a method to READ
    // This method will get the KEY and return the VALUE
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

    //Testing if our logic works
    /*
    public static void main(String[] args){
        System.out.print(properties.getProperty("url"));
    }

     */
}

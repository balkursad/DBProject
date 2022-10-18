package de.bahn.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReaders {

    private static Properties properties = new Properties();

    static{
        try{
            FileInputStream file = new FileInputStream("configuration.properties");

            properties.load(file);

            file.close();
        }catch (IOException e){
            System.out.println("File not found on the configurationReaders class");
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
}

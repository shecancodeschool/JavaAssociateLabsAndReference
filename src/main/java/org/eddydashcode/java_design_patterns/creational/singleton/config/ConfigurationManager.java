package org.eddydashcode.java_design_patterns.creational.singleton.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager {

    private static volatile ConfigurationManager instance;
    private final Properties properties = new Properties();

    private ConfigurationManager(String configFilePath) {
        try (FileInputStream inputStream = new FileInputStream(configFilePath)) {
            properties.load(inputStream);
        } catch (IOException ex) {
            System.out.println("Failed to load configuration file: " + configFilePath);
        }
    }

    public static ConfigurationManager getConfiguration(String path) {

        if (instance == null) {
            synchronized (ConfigurationManager.class) {
                if (instance == null) {
                    instance = new ConfigurationManager(path);
                }
            }
        }

        return instance;
    }

//    public static synchronized ConfigurationManager getConfiguration(String path) {
//
//        if (instance == null) {
//            instance = new ConfigurationManager(path);
//        }
//
//        return instance;
//    }


//    public static ConfigurationManager getConfiguration(String path) {
//
//        if (instance == null) {
//            synchronized (ConfigurationManager.class){
//                instance = new ConfigurationManager(path);
//            }
//        }
//
//        return instance;
//    }

    public String get(String key) {
        return properties.getProperty(key);
    }
}

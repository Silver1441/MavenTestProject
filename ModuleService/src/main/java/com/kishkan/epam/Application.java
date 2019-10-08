package com.kishkan.epam;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
//        Properties prop = app.loadPropertiesFile("config.properties");
        System.out.println(app.getPath());

    }

//    private String getPath() {
//        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
//
//            Properties prop = new Properties();
//
//            if (input == null) {
//                System.out.println("unable to find config.properties");
//            }
//
//            prop.load(input);
//
//            return  prop.getProperty("path");
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//
//        return "не нашел файл";
//    }

    private String getPath() {
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            return  prop.getProperty("path");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return "не нашел файл";
    }

//    public Properties loadPropertiesFile(String filePath) {
//
//        Properties prop = new Properties();
//
//        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
//            prop.load(resourceAsStream);
//        } catch (IOException e) {
//            System.err.println("Unable to load properties file : " + filePath);
//        }
//
//        return prop;
//
//    }
}
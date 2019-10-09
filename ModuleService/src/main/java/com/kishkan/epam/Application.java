package com.kishkan.epam;

import com.kishkan.epam.service.XmlUnmarshaller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.kishkan.epam.dto.Category;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        XmlUnmarshaller xmlUnmarshaller = new XmlUnmarshaller();
        String source = app.getPath();

        System.out.println(source);

        try {
            Category resultDto = xmlUnmarshaller.unmarshalXmlById(source, Category.class, 110001L);
            System.out.println(resultDto);
        } catch (XMLStreamException | JAXBException e) {
            e.printStackTrace();
        }
    }

    private String getPath() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            return  properties.getProperty("path");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }


}
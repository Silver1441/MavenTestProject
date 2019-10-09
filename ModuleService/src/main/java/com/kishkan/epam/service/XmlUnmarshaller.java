package com.kishkan.epam.service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

public class XmlUnmarshaller {


    public <T> T unmarshalXmlById(String source, Class<T> valueClass, Long id)
            throws XMLStreamException, JAXBException {

        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(source);

        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream);
        xmlStreamReader.nextTag();

        while (xmlStreamReader.hasNext()) {
            xmlStreamReader.next();
            if (xmlStreamReader.getEventType() == XMLStreamReader.START_ELEMENT
                    && xmlStreamReader.getAttributeValue(0) != null
                    && xmlStreamReader.getAttributeValue(0).equals(id.toString())) {
                break;
            }
        }

        Unmarshaller unmarshaller = JAXBContext.newInstance(valueClass).createUnmarshaller();
        JAXBElement<T> element = unmarshaller.unmarshal(xmlStreamReader, valueClass);
        T dto = element.getValue();
        xmlStreamReader.close();
        return dto;
    }
}
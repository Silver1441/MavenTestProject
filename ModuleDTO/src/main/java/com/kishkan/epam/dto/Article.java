package com.kishkan.epam.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "article")
@XmlRootElement
public class Article {
    @XmlAttribute(name = "id")
    private long id;
    @XmlAttribute(name = "stock")
    private int stock;
    @XmlElement(name = "manufacturer")
    private String manufacturer;
    @XmlElement(name = "model")
    private String model;
    @XmlElement(name = "production_date")
    private String productionDate;
    @XmlElement(name = "color")
    private String color;
    @XmlElement(name = "price")
    private Double price;

    @Override
    public String toString() {
        return "{ID = " + id +
                ", stock=" + stock +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", productionDate='" + productionDate + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}' + "\n";
    }
}
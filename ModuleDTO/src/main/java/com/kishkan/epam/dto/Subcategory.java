package com.kishkan.epam.dto;

import com.kishkan.epam.dto.Article;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "subcategory")
@XmlRootElement
public class Subcategory {
    @XmlAttribute(name = "id")
    private long id;
    @XmlAttribute(name = "name")
    private String name;
    @XmlElement(name = "article")
    private List<Article> articles;

    @Override
    public String toString() {
        return "\nSubcategory:\n{name = " + name + "\nID = " + id +
                "\n" + articles +
                '}';
    }
}
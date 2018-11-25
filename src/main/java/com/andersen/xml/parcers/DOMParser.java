package com.andersen.xml.parcers;

import com.andersen.xml.entity.Person;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMParser implements PersonParser {


    @Override
    public List<Person> parse(String filePath) throws IOException {

        File file = new File(filePath);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        List<Person> personList = new ArrayList<>();

        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("person");

            for (int i = 0; i < nodeList.getLength(); i++){
                Node nNode = nodeList.item(i);

                Person person = new Person();

                // обращаемся к нужным тегам и достаем нужнцю информацию
                if (nNode.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) nNode;
                    person.setId(Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent()));
                    person.setName(element.getElementsByTagName("name").item(0).getTextContent());
                    person.setSurname(element.getElementsByTagName("surname").item(0).getTextContent());
                    person.setAge(Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent()));
                    person.setPhoneNumber(element.getElementsByTagName("phoneNumber").item(0).getTextContent());
                }
                personList.add(person);
            }
            return personList;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return null;
    }
}

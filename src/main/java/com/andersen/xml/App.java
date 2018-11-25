package com.andersen.xml;

import com.andersen.xml.createXML.CreateXML;
import com.andersen.xml.entity.PersonList;
import com.andersen.xml.parcers.DOMParser;
import com.andersen.xml.parcers.SAXPersonParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

/**
 *
 *
 */
public class App {
    public static void main(String[] args) {

        // составили список людей
        PersonList personList = new PersonList();

        // сделали XML-документ
        CreateXML createXML = new CreateXML();
        createXML.create(personList);

        //проверяем DOM-парсер
        DOMParser domParser = new DOMParser();

        try {
            //проверили наш DOM-парсер, он работает
            System.out.println(domParser.parse("C:\\Users\\katya\\IdeaProjects\\json_xml\\person.xml"));
            System.out.println("**************************************************************************************");
        } catch (IOException e) {
            e.printStackTrace();
        }


        //проверяем SAX парсер
        SAXPersonParser saxPersonParser = new SAXPersonParser();
        try {
            saxPersonParser.parse("C:\\Users\\katya\\IdeaProjects\\json_xml\\person.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

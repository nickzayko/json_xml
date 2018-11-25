package com.andersen.xml.parcers;

import com.andersen.xml.entity.Person;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SAXPersonParser implements PersonParser {
//    private List<Person> personList;

    @Override
    public List<Person> parse(String filePath) throws IOException {
        List<Person> personList;
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            SAXHandler saxHandler = new SAXHandler();

            saxParser.parse(filePath, saxHandler);
            personList = saxHandler.getPersonList();
            return personList;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }
}

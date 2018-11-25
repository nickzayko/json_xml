package com.andersen.xml.parcers;

import com.andersen.xml.entity.Person;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {

    private String currentElement;
    private Person person;
    private List<Person> personList = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (person == null)
            person = new Person();
        if (currentElement.equalsIgnoreCase("id"))
            person.setId(Integer.parseInt(new String(ch, start, length)));
        if (currentElement.equalsIgnoreCase("name"))
            person.setName(new String(ch, start, length));
        if (currentElement.equalsIgnoreCase("surname"))
            person.setSurname(new String(ch, start, length));
        if (currentElement.equalsIgnoreCase("age"))
            person.setAge(Integer.parseInt(new String(ch, start,length)));
        if (currentElement.equalsIgnoreCase("phoneNumber"))
            person.setPhoneNumber(new String(ch, start,length));
        if (allFieldNotNull()){
            personList.add(person);
            person = null;
        }
    }

    private boolean allFieldNotNull() {
       return person.getId()!=0 && person.getName()!=null && person.getSurname()!=null &&
               person.getAge()!=0 && person.getPhoneNumber()!=null;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
    }

    public List<Person> getPersonList() {
        return personList;
    }
}

// альтернативный вариант, не хватает проверки на заполненность всех полей, перед тем как добавить персону в коллекцию
//    private Person person;
//    private List<Person> personList = new ArrayList<>();

//    boolean id = false;
//    boolean name = false;
//    boolean surname = false;
//    boolean age = false;
//    boolean phoneNumber = false;

//    @Override
//    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        if (qName.equalsIgnoreCase("person")){
//        } else if (qName.equalsIgnoreCase("id")){
//            id = true;
//        } else if (qName.equalsIgnoreCase("name")){
//            name = true;
//        } else if (qName.equalsIgnoreCase("surname")){
//            surname = true;
//        } else if (qName.equalsIgnoreCase("age")){
//            age = true;
//        } else if (qName.equalsIgnoreCase("phoneNumber")){
//            phoneNumber = true;
//        }
//    }
//
//    @Override
//    public void endElement(String uri, String localName, String qName) throws SAXException {
//
//    }
//
//    @Override
//    public void characters(char[] ch, int start, int length) throws SAXException {
//        if (person == null){
//            person = new Person();
//        }
//        if (id){
//            person.setId(Integer.parseInt(new String(ch, start, length)));
//            id = false;
//        }
//        if (name){
//            person.setName(new String(ch, start, length));
//            name = false;
//        }
//        if (surname){
//            person.setSurname(new String(ch, start, length));
//            surname = false;
//        }
//        if (age){
//            person.setAge(Integer.parseInt(new String(ch, start, length)));
//            age = false;
//        }
//        if (phoneNumber){
//            person.setPhoneNumber(new String(ch, start, length));
//            phoneNumber = false;
//        }
//
//        personList.add(person);
//        person = null;
//    }
//
//    public List<Person> getPersonList() {
//        return personList;
//    }
//}

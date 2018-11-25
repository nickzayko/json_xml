//package com.andersen.json.entity;
//
//import com.andersen.xml.entity.Person;
//
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
//import java.util.ArrayList;
//import java.util.List;
//
//public class PersonListJSON {
//
//    private List<Person> personList = new ArrayList<>();
//
//    public PersonListJSON() {
//        Person person = new Person(1, "Ivanov", "Ivan", 22, "+375 29 111 1111");
//        Person person1 = new Person(2, "Petrov", "Petr", 23, "+375 33 222 2222");
//        Person person2 = new Person(3, "Sidorov", "Sidr", 24, "+375 44 333 3333");
//        Person person3 = new Person(4, "Popov", "Serg", 25, "+375 25 444 4444");
//
//        personList.add(person);
//        personList.add(person1);
//        personList.add(person2);
//        personList.add(person3);
//    }
//
//    @Override
//    public String toString() {
//        return "PersonList{" +
//                "person=" + personList +
//                '}';
//    }
//}

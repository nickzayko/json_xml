package com.andersen.xml.entity;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlType(propOrder = {"id", "name", "surname", "age", "phoneNumber"})
public class Person {

    private int id;
    private String surname;
    private String name;
    private int age;
    private String phoneNumber;

    public Person() {
    }

    public Person(int id, String surname, String name, int age, String phoneNumber) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

package com.andersen.json.entity;

public class PersonJSON {

    private Long id;
    private String surname;
    private String name;
    private Long age;
    private String phoneNumber;

    public PersonJSON() {
    }

    public PersonJSON(int id, String surname, String name, int age, String phoneNumber) {
        this.id = Long.valueOf(id);
        this.surname = surname;
        this.name = name;
        this.age = Long.valueOf(age);
        this.phoneNumber = phoneNumber;
    }

    public PersonJSON(String string) {
        this.id = Long.valueOf(1);
        this.surname = "Ivanov";
        this.name = "Ivan";
        this.age = Long.valueOf(18);
        this.phoneNumber = "+375 33 111 1111";
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
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
        return surname + " " + name + " " + age + " " + phoneNumber;
    }
}

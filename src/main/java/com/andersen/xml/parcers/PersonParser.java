package com.andersen.xml.parcers;

import com.andersen.xml.entity.Person;

import java.io.IOException;
import java.util.List;

public interface PersonParser {
    List<Person> parse(String filePath) throws IOException;
}

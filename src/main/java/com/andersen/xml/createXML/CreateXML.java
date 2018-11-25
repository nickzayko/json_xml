package com.andersen.xml.createXML;

import com.andersen.xml.entity.Person;
import com.andersen.xml.entity.PersonList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class CreateXML {
    public CreateXML() {
    }

    public void create(PersonList personList) {
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(PersonList.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File file = new File("person.xml");
            marshaller.marshal(personList, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

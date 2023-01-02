package org.ildus.akhamdiev.dao;

import org.ildus.akhamdiev.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> personList;

    {
        personList = new ArrayList<>();
        personList.add(new Person(1L,"Maks"));
        personList.add(new Person(2L,"Igor"));
        personList.add(new Person(3L,"Liza"));
    }

    public List<Person> getAllPeople() {
        return personList;
    }

    public Person getPeople(Long id) {
        Person person = personList.stream().filter((ob) -> ob.getId() == id.intValue()).findAny().orElse(null);

        return person;
    }
}

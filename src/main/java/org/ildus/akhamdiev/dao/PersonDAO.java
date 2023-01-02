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
        personList.add(new Person("Maks"));
        personList.add(new Person("Igor"));
        personList.add(new Person("Liza"));
    }

    public List<Person> getAllPeople() {
        return personList;
    }

    public Person getPeople(Long id) {
//        Person person = personList.stream().filter((ob) -> ob.getId() == id).findAny().orElse(null);
        for (Person person : personList) {
            if(person.getId()==id) {
                return person;
            }
        }

        return null;
    }

    public void save(Person person) {
        person.increment();
        personList.add(person);
    }
}

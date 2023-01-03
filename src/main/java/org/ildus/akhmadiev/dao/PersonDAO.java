package org.ildus.akhmadiev.dao;

import org.ildus.akhmadiev.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> personList;

    {
        personList = new ArrayList<>();
        personList.add(new Person("Maks",10,"ya@mail.ru"));
        personList.add(new Person("Igor",33,"go@go.ru"));
        personList.add(new Person("Liza",19,"lo@go.ru"));
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

    public void update(long id, Person person) {
        Person personUp = getPeople(id);
        personUp.setName(person.getName());
        personUp.setAge(person.getAge());
        personUp.setEmail(person.getEmail());
    }

    public void delete(long id) {
        personList.removeIf(person -> person.getId() == id);
    }
}

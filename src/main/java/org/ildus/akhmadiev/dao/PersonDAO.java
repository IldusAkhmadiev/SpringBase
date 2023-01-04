package org.ildus.akhmadiev.dao;

import org.ildus.akhmadiev.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> getAllPeople() {
        return jdbcTemplate.query("select * from Person",new BeanPropertyRowMapper<>(Person.class));
    }

    public Person getPeople(Long id) {
        return jdbcTemplate.query("SELECT * from Person where id=?",new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny()
                .orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT into Person VALUES(?,?,?,?)",person.increment(),person.getName(),
                person.getAge(),person.getEmail());
    }

    public void update(long id, Person person) {
        jdbcTemplate.update("UPDATE  Person set name=?,age=?,email=? Where id=?",person.getName(),person.getAge(),
                person.getEmail(),id);
    }

    public void delete(long id) {
       jdbcTemplate.update("DELETE FROM  Person where id=?",id);
    }
}

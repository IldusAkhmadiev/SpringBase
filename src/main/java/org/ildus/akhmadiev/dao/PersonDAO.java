package org.ildus.akhmadiev.dao;

import org.ildus.akhmadiev.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

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

    public void withBatch() {
        List<Person> personList = create1000People();
        long begin = System.currentTimeMillis();
        jdbcTemplate.batchUpdate("INSERT into Person VALUES(?,?,?,?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setLong(1,personList.get(i).getId());
                preparedStatement.setString(2,personList.get(i).getName());
                preparedStatement.setInt(3,personList.get(i).getAge());
                preparedStatement.setString(4,personList.get(i).getEmail());
            }

            @Override
            public int getBatchSize() {
                return personList.size();
            }
        });
        long end = System.currentTimeMillis();
        System.out.println("---------------------------------" + (end-begin) + "-------------------------------");
    }

    public void withoutBatch() {
        List<Person> personList = create1000People();
        long begin = System.currentTimeMillis();
        for (Person person : personList) {
            jdbcTemplate.update("INSERT into Person VALUES(?,?,?,?)",person.getId(),person.getName(),
                    person.getAge(),person.getEmail());
        }
        long end = System.currentTimeMillis();
        System.out.println("---------------------------------" + (end-begin) + "-------------------------------");
    }

    private List<Person> create1000People() {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            personList.add(new Person((long) i,"Name "+i,30,"test"+i+"@mail.ru"));
        }
        return personList;
    }
}

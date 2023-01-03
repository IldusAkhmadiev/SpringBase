package org.ildus.akhmadiev.dao;

import org.ildus.akhmadiev.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static String URL = "jdbc:postgresql://localhost:5433/SpringBase";
    private static String logAndPassword = "postgres";

    private static Connection connection;

    static  {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL,logAndPassword,logAndPassword);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public List<Person> getAllPeople() {
        List<Person> personList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "select * from Person";
            ResultSet resultSet = statement.executeQuery(SQL);
            while(resultSet.next()) {
                Person person = new Person();
                person.setId((long) resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));
                person.setAge(resultSet.getInt("age"));

                personList.add(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return personList;
    }

    public Person getPeople(Long id) {
        return null;
    }

    public void save(Person person) {
        try {
            Statement statement = connection.createStatement();
            String SQL = "insert into Person values(" +person.increment() + ",'" + person.getName() + "'," +
        person.getAge() + ",'" + person.getEmail() + "')";
            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void update(long id, Person person) {

    }

    public void delete(long id) {

    }
}

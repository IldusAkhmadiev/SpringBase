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
        Person person = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from Person where id=?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            person = new Person();
            resultSet.next();
            person.setId(resultSet.getLong("id"));
            person.setName(resultSet.getString("name"));
            person.setAge(resultSet.getInt("age"));
            person.setEmail(resultSet.getString("email"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return person;
    }

    public void save(Person person) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT into Person VALUES(?,?,?,?)");
            preparedStatement.setLong(1,( person.increment()));
            preparedStatement.setString(2,person.getName());
            preparedStatement.setInt(3,person.getAge());
            preparedStatement.setString(4,person.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void update(long id, Person person) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE  Person set name=?,age=?,email=? Where id=?");
            preparedStatement.setString(1,person.getName());
            preparedStatement.setInt(2,person.getAge());
            preparedStatement.setString(3,person.getEmail());
            preparedStatement.setLong(4,id );
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM  Person where id=?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

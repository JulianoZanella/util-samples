package br.com.julianozanella.util.sample.app;

import br.com.julianozanella.util.Database;
import br.com.julianozanella.util.exception.ConnectionNotFoundException;
import br.com.julianozanella.util.sample.model.Person;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/personsDB";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try {
            Database.createConnection(URL, USER, PASSWORD);
            select();
            insert();
            select();
            update();
            select();
            delete();
            select();

        } catch (SQLException | ClassNotFoundException | ConnectionNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    private static void insert() throws ClassNotFoundException, SQLException, ConnectionNotFoundException, IllegalAccessException {
        Person person = new Person(47, "Foo", new Date(2018, 06, 10), 'O');
        Database.insert(person);
        System.out.println("Inserted person: " + person);
    }

    private static void update() throws ClassNotFoundException, SQLException, ConnectionNotFoundException, IllegalAccessException {
        Person person = new Person(47, "Foo - Updated", new Date(2015, 06, 10), 'O');
        Database.update(person);
        System.out.println("Updated person: " + person);
    }

    private static void delete() throws ClassNotFoundException, SQLException, ConnectionNotFoundException, IllegalAccessException {
        Person person = new Person();
        person.setId(47);
        Database.delete(person);
        System.out.println("Deleted person: " + person);
    }


    private static void select() throws IllegalAccessException, InvocationTargetException, InstantiationException, SQLException, ConnectionNotFoundException, NoSuchMethodException {
        List<Person> persons = new ArrayList<>();
        List<Object> objectList = Database.select(Person.class);
        for (Object object : objectList) {
            Person p = (Person) object;
            persons.add(p);
        }
        printList(persons);

    }

    private static void printList(List<Person> persons) {
        System.out.println("-----------------------");
        System.out.println("Printing all Persons:");
        System.out.println();
        for (Person person : persons) {
            System.out.println(person);
        }
        System.out.println("End of Persons List");
        System.out.println("-----------------------");
        System.out.println();

    }
}

package br.com.julianozanella.util.sample.model;

import java.sql.Date;

public class Person {

    private int id;
    private String name;
    private Date birthDate;
    private char sex;

    public Person() {
    }

    public Person(int id, String name, Date birthDate, char sex) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", sex=" + sex +
                '}';
    }
}

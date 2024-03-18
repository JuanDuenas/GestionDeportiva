package co.edu.uptc.model;

import java.util.List;

public class Affiliated {
    private String id;
    private String name;
    private String lastName;
    private String dni;
    private Integer age;
    private Event event;

    public Affiliated(String name, String lastName, String dni, Integer age, Event event) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.age = age;
        this.event = event;
    }

    public Affiliated(String name, String lastName, String dni, Integer age) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Affiliated{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", age=" + age +
                ", event=" + event +
                '}';
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

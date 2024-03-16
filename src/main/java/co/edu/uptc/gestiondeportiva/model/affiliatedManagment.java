package co.edu.uptc.GestionDeportiva.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "affiliated")
public class AffiliatedManagment {
    @Id
    private String _id;
    private String name;
    private String lastName;
    private String dni;
    private Integer age;

    public AffiliatedManagment() {
    }

    public AffiliatedManagment(String name, String lastName, String dni, Integer age) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.age = age;
    }

    public AffiliatedManagment(String _id, String name, String lastName, String dni, Integer age) {
        this._id = _id;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.age = age;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    @Override
    public String toString() {
        return "affiliatedManagment{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", age=" + age +
                '}';
    }
}

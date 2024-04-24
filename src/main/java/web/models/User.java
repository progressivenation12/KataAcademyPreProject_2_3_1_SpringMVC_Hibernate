package web.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Field not be empty!")
    @Size(min = 2, max = 25, message = "Firstname should be between 2 and 25 char!")
    @Column(name = "firstName")
    private String firstName;
    @NotEmpty(message = "Field not be empty!")
    @Size(min = 2, max = 25, message = "Firstname should be between 2 and 25 char!")
    @Column(name = "lastName")
    private String lastName;

    @NotNull(message = "Field not be empty!")
    @Min(value = 0, message = "The age must not be less than 0!")
    @Max(value = 150, message = "The age should not be more than 155!")
    @Column(name = "age")
    private int age;
    @NotEmpty(message = "Field not be empty!")
    @Email(message = "Email should be valid!")
    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(int id, String firstName, String lastName, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package net.guides.springboot2.crud.domain;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private String role;
    private Date employedOn;


    //CONSTRUCTORS
    public Employee() {
    }

    public Employee(String name, String email, String role, Date employedOn) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.employedOn = employedOn;
    }

    //SETTERS AND GETTERS
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        id = id;
    }

    @Column(name = "Name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Email", nullable = false)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "Role", nullable = false)
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "employedOn", nullable = false)
    public Date getEmployedOn() {
        return employedOn;
    }
    public void setEmployedOn(Date employedOn) {
        this.employedOn = employedOn;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", employedOn=" + employedOn +
                '}';
    }
}

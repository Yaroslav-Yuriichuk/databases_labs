package com.yuriichuk.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Technician {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String workEntryDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "work_entry_date")
    public String getWorkEntryDate() {
        return workEntryDate;
    }

    public void setWorkEntryDate(String workEntryDate) {
        this.workEntryDate = workEntryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Technician that = (Technician) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(age, that.age) && Objects.equals(workEntryDate, that.workEntryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, workEntryDate);
    }

    public Technician() {}

    public Technician(String firstName, String lastName, Integer age, String workEntryDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.workEntryDate = workEntryDate;
    }

    @Override
    public String toString() {
        return "Technician {" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", workEntryDate='" + workEntryDate + '\'' +
                '}';
    }
}

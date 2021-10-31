package com.yuriichuk.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Technician {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String workEntryDate;

    public Technician(Integer id, String firstName, String lastName, Integer age, String workEntryDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.workEntryDate = workEntryDate;
    }

    public Technician(String firstName, String lastName, Integer age, String workEntryDate) {
        this(null, firstName, lastName, age, workEntryDate);
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

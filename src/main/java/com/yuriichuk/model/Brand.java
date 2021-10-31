package com.yuriichuk.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Brand {
    private Integer id;
    private String name;
    private String date;

    public Brand(Integer id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Brand(String name, String date) {
        this(null, name, date);
    }

    @Override
    public String toString() {
        return "Brand {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

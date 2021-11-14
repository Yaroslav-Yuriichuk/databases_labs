package com.yuriichuk.Lab6.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TechnicianDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String workEntryDate;
}

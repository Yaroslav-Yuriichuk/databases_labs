package com.yuriichuk.Lab6.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SnackDTO {
    private Integer id;
    private String name;
    private Float price;
    private Integer weight;
    private Integer callories;
    private Integer brandId;
}

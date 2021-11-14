package com.yuriichuk.Lab6.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddressDTO {
    private Integer id;
    private String region;
    private String cityVillage;
    private String street;
    private String building;
}

package ru.enovikow.devops.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonDto {
    private String name;
    private String surname;
    private int age;
    private String address;
}

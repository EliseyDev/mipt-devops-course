package ru.enovikow.devops.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Person {
    private long id;
    private String name;
    private String surname;
    private int age;
    private String address;
}

package ru.enovikow.devops.constant;

import lombok.Getter;
import ru.enovikow.devops.model.Person;

import java.util.ArrayList;
import java.util.List;

public class DBMock {
    public static final List<Person> persons;

    static {
        persons = new ArrayList<>();

        persons.add(Person.builder()
                .id(1)
                .name("Елисей")
                .surname("Новиков")
                .age(36)
                .address("Москва, Красная Площадь 1")
                .build());

        persons.add(Person.builder()
                .id(2)
                .name("Bjarne")
                .surname("Stroustrup")
                .age(71)
                .address("US")
                .build());

        persons.add(Person.builder()
                .id(3)
                .name("Donald")
                .surname("Knuth")
                .age(84)
                .address("US")
                .build());

        persons.add(Person.builder()
                .id(4)
                .name("Linus")
                .surname("Torvalds")
                .age(52)
                .address("Finland")
                .build());
    }
}

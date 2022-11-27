package ru.enovikow.devops.constant;

import org.springframework.stereotype.Component;
import ru.enovikow.devops.model.Person;

import java.util.Arrays;
import java.util.List;

@Component
public class DBMock {

    private final List<Person> persons;

    public DBMock() {
        persons = buildPersons();
    }

    public List<Person> getPersons() {
        return persons;
    }

    private List<Person> buildPersons() {
        return Arrays.asList(
                Person.builder()
                        .id(1)
                        .name("Елисей")
                        .surname("Новиков")
                        .age(36)
                        .address("Москва, Красная Площадь 1")
                        .build(),

                Person.builder()
                        .id(2)
                        .name("Bjarne")
                        .surname("Stroustrup")
                        .age(71)
                        .address("US")
                        .build(),

                Person.builder()
                        .id(3)
                        .name("Donald")
                        .surname("Knuth")
                        .age(84)
                        .address("US")
                        .build(),

                Person.builder()
                        .id(4)
                        .name("Linus")
                        .surname("Torvalds")
                        .age(52)
                        .address("Finland")
                        .build());
    }

}

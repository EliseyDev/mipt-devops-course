package ru.enovikow.devops.repository;

import ru.enovikow.devops.model.Person;

import java.util.List;

public interface PersonRepository {
    Person findPersonById(long id);

    List<Person> findAllPersons();
}

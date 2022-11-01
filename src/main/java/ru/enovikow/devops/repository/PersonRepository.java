package ru.enovikow.devops.repository;

import ru.enovikow.devops.model.Person;

public interface PersonRepository {
    Person findPersonById(long id);
}

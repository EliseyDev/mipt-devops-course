package ru.enovikow.devops.repository.impl;

import org.springframework.stereotype.Repository;
import ru.enovikow.devops.constant.DBMock;
import ru.enovikow.devops.model.Person;
import ru.enovikow.devops.repository.PersonRepository;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Override
    public Person findPersonById(long id) {
        return DBMock.persons.stream().filter(person -> id == person.getId()).findFirst().orElse(null);
    }
}

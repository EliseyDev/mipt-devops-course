package ru.enovikow.devops.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.enovikow.devops.constant.DBMock;
import ru.enovikow.devops.model.Person;
import ru.enovikow.devops.repository.PersonRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {

    private final DBMock dbMock;

    @Override
    public Person findPersonById(long id) {
        return dbMock.getPersons().stream().filter(person -> id == person.getId()).findFirst().orElse(null);
    }

    @Override
    public List<Person> findAllPersons() {
        return dbMock.getPersons();
    }
}

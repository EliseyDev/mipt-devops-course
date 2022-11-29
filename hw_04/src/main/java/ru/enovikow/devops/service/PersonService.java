package ru.enovikow.devops.service;

import ru.enovikow.devops.dto.PersonDto;

import java.util.List;

public interface PersonService {
    PersonDto getPersonById(long id);

    List<PersonDto> getAllPersons();
}

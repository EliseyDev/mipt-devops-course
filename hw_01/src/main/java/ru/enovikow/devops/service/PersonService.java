package ru.enovikow.devops.service;

import ru.enovikow.devops.dto.PersonDto;

public interface PersonService {
    PersonDto getPersonById(long id);
}

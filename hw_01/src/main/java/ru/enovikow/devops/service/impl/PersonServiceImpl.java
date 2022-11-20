package ru.enovikow.devops.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.enovikow.devops.dto.PersonDto;
import ru.enovikow.devops.mapper.Mapper;
import ru.enovikow.devops.model.Person;
import ru.enovikow.devops.repository.PersonRepository;
import ru.enovikow.devops.service.PersonService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final Mapper<PersonDto, Person> mapper;

    @Override
    public PersonDto getPersonById(long id) {
        return Optional.ofNullable(personRepository.findPersonById(id)).map(mapper::toDto).orElse(null);
    }


}

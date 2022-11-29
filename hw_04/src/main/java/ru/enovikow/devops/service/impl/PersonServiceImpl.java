package ru.enovikow.devops.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.enovikow.devops.dto.PersonDto;
import ru.enovikow.devops.mapper.ModelMapper;
import ru.enovikow.devops.model.Person;
import ru.enovikow.devops.repository.PersonRepository;
import ru.enovikow.devops.service.PersonService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper<PersonDto, Person> modelMapper;

    @Override
    public PersonDto getPersonById(long id) {
        return Optional.ofNullable(personRepository.findPersonById(id)).map(modelMapper::toDto).orElse(null);
    }

    @Override
    public List<PersonDto> getAllPersons() {
        return personRepository.findAllPersons().stream().map(modelMapper::toDto).collect(Collectors.toList());
    }


}

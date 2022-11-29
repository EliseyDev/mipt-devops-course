package ru.enovikow.devops.mapper;

import org.springframework.stereotype.Component;
import ru.enovikow.devops.dto.PersonDto;
import ru.enovikow.devops.model.Person;

@Component
public class PersonModelMapper implements ModelMapper<PersonDto, Person> {
    @Override
    public PersonDto toDto(Person model) {
        return PersonDto.builder()
                .name(model.getName())
                .surname(model.getSurname())
                .age(model.getAge())
                .address(model.getAddress())
                .build();
    }
}

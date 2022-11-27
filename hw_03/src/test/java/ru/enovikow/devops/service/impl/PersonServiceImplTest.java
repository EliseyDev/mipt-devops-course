package ru.enovikow.devops.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import ru.enovikow.devops.constant.DBMock;
import ru.enovikow.devops.dto.PersonDto;
import ru.enovikow.devops.mapper.ModelMapper;
import ru.enovikow.devops.mapper.PersonModelMapper;
import ru.enovikow.devops.model.Person;
import ru.enovikow.devops.service.PersonService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class PersonServiceImplTest {

    private final PersonService service = Mockito.mock(PersonServiceImpl.class);
    private ModelMapper<PersonDto, Person> mapper;
    private DBMock dbMock;

    @BeforeEach
    void init() {
        mapper = new PersonModelMapper();
        dbMock = new DBMock();
    }

    static Stream<Arguments> personIds() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(2),
                Arguments.of(3)
        );
    }

    @ParameterizedTest
    @MethodSource("personIds")
    void person_always_correct(Integer id) {
        Mockito.when(service.getPersonById(id)).thenReturn(getPersonDto(id));
        PersonDto dto = service.getPersonById(id);

        Assertions.assertThat(dto).isEqualTo(getPersonDto(id));
    }

    @Test
    void persons_always_returnsAll() {
        Mockito.when(service.getAllPersons()).thenReturn(getAllPersons());

        List<PersonDto> allPersons = service.getAllPersons();
        org.junit.jupiter.api.Assertions.assertEquals(4, allPersons.size());
    }

    private PersonDto getPersonDto(Integer id) {
        Person person = dbMock.getPersons().stream().filter(p -> p.getId() == id).findFirst().orElse(null);

        return mapper.toDto(person);
    }

    private List<PersonDto> getAllPersons() {
        return dbMock.getPersons().stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
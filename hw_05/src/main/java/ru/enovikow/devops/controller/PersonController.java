package ru.enovikow.devops.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.enovikow.devops.dto.PersonDto;
import ru.enovikow.devops.service.PersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping(value = "/with-id")
    public PersonDto getPersonById(@RequestParam long id) {
        return personService.getPersonById(id);
    }

    @GetMapping(value = "/all")
    public List<PersonDto> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping
    public String healthCheck() {
        return "OK";
    }
}

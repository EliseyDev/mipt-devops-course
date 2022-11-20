package ru.enovikow.devops.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.enovikow.devops.dto.PersonDto;
import ru.enovikow.devops.service.PersonService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping(value = "/with-id")
    public PersonDto getPersonById(@RequestParam long id) {
        PersonDto personById = personService.getPersonById(id);
        return personService.getPersonById(id);
    }

    @GetMapping
    public String healthCheck() {
        return "OK";
    }
}

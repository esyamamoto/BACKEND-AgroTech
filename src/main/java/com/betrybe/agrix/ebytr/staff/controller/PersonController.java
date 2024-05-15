package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.PersonDto;
import com.betrybe.agrix.ebytr.staff.dto.PersonDtoCreation;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * instanciando a new Person controller.
 */
@RestController
@RequestMapping(value = "/persons")
public class PersonController {
  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * criar pessoa.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PersonDto crearPerson(@RequestBody PersonDtoCreation personDtoCreation) {
    return PersonDto.fromEntity(personService.create(personDtoCreation.toEntity()));
    // relembrando: Converte o DTO de criação em uma entidade Person
    // salva a entidade através do serviço
    // converte a entidade salva de volta em um DTO de resposta.
  }
}

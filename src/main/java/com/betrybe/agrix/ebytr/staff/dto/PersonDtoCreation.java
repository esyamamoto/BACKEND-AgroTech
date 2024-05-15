package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * PersonDtoCreation.
 */
public record PersonDtoCreation(String username, String password, Role role) {
  /**
   * entity person.
   */
  public Person toEntity() {
    return new Person(username, password, role);
  }
}

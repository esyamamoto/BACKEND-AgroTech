package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Farm;

/**
 * FarmDtoCreation.
 */
public record FarmDtoCreation(String name, Double size) {
  public Farm toEntity() {
    return new Farm(name, size);
  }
}

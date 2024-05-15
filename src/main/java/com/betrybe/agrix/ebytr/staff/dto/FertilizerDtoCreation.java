package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;

/**
 * FertilizerDtoCreation.
 */
public record FertilizerDtoCreation(
    String name,
    String brand,
    String composition
) {
  /**
   * Fertilizer.
   */
  public Fertilizer toEntity() {
    return new Fertilizer(name, brand, composition);
  }
}

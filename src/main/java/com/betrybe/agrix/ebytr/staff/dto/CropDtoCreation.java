package com.betrybe.agrix.ebytr.staff.dto;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import java.time.LocalDate;

/**
 * CropDtoCreation.
 */

public record CropDtoCreation(
    String name,
    Double plantedArea,
    LocalDate plantedDate,
    LocalDate harvestDate
) {
  public Crop toEntity() {
    return new Crop(name, plantedArea, plantedDate, harvestDate);
  }
}

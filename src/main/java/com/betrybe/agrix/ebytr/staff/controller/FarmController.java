package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.dto.CropDtoCreation;
import com.betrybe.agrix.ebytr.staff.dto.FarmDto;
import com.betrybe.agrix.ebytr.staff.dto.FarmDtoCreation;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFound;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import com.betrybe.agrix.ebytr.staff.service.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * FarmController.
 */
@RestController
@RequestMapping(value = "/farms")
public class FarmController {

  private final FarmService farmService;
  private final CropService cropService;

  @Autowired
  public FarmController(FarmService farmservice, CropService cropService) {
    this.farmService = farmservice;
    this.cropService = cropService;
  }

  /**
   * nova farm.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FarmDto createFarm(@RequestBody FarmDtoCreation farmDtoCreation) {
    Farm farm = farmDtoCreation.toEntity();
    return FarmDto.fromEntity(
        farmService.create(farm)
    );
  }

  /**
   * get all.
   */
  @GetMapping
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')"
      + " or hasAuthority('ROLE_MANAGER') or hasAuthority('ROLE_USER')")
  public List<FarmDto> getlAllFarms() {
    List<Farm> allFarms = farmService.findAll();
    return allFarms.stream()
        .map(FarmDto::fromEntity)
        .toList();
  }

  /**
   * geById.
   */
  @GetMapping("/{id}")
  public FarmDto getById(@PathVariable long id) throws FarmNotFound {
    return FarmDto.fromEntity(
        farmService.findById(id)
    );
  }

  /**
   * creat farm.
   */
  @PostMapping(value = "/{farmId}/crops")
  @ResponseStatus(HttpStatus.CREATED)
  public CropDto createdCrop(@PathVariable long farmId,
                             @RequestBody CropDtoCreation cropDtoCreation) throws FarmNotFound {
    return CropDto.fromEntity(cropService
        .create(farmId, cropDtoCreation.toEntity()));
  }

  /**
   * getCropsById.
   */
  @GetMapping(value = "/{farmId}/crops")
  public List<CropDto> getCropsById(@PathVariable Long farmId) throws FarmNotFound {
    List<Crop> cropFarmId = farmService.findById(farmId).getCrops();

    return cropFarmId.stream()
        .map(CropDto::fromEntity)
        .toList();
  }
}

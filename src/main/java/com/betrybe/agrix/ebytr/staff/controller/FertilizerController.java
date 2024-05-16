package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.FertilizerDto;
import com.betrybe.agrix.ebytr.staff.dto.FertilizerDtoCreation;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFound;
import com.betrybe.agrix.ebytr.staff.service.FertilizerService;
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
 *  RestController.
 */
@RestController
@RequestMapping("/fertilizers")

public class FertilizerController {
  private final FertilizerService fertilizerService;

  @Autowired
  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  /**
   * POST.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FertilizerDto create(@RequestBody FertilizerDtoCreation fertilizerDtoCreation) {
    return FertilizerDto.fromEntity(
        fertilizerService.create(fertilizerDtoCreation.toEntity())
    );
  }

  /**
   * GETALL.
   */
  @GetMapping
  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  public List<FertilizerDto> getAllCrops() {
    List<Fertilizer> allCrops = fertilizerService.findAll();
    return allCrops.stream()
        .map(FertilizerDto::fromEntity)
        .toList();
  }

  /**
   * ID.
   */
  @GetMapping(value = "{id}")
  public FertilizerDto getCropId(@PathVariable Long id)
      throws FertilizerNotFound {
    return FertilizerDto.fromEntity(
      fertilizerService.findById(id)
     );
  }
}

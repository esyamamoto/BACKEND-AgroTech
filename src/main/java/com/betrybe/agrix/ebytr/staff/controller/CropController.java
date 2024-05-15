package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.dto.CropDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.exception.CropNotFound;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFound;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * CropsController.
 */
@RestController
@RequestMapping(value = "/crops")
public class CropController {

  private final CropService cropService;

  @Autowired
  public CropController(
      CropService cropService
  ) {
    this.cropService = cropService;
  }

  /**
   * get all.
   */
  @GetMapping
  public List<CropDto> getlAllCrops() {
    List<Crop> allCrops = cropService.findAll();
    return allCrops.stream()
        .map(CropDto::fromEntity)
        .toList();
  }

  /**
   * geById.
   */
  @GetMapping("/{id}")
  public CropDto getById(@PathVariable long id) throws CropNotFound {
    return CropDto.fromEntity(
        cropService.findById(id)
    );
  }

  /**
   * search.
   */
  @GetMapping("/search")
  public List<CropDto> cropsByHarvestDate(
      @RequestParam LocalDate start, @RequestParam LocalDate end) {
    List<Crop> all = cropService.searchCropsService(start, end);
    return all.stream()
        .map(CropDto::fromEntity)
        .toList();
  }

  /**
   * associar uma plantação com um fertilizante.
   */
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> cropsAndFertilizer(@PathVariable long cropId,
                                                   @PathVariable long fertilizerId)
      throws FertilizerNotFound, CropNotFound {

    cropService.cropsAndFertilizer(cropId, fertilizerId);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body("Fertilizante e plantação associados com sucesso!");
  }
}



package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.CropNotFound;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFound;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFound;
import com.betrybe.agrix.ebytr.staff.repository.CropRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CropService.
 */

@Service
public class CropService {
  private final CropRepository cropRepository;
  private final FarmService farmService;
  private final FertilizerService fertilizerService;

  /**
   * CropService.
   */
  @Autowired
  public CropService(
      CropRepository cropRepository,
      FarmService farmService,
      FertilizerService fertilizerService
  ) {
    this.cropRepository = cropRepository;
    this.farmService = farmService;
    this.fertilizerService = fertilizerService;
  }

  /**
   * crop create, findall e findById.
   */

  public Crop create(long getId, Crop crop) throws FarmNotFound {
    Farm newFarm = farmService.findById(getId);
    crop.setFarm(newFarm);

    return cropRepository.save(crop);
  }

  public List<Crop> findAll() {
    return cropRepository.findAll();
  }

  public Crop findById(long id) throws CropNotFound {
    return cropRepository.findById(id)
        .orElseThrow(CropNotFound::new);
  }

  /**
   * searchCropsService.
   */
  public List<Crop> searchCropsService(LocalDate start, LocalDate end) {
    List<Crop> all = cropRepository.findAllByHarvestDateBetween(start, end);

    return all.stream().toList();
  }

  /**
   *  associar uma plantação com um fertilizante - crop controller.
   */
  public void cropsAndFertilizer(long cropId, long fertilizerId)
      throws CropNotFound, FertilizerNotFound {

    Crop crop = cropRepository.findById(cropId).orElseThrow(CropNotFound::new);
    Fertilizer fertilizer = fertilizerService.findById(fertilizerId);

    crop.getFertilizers().add(fertilizer);
    cropRepository.save(crop);
  }
}

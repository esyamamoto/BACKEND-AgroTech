package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFound;
import com.betrybe.agrix.ebytr.staff.repository.FarmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FarmService.
 */

@Service
public class FarmService {
  private final FarmRepository farmRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  /**
   * create farm.
   */
  public Farm create(Farm farm) {
    return farmRepository.save(farm);
  }

  /**
   * findAll farms.
   */
  public List<Farm> findAll() {
    return farmRepository.findAll();
  }

  /**
   * findById.
   */
  public Farm findById(long id) throws FarmNotFound {
    return farmRepository.findById(id)
        .orElseThrow(FarmNotFound::new);
  }
}
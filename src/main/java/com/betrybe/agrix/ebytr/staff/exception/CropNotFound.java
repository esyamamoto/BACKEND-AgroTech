package com.betrybe.agrix.ebytr.staff.exception;

/**
 * CropNotFound.
 */
public class CropNotFound extends NotFoundExpection {
  public CropNotFound() {
    super("Plantação não encontrada!");
  }
}

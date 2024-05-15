package com.betrybe.agrix.ebytr.staff.exception;

/**
 * FarmNotFound - esse vai pro farm controller.
 */
public class FarmNotFound extends NotFoundExpection {
  public FarmNotFound() {
    super("Fazenda não encontrada!");
  }
}

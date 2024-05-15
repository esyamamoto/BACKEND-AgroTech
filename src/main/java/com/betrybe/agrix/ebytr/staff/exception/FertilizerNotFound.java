package com.betrybe.agrix.ebytr.staff.exception;

/**
 * FertilizerNotFoun = via no dcontroller.
 */
public class FertilizerNotFound extends NotFoundExpection {
  public FertilizerNotFound() {
    super("Fertilizante não encontrado!");
  }
}

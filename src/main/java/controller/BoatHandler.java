package controller;

import model.Boat;
import model.BoatType;

/** 
 * Responsible for boat operations.
 */
public class BoatHandler {

  public BoatHandler() {

  }

  /**
   * Creates a new object of type Boat and returns it.

   * @param type The type of the boat that is created.
   * @param length The length of the boat that is created.
   * @return Boat
   */
  public Boat createBoat(BoatType type, int length) {
    return new Boat(length, type);
  }
}

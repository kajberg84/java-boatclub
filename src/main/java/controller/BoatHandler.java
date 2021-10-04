package controller;

import model.Boat;

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
  public Boat createBoat(int type, int length) {
    String boatType = convertToString(type);
    return new Boat(length, boatType);
  }

  /**
   * Returns a type of boat as a string.

   * @param type Integer-coded type of boat.
   * @return String
   */
  private String convertToString(int type) {
    switch (type) {
      case 1:
        return "sailboat";
      case 2:
        return "motorsailer";
      case 3:
        return "kayak/canoe";
      default:
        return "other";
    }
  }
}

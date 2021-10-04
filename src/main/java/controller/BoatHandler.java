package controller;

import model.Boat;

public class BoatHandler {

  public BoatHandler() {

  }

  /**
   * @param type
   * @param length
   * @return Boat
   */
  public Boat createBoat(int type, int length) {
    String boatType = convertToString(type);
    return new Boat(length, boatType);
  }

  

  /**
   * @param type
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

package controller;

import model.Boat;

public class BoatHandler {

  public BoatHandler() {

  }

  public Boat createBoat(int length, int type) {
    String boatType = convertToString(type);
    return new Boat(length, boatType);
  }

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

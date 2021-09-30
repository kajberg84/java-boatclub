package model;

// import model.BoatType;
// import model.BoatType.Type;

public class Boat {
  private int length;
  // private BoatType type;
  private String type;

  public Boat(String type, int length) {
    this.length = length;
    this.type = type;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int value) {
    this.length = value;
  }

  public String getBoatType() {
    return type;
  }

  public void setBoatType(String value) {
    this.type = value;
  }
  // private BoatType convertEnumToString(BoatType boattype) {
  // // return boattype;
  // switch (boattype) {
  // case SAILBOAT:
  // return boattype;
  // break;

  // default:
  // break;
  // }
  // return boattype;
  // }
}

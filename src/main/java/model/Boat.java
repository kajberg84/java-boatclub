package model;

// import model.BoatType;
// import model.BoatType.Type;

public class Boat {
  private int length;
  private String type;
  // private BoatType type;

  public Boat(int length, String type) {
    this.length = length;
    this.type = type;
  }

  /**
   * @return int
   */
  public int getLength() {
    return length;
  }

  /**
   * @param value
   */
  public void setLength(int value) {
    this.length = value;
  }

  /**
   * @return String
   */
  public String getBoatType() {
    return type;
  }

  /**
   * @param value
   */
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

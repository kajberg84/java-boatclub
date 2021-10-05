package model;

public enum BoatType {
  SAILBOAT("sailboat"), 
  MOTORSAILER("motorsailer"), 
  KAYAKCANOE("kayak/canoe"), 
  OTHER("other");

  public final String label;

  private BoatType(String label) {
    this.label = label;
  }

  /* public BoatType(int input) {
    this.input = input;
  } */

  /**
   * @return Type
   */
  /* public Type getBoatType() {
    switch (input) {
      case 1:
        return Type.SAILBOAT;
      case 2:
        return Type.MOTORSAILER;
      case 3:
        return Type.KAYAKCANOE;
      case 4:
        return Type.OTHER;
      default:
        break;
    }
    return Type.None;
  } */

}

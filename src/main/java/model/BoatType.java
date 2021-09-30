package model;

public class BoatType {

  private int input;

  public enum Type {
    SAILBOAT, MOTORSAILER, KAYAKCANOE, OTHER, None;
  }

  public BoatType(int input) {
    this.input = input;
  }

  public Type getBoatType() {
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
  }

}

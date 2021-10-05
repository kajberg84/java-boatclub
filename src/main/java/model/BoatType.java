package model;

/** 
 * Enumeration for boat type.
 */
public enum BoatType {
  SAILBOAT("sailboat"), 
  MOTORSAILER("motorsailer"), 
  KAYAKCANOE("kayak/canoe"), 
  OTHER("other");

  public final String label;

  private BoatType(String label) {
    this.label = label;
  }
}

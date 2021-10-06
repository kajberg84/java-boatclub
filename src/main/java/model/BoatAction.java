package model;

/** 
 * Actions to choose from in the boats sub menu.
 */
public enum BoatAction {
  ADD("Register new boat"), 
  EDIT("Edit boat"), 
  DELETE("Delete boat"), 
  BACK("Go back");
  public final String label;

  private BoatAction(String label) {
    this.label = label;
  }
}

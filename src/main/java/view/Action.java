package view;

/**
 * Actions to choose from in the main menu.
 */
public enum Action {
  MEMBERS("Handle members"),
  BOATS("Handle boats"),
  EXIT("Exit");

  public final String label;

  private Action(String label) {
    this.label = label;
  }
}

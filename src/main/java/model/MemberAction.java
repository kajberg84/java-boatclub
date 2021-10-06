package model;

/** 
 * Actions to choose from in the members sub menu.
 */
public enum MemberAction {
  ADD("Register new member"),
  EDIT("Edit member details"),
  VIEWALL("View all members"),
  VIEWONE("View one member"),
  DELETE("Delete a member"),
  BACK("Go back");
  public final String label;

  private MemberAction(String label) {
    this.label = label;
  }
}

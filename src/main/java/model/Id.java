package model;

/** 
 * A class representing an ID.
 */
public class Id {
  private String id;

  /**
   * An ID object.

   * @param id An alphanumeric string.
   */
  public Id(String id) {
    this.id = id;
  }

  /**
   * Gets the ID.

   * @return String
   */
  public String getId() {
    return this.id;
  }
}

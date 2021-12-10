package model;

/** 
 * A class representing a boat.
 */
public class Boat {
  private int length;
  private BoatType type;
  private Authentication authentication;

  public Boat() {
    super();
  }

  /**
   * A boat object.

   * @param length The length of the boat.
   * @param type The type of the boat.
   */
  public Boat(int length, BoatType type, Authentication authentication) {
    this.length = length;
    this.type = type;
    this.authentication = authentication;
  }

  /**
   * Gets the length of the boat.

   * @return int
   */
  public int getLength() {
    return length;
  }

  /**
   * Sets the length of the boat to an integer.

   * @param value An integer.
   */
  public void setLength(int value) {
    try {
      if (authentication.isAuthenticated()) {
        this.length = value;
      } else {
        throw new Exception("Unauthorized");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets the type of the boat.

   * @return BoatType
   */
  public BoatType getBoatType() {
    return type;
  }

  /**
   * Sets the type of the boat.

   * @param value A string.
   */
  public void setBoatType(BoatType value) {
    this.type = value;
  }
}

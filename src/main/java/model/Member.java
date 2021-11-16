package model;

import java.util.ArrayList;

/** 
 * A class representing a member.
 */
public class Member {
  private String name;
  private String socialSecurityNumber;
  private Id id;
  private ArrayList<Boat> boats;
  private Authentication authentication; 

  public Member() {
    super();
  }

  /**
   * A member object.

   * @param name The name of the member.
   * @param socialSecurityNumber The social security number of the member.
   * @param id The ID of the member.
   * @param authentication The authentication object.
   */
  public Member(String name, String socialSecurityNumber, Id id, Authentication authentication) {
    this.name = name;
    this.socialSecurityNumber = socialSecurityNumber;
    this.id = id;
    this.boats = new ArrayList<>();
    this.authentication = authentication;
  }

  /**
   * Gets a member's name.

   * @return String
   */
  public String getName() {
    return name;
  }

  /**
   * Sets a member's name.

   * @param value The member's new name.
   */
  public void setName(String value) {
    try {
      if (authentication.isAuthenticated()) {
        this.name = value;
      } else {
        throw new Exception("Unauthorized");
      }
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }

  /**
   * Gets a member's social security number.

   * @return String
   */
  public String getSocialSecurityNumber() {
    return socialSecurityNumber;
  }

  /**
   * Sets a member's social security number.

   * @param value The new social security number.
   */
  public void setSocialSecurityNumber(String value) {
    this.socialSecurityNumber = value;
  }

  /**
   * Gets a member's ID.

   * @return String
   */
  public String getId() {
    return id.getId();
  }

  /**
   * Returns an Iterable of all boats registered to a member.

   * @return Iterable of boat objects.
   */
  public Iterable<Boat> getBoats() {
    return this.boats;
  }

  public int getNumberOfBoats() {
    return this.boats.size();
  }

  /**
   * Adds a boat to the member.

   * @param type The type of the new boat.
   * @param length The length of the new boat.
   */
  public void addBoat(BoatType type, int length) {
    try {
      if (authentication.isAuthenticated()) {
        this.boats.add(new Boat(length, type, authentication));
      } else {
        throw new Exception("Unauthorized");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void deleteBoat(Boat boat) {
    this.boats.remove(boat);
  }
}

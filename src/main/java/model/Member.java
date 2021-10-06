package model;

import java.util.ArrayList;

/** 
 * A class representing a member.
 */
public class Member {
  private String name;
  private String socialSecurityNumber;
  private Id memberId;
  private ArrayList<Boat> boats; 

  /**
   * A member object.

   * @param name The name of the member.
   * @param socialSecurityNumber The social security number of the member.
   * @param memberId The ID of the member.
   */
  public Member(String name, String socialSecurityNumber, Id memberId) {
    this.name = name;
    this.socialSecurityNumber = socialSecurityNumber;
    this.memberId = memberId;
    this.boats = new ArrayList<>();
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
    this.name = value;
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
    return memberId.getId();
  }

  /**
   * Returns an ArrayList of all boats registered to a member.

   * @return ArrayList
   */
  public ArrayList<Boat> getBoats() {
    ArrayList<Boat> boatsCopy = this.boats;
    return boatsCopy;
  }

  /**
   * Sets all boats registered to a member.

   * @param value An ArrayList of boat objects.
   */
  public void setBoats(ArrayList<Boat> value) {
    this.boats = value;
  }
}

package model;

import java.util.ArrayList;

public class Member {
  private String name;
  private String socialSecurityNumber;
  private Id memberId;
  private ArrayList<Boat> boats; 

  public Member(String name, String socialSecurityNumber, Id memberId) {
    this.name = name;
    this.socialSecurityNumber = socialSecurityNumber;
    this.memberId = memberId;
    this.boats = new ArrayList<>();
  }

  /**
   * Getname.
   * 
   * @return String
   */
  public String getName() {
    return name;
  }

  /**
   * @param value
   */
  public void setName(String value) {
    this.name = value;
  }

  /**
   * @return String
   */
  public String getSocialSecurityNumber() {
    return socialSecurityNumber;
  }

  /**
   * @param value
   */
  public void setSocialSecurityNumber(String value) {
    this.socialSecurityNumber = value;
  }

  /**
   * @return String
   */
  public String getId() {
    return memberId.getId();
  }

  /**
   * @return ArrayList<Boat>
   */
  public ArrayList<Boat> getBoats() {
    return this.boats;
  }

  /**
   * @param value 
   */
  public void setBoats(ArrayList<Boat> value) {
    this.boats = value;
  }
}

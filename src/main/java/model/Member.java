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

  public String getName() {
    return name;
  }

  public void setName(String value) {
    this.name = value;
  }

  public String getSocialSecurityNumber() {
    return socialSecurityNumber;
  }

  public void setSocialSecurityNumber(String value) {
    this.socialSecurityNumber = value;
  }

  public String getId() {
    return memberId.getId();
  }

  public ArrayList<Boat> getBoats() {
    return this.boats;
  }
}

package model;

public class Member {
  private String name;
  private int socialSecurityNumber;
  private Id memberId;

  public Member(String name, int socialSecurityNumber, Id memberId) {
    this.name = name;
    this.socialSecurityNumber = socialSecurityNumber;
    this.memberId = memberId;
  }

  public String getName() {
    return name;
  }

  public void setName(String value) {
    this.name = value;
  }

  public int getSocialSecurityNumber() {
    return socialSecurityNumber;
  }

  public void setSocialSecurityNumber(int value) {
    this.socialSecurityNumber = value;
  }

  public Id getId() {
    return memberId;
  }
}

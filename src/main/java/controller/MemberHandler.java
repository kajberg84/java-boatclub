package controller;

import java.util.ArrayList;
import model.Boat;
import model.BoatType;
import model.Member;
import model.MemberRegistry;

/** 
 * Responsible for member operations.
 */
public class MemberHandler {
  private MemberRegistry registry = new MemberRegistry();

  /**
   * Creates a new member.

   * @param name The name of the new member.
   * @param socialSecurityNumber The social security number of the new member.
   */
  public void createMember(String name, String socialSecurityNumber) {
    registry.addMember(name, socialSecurityNumber);
  }

  /**
   * Returns a member by member ID.

   * @param memberId The ID of the member to get.
   * @return Member
   */
  public Member getMember(String memberId) {
    return registry.getMemberById(memberId);
  }

  /**
   * Returns all members.

   * @return ArrayList
   */
  public ArrayList<Member> getAllMembers() {
    return registry.getAllMembers();
  }

  /**
   * Registers a new boat to a member.

   * @param memberId The ID of the member to register the boat to.
   * @param boat The boat to register.
   */
  public void addNewBoat(String memberId, Boat boat) {
    Member memberToUpdate = getMember(memberId);
    ArrayList<Boat> boatsToUpdate = memberToUpdate.getBoats();
    boatsToUpdate.add(boat);
    memberToUpdate.setBoats(boatsToUpdate);
  }

  /** 
   * Deletes a boat from a member.

   * @param member The member to delete the boat from.
   * @param boatIndex The index of the boat to delete.
   */
  public void deleteBoat(Member member, int boatIndex) {
    ArrayList<Boat> boatsToUpdate = member.getBoats();
    boatsToUpdate.remove(boatIndex);
    member.setBoats(boatsToUpdate);
  }

  /**
   * Deletes a member.

   * @param member The member to delete.
   */
  public void deleteMember(Member member) {
    registry.deleteMember(member);
  }

  /**
   * Edits a member's name.

   * @param member The member to edit.
   * @param name The new name of the member.
   */
  public void editName(Member member, String name) {
    member.setName(name);
  }

  /**
   * Edits a member's social security number.

   * @param member The member to edit.
   * @param number The new social security number of the member.
   */
  public void editSocialSecurityNumber(Member member, String number) {
    member.setSocialSecurityNumber(number);
  }

  /**
   * Edits a boat's type.

   * @param member The member owning the boat to edit.
   * @param boatIndex The index of the boat to edit.
   * @param type The new type of the boat.
   */
  public void editBoatType(Member member, int boatIndex, BoatType type) {
    ArrayList<Boat> boats = member.getBoats();
    Boat boatToEdit = boats.get(boatIndex);
    boatToEdit.setBoatType(type);
  }

  /**
   * Edits a boat's length.

   * @param member The member owning the boat to edit.
   * @param boatIndex The index of the boat to edit.
   * @param length The new length of the boat.
   */
  public void editBoatLength(Member member, int boatIndex, int length) {
    ArrayList<Boat> boats = member.getBoats();
    Boat boatToEdit = boats.get(boatIndex);
    boatToEdit.setLength(length);
  }
}

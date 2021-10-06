package controller;

import java.util.ArrayList;
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
}

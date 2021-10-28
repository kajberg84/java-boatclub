package model;

import java.util.ArrayList;
import java.util.Random;

/** 
 * Responsible for member registry operations.
 */
public class MemberRegistry {
  private ArrayList<Member> members = new ArrayList<>();
  
  public MemberRegistry() {
  }

  /**
   * Returns all members.

   * @return ArrayList
   */
  public ArrayList<Member> getAllMembers() {
    ArrayList<Member> membersCopy = members;
    return membersCopy;
  }
  
  /**
  * Adds a new member to the registry.

  * @param name The name of the new member.
  * @param socialSecurityNumber The social security number of the new member.
  */
  public void createMemberWithId(String name, String socialSecurityNumber) {
    Id memberId = generateUniqueId();
    Member newMember = new Member(name, socialSecurityNumber, memberId);
    addMemberToRegistry(newMember);
  }

  public void addMemberToRegistry(Member member) {
    members.add(member);
  }

  /**
   * Gets a member by member ID.

   * @param memberId The ID of the member to get.
   * @return Member
   */
  public Member getMemberById(String memberId) {
    Member m = null;
    for (Member member : members) {
      if (member.getId().equals(memberId)) {
        m = member;
      }
    }
    return m;
  }

  private Id generateUniqueId() {
    StringBuilder builder = new StringBuilder();
    Random random = new Random();

    String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerCase = upperCase.toLowerCase();
    String digits = "1234567890";
    String allChars = upperCase + lowerCase + digits;
    Id newId;

    do {
      int length = getRandomNumber();
      for (int i = 0; i < length; i++) {
        builder.append(allChars.charAt(random.nextInt(allChars.length())));
      }
      newId = new Id(builder.toString());
    } while (!isUniqueId(newId));
    return newId;
  }

  private int getRandomNumber() {
    Random randomNumber = new Random();
    return randomNumber.nextInt(6) + 1;
  }

  private boolean isUniqueId(Id id) {
    for (Member m : members) {
      if (m.getId().equals(id.toString())) {
        return false;
      }
    }
    return true;
  }

  /**
   * Deletes a member.

   * @param member The member to delete.
   */
  public void deleteMember(Member member) {
    members.remove(member);
  }
}

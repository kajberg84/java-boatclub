package controller;

import java.util.ArrayList;
import model.Member;

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
    return members;
  }
  
  /**
   * Adds a new member to the registry.

   * @param newMember The new member to add.
   */
  public void addMember(Member newMember) {
    members.add(newMember);
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
}

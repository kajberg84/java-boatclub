package controller;

import java.util.ArrayList;
import model.Member;

public class MemberRegistry {
  private ArrayList<Member> members = new ArrayList<>();
  
  public MemberRegistry() {
  }

  /**
   * @return ArrayList<Member>
   */
  public ArrayList<Member> getAllMembers() {
    return members;
  }
  
  /**
   * @param newMember
   */
  public void addMember(Member newMember) {
    members.add(newMember);
  }

  /**
   * @param memberId
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

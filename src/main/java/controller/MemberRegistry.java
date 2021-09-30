package controller;

import java.util.ArrayList;
import model.Member;

public class MemberRegistry {
  private ArrayList<Member> members = new ArrayList<>();
  
  public MemberRegistry() {
  }

  public ArrayList<Member> getAllMembers() {
    return members;
  }
  
  public void addMember(Member newMember) {
    members.add(newMember);
  }

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

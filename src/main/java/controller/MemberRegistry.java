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

  // public Member getMemberById(){
  // }

  public void addMember(Member newMember) {
    members.add(newMember);
  }
}

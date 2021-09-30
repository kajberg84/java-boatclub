package controller;

import java.util.ArrayList;
import model.Boat;
import model.Member;

public class MemberHandler {
  private IdHandler handler = new IdHandler();
  private MemberRegistry registry = new MemberRegistry();

  public void createMember(String name, String socialSecurityNumber) {
    model.Id memberId = handler.generateUniqueId();
    model.Member newMember = new model.Member(name, socialSecurityNumber, memberId);
    registry.addMember(newMember);
    System.out.println("ID: " + newMember.getId());
  }

  public Member getMember(String memberId) {
    return registry.getMemberById(memberId);
  }

  public ArrayList<Member> getAllMembers() {
    return registry.getAllMembers();
  }

  public void addNewBoat(String memberId, Boat boat) {
    Member memberToUpdate = getMember(memberId);
    ArrayList<Boat> boatsToUpdate = memberToUpdate.getBoats();
    boatsToUpdate.add(boat);
    memberToUpdate.setBoats(boatsToUpdate);
  }

  public void deleteMember(Member member) {
    ArrayList<Member> members = registry.getAllMembers();
    members.remove(member);
  }

  public void editName(Member member, String name) {
    member.setName(name);
  }

  public void editSocialSecurityNumber(Member member, String number) {
    member.setSocialSecurityNumber(number);
  }
}

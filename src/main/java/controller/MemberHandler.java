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
    System.out.println(newMember.getName());
    System.out.println(newMember.getSocialSecurityNumber());
    System.out.println(newMember.getId());
  }

  public Member getMember(String memberId) {
    return registry.getMemberById(memberId);
  }

  public void addNewBoat(String memberId, Boat boat) {
    Member memberToUpdate = getMember(memberId);
    ArrayList<Boat> boatsToUpdate = memberToUpdate.getBoats();
    boatsToUpdate.add(boat);
    memberToUpdate.setBoats(boatsToUpdate);
  }

}

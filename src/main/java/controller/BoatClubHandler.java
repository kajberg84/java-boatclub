package controller;

import java.util.ArrayList;
import model.Boat;
import model.Member;
import view.UserInterface;
import view.UserInterface.Action;
import view.UserInterface.BoatAction;
import view.UserInterface.MemberAction;

public class BoatClubHandler {
  private UserInterface ui = new UserInterface();
  private MemberHandler memberHandler = new MemberHandler();
  private BoatHandler boatHandler = new BoatHandler();

  public BoatClubHandler() {
  }
  
  public void start() {
    showMainMenu();
  }

  public void showMainMenu() {
    Action action = ui.promptForAction();
    showSubMenu(action);
  }

  public void showSubMenu(Action action) {
    switch (action) {
      case MEMBERS:
        MemberAction memberAction = ui.promptForMemberAction();
        handleMemberActions(memberAction);
        break;
      case BOATS:
        BoatAction boatAction = ui.promptForBoatAction();
        handleBoatAction(boatAction);
        break;
      case EXIT:
        System.out.println("Goodbye!");
        break;
      default:
        break;
    }
  }

  private void handleBoatAction(BoatAction action) {
    switch (action) {
      case ADD:
        Member member;
        do {
          String memberId = ui.promptForMemberId();
          member = memberHandler.getMember(memberId);
        } while (member == null);
        int type = ui.promptForBoatType();
        int length = ui.promptForBoatLength();
        Boat boat = boatHandler.createBoat(type, length);
        memberHandler.addNewBoat(member.getId(), boat);
        showSubMenu(Action.BOATS);
        break;
      case EDIT:
        // To do.
      case DELETE:
        // To do.
      case BACK:
        showMainMenu();
        break;
      default:
        break;
    }
  }

  public void handleMemberActions(MemberAction action) {
    switch (action) {
      case ADD:
        String name = ui.promptForMemberName();
        String number = ui.promptForSocialSecurityNumber();
        memberHandler.createMember(name, number);
        showSubMenu(Action.MEMBERS);
        break;
      case EDIT:
        Member memberToEdit;
        do {
          String memberId = ui.promptForMemberId();
          memberToEdit = memberHandler.getMember(memberId);
        } while (memberToEdit == null);
        int editOption = ui.promptForEditMemberOptions(memberToEdit.getName());
        if (editOption > 0) {
          ui.printHeader("edit member");
          handleEditMember(editOption, memberToEdit);
        } 
        showSubMenu(Action.MEMBERS);
        break;
      case VIEWALL:
        int viewOption = ui.promptForListOptions();
        if (viewOption > 0) {
          ui.printHeader("all members");
          handlePrintAllMembers(viewOption);
        } 
        showSubMenu(Action.MEMBERS);
        break;
      case VIEWONE:
        String memberId = ui.promptForMemberId();
        Member member = memberHandler.getMember(memberId);
        ui.printHeader("member details");
        ui.printMemberDetailed(member);
        showSubMenu(Action.MEMBERS);
        break;
      case DELETE:
        handleDeleteMember();
        showSubMenu(Action.MEMBERS);
        break;
      case BACK:
        showMainMenu();
        break;
      default:
        break;
    }
  }

  private void handleEditMember(int option, Member member) {
    switch (option) {
      case 1: 
        String name = ui.promptForMemberName();
        memberHandler.editName(member, name);
        break;
      case 2:
        String socialSecurityNumber = ui.promptForSocialSecurityNumber();
        memberHandler.editSocialSecurityNumber(member, socialSecurityNumber);
        break;
      default: break;
    }
  }

  private void handleDeleteMember() {
    Member member;
    do {
      String memberId = ui.promptForMemberId();
      member = memberHandler.getMember(memberId);
    } while (member == null);
    memberHandler.deleteMember(member);
  }

  private void handlePrintAllMembers(int option) {
    ArrayList<Member> members = memberHandler.getAllMembers();
    switch (option) {
      case 1: 
        for (Member member : members) {
          ui.printMemberDetailed(member);
        }
        break;
      case 2:
        for (Member member : members) {
          ui.printMemberBasic(member);
        }
        break;
      default: break;
    }
  }
}

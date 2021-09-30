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
        // return MemberAction.EDIT;
      case VIEWALL:
        int option = ui.promptForListOptions();
        if (option > 0) {
          ui.printHeader("all members");
          handlePrintAllMembers(option);
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

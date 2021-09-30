package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Boat;
import model.Member;
import view.UserInterface;
import view.UserInterface.Action;
import view.UserInterface.BoatAction;
import view.UserInterface.MemberAction;

public class BoatClubHandler {
  private Scanner scan = new Scanner(System.in, "UTF-8");
  private UserInterface ui = new UserInterface(scan);
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
        scan.close();
        System.out.println("Goodbye!");
        break;
      default:
        break;
    }
  }

  private void handleBoatAction(BoatAction action) {
    switch (action) {
      case ADD:
        handleAddBoat();
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

  private void handleAddBoat() {
    Member member = askForValidMember();
    int type = ui.promptForBoatType();
    int length = ui.promptForBoatLength();
    Boat boat = boatHandler.createBoat(type, length);
    memberHandler.addNewBoat(member.getId(), boat);
  }

  public void handleMemberActions(MemberAction action) {
    switch (action) {
      case ADD:
        handleAddMember();
        showSubMenu(Action.MEMBERS);
        break;
      case EDIT:
        handleEditMember();
        showSubMenu(Action.MEMBERS);
        break;
      case VIEWALL:
        handleViewAllMembers();
        showSubMenu(Action.MEMBERS);
        break;
      case VIEWONE:
        handleViewMember();
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

  private Member askForValidMember() {
    Member memberToEdit;
    do {
      String memberId = ui.promptForMemberId();
      memberToEdit = memberHandler.getMember(memberId);
    } while (memberToEdit == null);
    return memberToEdit;
  }
  
  private void handleAddMember() {
    String name = ui.promptForMemberName();
    String number = ui.promptForSocialSecurityNumber();
    memberHandler.createMember(name, number);
  }
  
  private void handleEditMember() {
    ui.printHeader("edit member");
    Member member = askForValidMember();
    int editOption = ui.promptForEditMemberOptions(member.getName());
    
    switch (editOption) {
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

  private void handleViewMember() {
    String memberId = ui.promptForMemberId();
    Member member = memberHandler.getMember(memberId);
    ui.printHeader("member details");
    ui.printMemberDetailed(member);
  }
  
  private void handleViewAllMembers() {
    int viewOption = ui.promptForListOptions();
    if (viewOption > 0) {
      ui.printHeader("all members");
      handlePrintAllMembers(viewOption);
    }
  }

  private void handlePrintAllMembers(int option) {
    ArrayList<Member> members = memberHandler.getAllMembers();
    if (members.size() == 0) {
      ui.printNoMemberFound();
    }
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

  private void handleDeleteMember() {
    Member member;
    member = askForValidMember();
    memberHandler.deleteMember(member);
  }
}

package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Action;
import model.BoatAction;
import model.Member;
import model.MemberAction;
import model.PersistentData;
import view.BoatView;
import view.MemberView;

/**
 * Responsible for main operations in the boat club application.
 */
public class BoatClubHandler {
  private Scanner scan = new Scanner(System.in, "UTF-8");
  private MemberHandler memberHandler = new MemberHandler();
  private BoatView boatUi = new BoatView(scan, memberHandler);
  private MemberView memberUi = new MemberView(scan, memberHandler);
  private BoatHandler boatHandler = new BoatHandler(boatUi);
  private PersistentData persistentData;

  public BoatClubHandler() {
    persistentData = new PersistentData(memberHandler, boatHandler);
  }

  public void start() {
    persistentData.load();
    showMainMenu();
  }

  public void showMainMenu() {
    Action action = boatUi.promptForMainAction();
    showSubMenu(action);
  }

  /**
   * Shows a sub menu to the user.

   * @param action The action chosen by the user.
   */
  public void showSubMenu(Action action) {
    switch (action) {
      case MEMBERS:
        MemberAction memberAction = boatUi.promptForMemberAction();
        handleMemberActions(memberAction);
        break;
      case BOATS:
        BoatAction boatAction = boatUi.promptForBoatAction();
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

  /**
   * Handles adding, editing and deleting boats.

   * @param action The action chosen by the user.
   */
  private void handleBoatAction(BoatAction action) {
    switch (action) {
      case ADD:
        handleAddBoat();
        showSubMenu(Action.BOATS);
        break;
      case EDIT:
        handleEditBoat();
        showSubMenu(Action.BOATS);
        break;
      case DELETE:
        handleDeleteBoat();
        showSubMenu(Action.BOATS);
        break;
      case BACK:
        showMainMenu();
        break;
      default:
        break;
    }
  }

  private void handleAddBoat() {
    boatHandler.addNewBoat();
  }

  private void handleEditBoat() {
    boatHandler.editBoat();
  }

  private void handleDeleteBoat() {
    boatHandler.deleteBoat();
  }

  /**
   * Handles adding, editing, viewing and deleting members.

   * @param action The action chosen by the user.
   */
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

  /**
   * Asks for a member and returns it.

   * @return Member
   */
  private Member askForValidMember() {
    Member memberToEdit;
    do {
      String memberId = boatUi.promptForMemberId();
      memberToEdit = memberHandler.getMember(memberId);
    } while (memberToEdit == null);
    return memberToEdit;
  }
  
  private void handleAddMember() {
    boatUi.printHeader("register member");
    String name = memberUi.promptForMemberName();
    String number = memberUi.promptForSocialSecurityNumber();
    memberHandler.createMember(name, number);
  }
  
  private void handleEditMember() {
    boatUi.printHeader("edit member");
    Member member = askForValidMember();
    int editOption = memberUi.promptForEditMemberOptions(member.getName());
    
    switch (editOption) {
      case 1: 
        String name = memberUi.promptForMemberName();
        memberHandler.editName(member, name);
        break;
      case 2:
        String socialSecurityNumber = memberUi.promptForSocialSecurityNumber();
        memberHandler.editSocialSecurityNumber(member, socialSecurityNumber);
        break;
      default: break;
    }
  }

  private void handleViewMember() {
    String memberId = boatUi.promptForMemberId();
    Member member = memberHandler.getMember(memberId);
    boatUi.printHeader("member details");
    memberUi.printMemberDetailed(member);
  }
  
  private void handleViewAllMembers() {
    int viewOption = memberUi.promptForListOptions();
    if (viewOption > 0) {
      boatUi.printHeader("all members");
      handlePrintAllMembers(viewOption);
    }
  }

  /**
   * Handles the printing of member details.

   * @param option The print view style chosen by the user.
   */
  private void handlePrintAllMembers(int option) {
    ArrayList<Member> members = memberHandler.getAllMembers();
    if (members.size() == 0) {
      memberUi.printNoMemberFound();
    }
    switch (option) {
      case 1: 
        for (Member member : members) {
          memberUi.printMemberDetailed(member);
        }
        break;
      case 2:
        for (Member member : members) {
          memberUi.printMemberBasic(member);
        }
        break;
      default: break;
    }
  }

  private void handleDeleteMember() {
    boatUi.printHeader("delete member");
    Member member = askForValidMember();
    memberHandler.deleteMember(member);
  }
}

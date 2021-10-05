package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Boat;
import model.BoatType;
import model.Member;
import model.PersistentData;
import view.BoatView;
import view.BoatView.Action;
import view.BoatView.BoatAction;
import view.UserInterface.MemberAction;

/**
 * Responsible for main operations in the boat club application.
 */
public class BoatClubHandler {
  private Scanner scan = new Scanner(System.in, "UTF-8");
  private MemberHandler memberHandler = new MemberHandler();
  // private UserInterface boatUi = new UserInterface(scan, memberHandler);
  private BoatView boatUi = new BoatView(scan, memberHandler);
  private BoatHandler boatHandler = new BoatHandler(boatUi);
  private PersistentData persistentData;

  public BoatClubHandler() {
    persistentData = new PersistentData(memberHandler);
  }

  public void start() {
    persistentData.load();
    showMainMenu();
  }

  public void showMainMenu() {
    Action action = boatUi.promptForAction();
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
    boatUi.printHeader("register boat");
    Member member = askForValidMember();
    BoatType type = boatUi.promptForBoatType();
    int length = boatUi.promptForBoatLength();
    Boat boat = boatHandler.createBoat(type, length);
    memberHandler.addNewBoat(member.getId(), boat);
  }

  private void handleEditBoat() {
    boatUi.printHeader("edit boat");
    Member member = askForValidMember();
    int boatIndex = boatUi.promptForBoat(member);
    int editOption = boatUi.promptForEditBoatOptions();
    
    switch (editOption) {
      case 1: 
        BoatType type = boatUi.promptForBoatType();
        memberHandler.editBoatType(member, boatIndex, type);
        break;
      case 2:
        int length = boatUi.promptForBoatLength();
        memberHandler.editBoatLength(member, boatIndex, length);
        break;
      default: break;
    }
  }

  private void handleDeleteBoat() {
    boatUi.printHeader("delete boat");
    Member member = askForValidMember();
    int boatIndex = boatUi.promptForBoat(member);
    memberHandler.deleteBoat(member, boatIndex);
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
    String name = boatUi.promptForMemberName();
    String number = boatUi.promptForSocialSecurityNumber();
    memberHandler.createMember(name, number);
  }
  
  private void handleEditMember() {
    boatUi.printHeader("edit member");
    Member member = askForValidMember();
    int editOption = boatUi.promptForEditMemberOptions(member.getName());
    
    switch (editOption) {
      case 1: 
        String name = boatUi.promptForMemberName();
        memberHandler.editName(member, name);
        break;
      case 2:
        String socialSecurityNumber = boatUi.promptForSocialSecurityNumber();
        memberHandler.editSocialSecurityNumber(member, socialSecurityNumber);
        break;
      default: break;
    }
  }

  private void handleViewMember() {
    String memberId = boatUi.promptForMemberId();
    Member member = memberHandler.getMember(memberId);
    boatUi.printHeader("member details");
    boatUi.printMemberDetailed(member);
  }
  
  private void handleViewAllMembers() {
    int viewOption = boatUi.promptForListOptions();
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
      boatUi.printNoMemberFound();
    }
    switch (option) {
      case 1: 
        for (Member member : members) {
          boatUi.printMemberDetailed(member);
        }
        break;
      case 2:
        for (Member member : members) {
          boatUi.printMemberBasic(member);
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

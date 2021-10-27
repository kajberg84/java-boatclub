package controller;

import model.MemberRegistry;
import model.PersistentData;

/**
 * Responsible for main operations in the boat club application.
 */
public class BoatClubHandler {
  private MemberRegistry registry = new MemberRegistry();
  private PersistentData persistentData = new PersistentData(registry);
  private Menu menu;
  private Authenticator authenticator;

  public BoatClubHandler(Authenticator auth) {
    authenticator = auth;
  }

  public void start() {
    persistentData.load();
    if (authenticator.login()) {
      menu = new AuthenticatedMenu(registry);
      menu.showMainMenu();
    } else {
      menu = new UnauthenticatedMenu(registry);
      menu.showMainMenu();
    }
  }

  // private void showMainMenu() {
  //   Action action = boatUi.promptForMainAction();
  //   showSubMenu(action);
  // }

  // private void showSubMenu(Action action) {
  //   switch (action) {
  //     case MEMBERS:
  //       MemberAction memberAction = memberUi.promptForMemberAction();
  //       handleMemberActions(memberAction);
  //       break;
  //     case BOATS:
  //       BoatAction boatAction = boatUi.promptForBoatAction();
  //       handleBoatAction(boatAction);
  //       break;
  //     case EXIT:
  //       scan.close();
  //       System.out.println("Goodbye!");
  //       break;
  //     default:
  //       break;
  //   }
  // }

  // private void handleBoatAction(BoatAction action) {
  //   switch (action) {
  //     case ADD:
  //       handleAddBoat();
  //       showSubMenu(Action.BOATS);
  //       break;
  //     case EDIT:
  //       handleEditBoat();
  //       showSubMenu(Action.BOATS);
  //       break;
  //     case DELETE:
  //       handleDeleteBoat();
  //       showSubMenu(Action.BOATS);
  //       break;
  //     case BACK:
  //       showMainMenu();
  //       break;
  //     default:
  //       break;
  //   }
  // }

  // private void handleAddBoat() {
  //   boatUi.printRegisterBoatHeader();
  //   Member member = memberHandler.askForValidMember();
  //   boatHandler.addNewBoat(member);
  // }

  // private void handleEditBoat() {
  //   boatUi.printEditBoatHeader();
  //   Member member = memberHandler.askForValidMember();
  //   boatHandler.editBoat(member);
  // }

  // private void handleDeleteBoat() {
  //   boatUi.printDeleteBoatHeader();
  //   Member member = memberHandler.askForValidMember();
  //   boatHandler.deleteBoat(member);
  // }

  // private void handleMemberActions(MemberAction action) {
  //   switch (action) {
  //     case ADD:
  //       handleAddMember();
  //       showSubMenu(Action.MEMBERS);
  //       break;
  //     case EDIT:
  //       handleEditMember();
  //       showSubMenu(Action.MEMBERS);
  //       break;
  //     case VIEWALL:
  //       handleViewAllMembers();
  //       showSubMenu(Action.MEMBERS);
  //       break;
  //     case VIEWONE:
  //       handleViewMember();
  //       showSubMenu(Action.MEMBERS);
  //       break;
  //     case DELETE:
  //       handleDeleteMember();
  //       showSubMenu(Action.MEMBERS);
  //       break;
  //     case BACK:
  //       showMainMenu();
  //       break;
  //     default:
  //       break;
  //   }
  // }

  // private void handleAddMember() {
  //   memberHandler.registerMember();
  // }
  
  // private void handleEditMember() {
  //   memberHandler.editMember();
  // }

  // private void handleViewMember() {
  //   memberHandler.viewMember();
  // }
  
  // private void handleViewAllMembers() {
  //   memberHandler.viewAllMembers();
  // }

  // private void handleDeleteMember() {
  //   memberHandler.deleteMember();
  // }
}

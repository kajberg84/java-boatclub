package controller;

import model.MemberRegistry;
import view.Action;
import view.MemberAction;

/**
 * Responsible for handling the actions of an unauthenticated user.
 */
public class UnauthenticatedMenu extends Menu {

  public UnauthenticatedMenu(MemberRegistry registry) {
    super(registry);
  }

  @Override
  public void showMainMenu() {
    Action action = memberUi.promptForUnauthenticatedMainAction();
    showSubMenu(action);
  }

  private void showSubMenu(Action action) {
    switch (action) {
      case MEMBERS:
        MemberAction memberAction = memberUi.promptForUnauthenticatedMemberAction();
        handleMemberActions(memberAction);
        break;
      case EXIT:
        scan.close();
        System.out.println("Goodbye!");
        break;
      default:
        break;
    }
  }

  private void handleMemberActions(MemberAction action) {
    switch (action) {
      case VIEWALL:
        handleViewAllMembers();
        showSubMenu(Action.MEMBERS);
        break;
      case VIEWONE:
        handleViewMember();
        showSubMenu(Action.MEMBERS);
        break;
      case SEARCH:
        // TO DO
        System.out.println("Search is a coming feature...");
        break;
      case BACK:
        showMainMenu();
        break;
      default:
        break;
    }
  }

  private void handleViewMember() {
    memberHandler.viewMember();
  }
  
  private void handleViewAllMembers() {
    memberHandler.viewAllMembers();
  }
}

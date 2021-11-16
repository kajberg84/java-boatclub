package controller.menus;

import java.util.Scanner;
import model.MemberRegistry;
import view.actions.Action;
import view.actions.MemberAction;

/**
 * Responsible for handling the actions of an unauthenticated user.
 */
public class UnauthenticatedMenu extends Menu {

  public UnauthenticatedMenu(MemberRegistry registry, Scanner scan) {
    super(registry, scan);
  }

  @Override
  public void showMainMenu() {
    Action action = menuUi.promptForUnauthenticatedMainAction();
    showSubMenu(action);
  }

  private void showSubMenu(Action action) {
    switch (action) {
      case MEMBERS:
        MemberAction memberAction = menuUi.promptForUnauthenticatedMemberAction();
        handleMemberActions(memberAction);
        break;
      case EXIT:
        exit();
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
        handleSearch();
        showSubMenu(Action.MEMBERS);
        break;
      case BACK:
        showMainMenu();
        break;
      default:
        break;
    }
  }
}

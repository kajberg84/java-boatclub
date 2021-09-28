package controller;

import view.UserInterface;
import view.UserInterface.Action;
import view.UserInterface.MemberAction;
import model.Member;

public class BoatClubHandler {
  private UserInterface ui = new UserInterface();
  private MemberHandler memberHandler = new MemberHandler();

  public BoatClubHandler () {
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
        System.out.println("boatmenu");
        break;
      case EXIT:
        System.out.println("Goodbye!");
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
        // return MemberAction.VIEWALL;
      case VIEWONE:
        String memberId = ui.promptForMemberId();
        Member member = memberHandler.showMember(memberId);
        ui.printMember(member);
        showSubMenu(Action.MEMBERS);
        break;
      case DELETE:
        // return MemberAction.DELETE;
      case BACK:
        showMainMenu();
        break;
      default:
        break;
    }
  }
}

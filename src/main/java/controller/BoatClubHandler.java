package controller;

import view.UserInterface;

public class BoatClubHandler {
  private UserInterface ui = new UserInterface();

  public BoatClubHandler () {
  }
  
  public void start() {
    showMainMenu();
  }

  public void showMainMenu() {
    UserInterface.Action action = ui.promptForAction();
    showSubMenu(action);
  }

  public void showSubMenu(UserInterface.Action action) {
    switch (action) {
      case MEMBERS:
        ui.promptForMemberAction();
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
}

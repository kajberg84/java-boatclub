package controller;

import controller.menus.AuthenticatedMenu;
import controller.menus.Menu;
import controller.menus.UnauthenticatedMenu;
import model.MemberRegistry;

/**
 * Responsible for starting up the boat club application.
 */
public class MenuHandler {
  private Menu menu;

  public MenuHandler() {
  }

  /**
   * Starts the application with correct menu.
   */
  public void start(Authenticator authenticator, MemberRegistry registry) {
    if (authenticator.login()) {
      menu = new AuthenticatedMenu(registry);
    } else {
      menu = new UnauthenticatedMenu(registry);
    }
    menu.showMainMenu();
  }
}

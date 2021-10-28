package controller;

import model.FileHandler;
import model.MemberRegistry;

/**
 * Responsible for starting up the boat club application.
 */
public class BoatClubHandler {
  private MemberRegistry registry = new MemberRegistry();
  private FileHandler fileHandler = new FileHandler(registry);
  private Menu menu;
  private Authenticator authenticator;

  public BoatClubHandler(Authenticator auth) {
    authenticator = auth;
  }

  /**
   * Starts the application with correct menu.
   */
  public void start() {
    fileHandler.load();
    if (authenticator.login()) {
      menu = new AuthenticatedMenu(registry);
    } else {
      menu = new UnauthenticatedMenu(registry);
    }
    menu.showMainMenu();
    fileHandler.save();
  }
}

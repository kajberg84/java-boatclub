package controller;

import model.MemberRegistry;
import model.PersistentData;

/**
 * Responsible for starting up the boat club application.
 */
public class BoatClubHandler {
  private MemberRegistry registry = new MemberRegistry();
  private PersistentData persistentData = new PersistentData(registry);
  private Menu menu;
  private Authenticator authenticator;

  public BoatClubHandler(Authenticator auth) {
    authenticator = auth;
  }

  /**
   * Starts the application with correct menu.
   */
  public void start() {
    persistentData.load();
    if (authenticator.login()) {
      menu = new AuthenticatedMenu(registry);
    } else {
      menu = new UnauthenticatedMenu(registry);
    }
    menu.showMainMenu();
  }
}

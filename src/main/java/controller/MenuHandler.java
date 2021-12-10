package controller;

import controller.menus.AuthenticatedMenu;
import controller.menus.Menu;
import controller.menus.UnauthenticatedMenu;
import java.util.Scanner;
import model.MemberRegistry;
import view.LoginView;

/**
 * Responsible for starting up the boat club application.
 */
public class MenuHandler {
  private Menu menu;
  private LoginView loginView;
  private Scanner scan = new Scanner(System.in, "UTF-8");

  public MenuHandler() {
    loginView = new LoginView(scan);
  }

  /**
   * Starts the application with correct menu.
   */
  public void start(MemberRegistry registry) {
    try {
      if (this.wantsToLogin()) {
        this.handleLogin(registry);
      } else {
        menu = new UnauthenticatedMenu(registry, scan);
      }
      menu.showMainMenu();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private boolean wantsToLogin() {
    return loginView.promptForAuthentication();
  }

  private void handleLogin(MemberRegistry registry) throws Exception {
    if (isLoggedInSuccesfully(registry)) {
      loginView.printLoginSuccesful();
      menu = new AuthenticatedMenu(registry, scan);
    } else {
      throw new Exception("Login failed");
    }
  }

  private boolean isLoggedInSuccesfully(MemberRegistry registry) {
    loginView.printLoginHeader();
    String userName = loginView.promptForUserName();
    String password = loginView.promptForPassword();
    return registry.login(userName, password);
  }
}

package controller;

import java.util.Scanner;
import view.LoginView;

/**
 * Responsible for authentication.
 */
public class Authenticator {
  private Scanner scan = new Scanner(System.in, "UTF-8");
  private LoginView loginView;
  private boolean isLoggedIn = false;

  public Authenticator() {
    loginView = new LoginView(scan);
  }

  /**
   * Handles login of user.

   * @return True when user is logged in successfully.
   */
  public boolean login() {
    if (loginView.promptForAuthentication()) {
      validateCredentials();
    } 
    return isLoggedIn;
  }

  private void validateCredentials() {
    String correctUserName = "santa";
    String correctPassword = "rudolph";

    while (!isLoggedIn) {
      String userName = loginView.promptForUserName();
      String password = loginView.promptForPassword();
      if (userName.equals(correctUserName) && password.equals(correctPassword)) {
        loginSuccessful();
        isLoggedIn = true;
      } else {
        loginFailed();
      }
    }
  }

  private void loginSuccessful() {
    loginView.printLoginSuccesful();
  }

  private void loginFailed() {
    loginView.printLoginFailed();
  }

  /**
   * Returns authentication status for the current session.

   * @return True when user is authenticated.
   */
  public boolean isAuthenticated() {
    return this.isLoggedIn;
  }

}

package controller;

import java.util.Scanner;

import view.LoginView;

public class Authenticator {
  private Scanner scan = new Scanner(System.in, "UTF-8");
  private LoginView loginView;

  public Authenticator() {
    loginView = new LoginView(scan);
  }

  public boolean login() {
    if (loginView.promptForAuthentication()) {
      Boolean isValidated = validateCredentials();
      return isValidated;
    } else {
      return false;
    }
  }

  private boolean validateCredentials() {
    String userName = loginView.promptForUserName();
    String password = loginView.promptForPassword();
    String correctUserName = "santa";
    String correctPassword = "rudolph";
    if (userName.equals(correctUserName) && password.equals(correctPassword)) {
      loginSuccessful();
      return true;
    } else {
      loginFailed();
      return false;
    }
  }

  private void loginSuccessful() {
    loginView.printLoginSuccesful();
  }

  private void loginFailed() {
    loginView.printLoginFailed();
  }
}

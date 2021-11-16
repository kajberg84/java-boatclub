package model;

/**
 * Responsible for authentication.
 */
public class Authentication {
  private boolean isLoggedIn = false;

  public Authentication() {
  }

  /**
   * Handles login of user.

   * @return True when user is logged in successfully.
   */
  public boolean login(String userName, String password) {
    validateCredentials(userName, password);
    return isLoggedIn;
  }

  private void validateCredentials(String userName, String password) {
    String correctUserName = "santa";
    String correctPassword = "rudolph";

    if (userName.equals(correctUserName) && password.equals(correctPassword)) {
      isLoggedIn = true;
    }
  }

  /**
   * Returns authentication status for the current session.

   * @return True when user is authenticated.
   */
  public boolean isAuthenticated() {
    return this.isLoggedIn;
  }

}

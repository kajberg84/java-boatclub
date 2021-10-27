package controller;

/**
 * Responsible for starting the application.
 */
public class App {
  /**
   * Application starting point.

   * @param args command line arguments.
   */

  public static void main(String[] args) {
    try {
      Authenticator auth = new Authenticator();
      BoatClubHandler boatClubHandler = new BoatClubHandler(auth);
      boatClubHandler.start();
    } catch (Exception e) {
      System.out.println("Sorry - something went wrong.");
      e.printStackTrace();
    }
  }
}

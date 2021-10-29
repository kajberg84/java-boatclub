package controller;

import model.FileHandler;
import model.MemberRegistry;

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
      FileHandler fileHandler = new FileHandler();
      MemberRegistry registry = fileHandler.load();
      Authenticator auth = new Authenticator();
      MenuHandler menuHandler = new MenuHandler();
      menuHandler.start(auth, registry);
      fileHandler.save(registry);
    } catch (Exception e) {
      System.out.println("\nSorry - something went wrong.\n");
      e.printStackTrace();
    }
  }
}

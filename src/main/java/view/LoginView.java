package view;

import java.util.Scanner;

/** 
 * A class representing a user interface.
 */
public class LoginView {
  private Scanner scan;

  /**
   * An instance of a user interface.

   * @param scan A scanner to get user input from.
   */
  public LoginView(Scanner scan) {
    this.scan = scan;
  }

  public void printLoginHeader() {
    System.out.println("\n***************");
    System.out.println("LOGIN");
    System.out.println("***************");
  }

  public String promptForUserName() {
    System.out.print("Enter username: ");
    String userName = getString();
    return userName;
  }

  public String promptForPassword() {
    System.out.print("Enter password: ");
    String userName = getString();
    return userName;
  }

  private String getString() {
    String str = scan.nextLine();
    return str;
  }

  public void printLoginFailed() {
    System.out.println("\n***************");
    System.out.println("WRONG CREDENTIALS - LOGIN FAILED");
    System.out.println("***************");
  }
}

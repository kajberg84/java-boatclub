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

  /**
   * Asks if user wishes to log in or not.

   * @return True if user wants to log in.
   */
  public boolean promptForAuthentication() {
    String str;
    do {
      System.out.println("\n***************");
      System.out.println("BOAT CLUB");
      System.out.println("***************\n");
      System.out.print("Do you want to login? (y/n) ");
      str = getString();
      System.out.println(str.equals("n"));
    } while (!isValidInput(str));
    return str.equals("y");
  }

  private boolean isValidInput(String str) {
    return str.equals("y") || str.equals("n");
  }

  /**
   * Prints a log in header.
   */
  public void printLoginHeader() {
    System.out.println("\n***************");
    System.out.println("LOGIN");
    System.out.println("***************");
  }

  /**
   * Prompts for username.

   * @return The entered username.
   */
  public String promptForUserName() {
    System.out.print("Enter username: ");
    String userName = getString();
    return userName;
  }

  /**
   * Prompts for password.

   * @return The entered password.
   */
  public String promptForPassword() {
    System.out.print("Enter password: ");
    String userName = getString();
    return userName;
  }

  private String getString() {
    String str = scan.nextLine();
    return str;
  }

  /**
   * Prints log in failed message.
   */
  public void printLoginFailed() {
    System.out.println("\n***************");
    System.out.println("WRONG CREDENTIALS - LOGIN FAILED");
    System.out.println("***************");
  }

  /**
   * Prints log in successful message.
   */
  public void printLoginSuccesful() {
    System.out.println("\n***************");
    System.out.println("LOGIN SUCCESSFUL");
    System.out.println("***************");
  }
}

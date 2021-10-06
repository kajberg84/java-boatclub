package view;

import controller.MemberHandler;
import java.util.Scanner;
import model.BoatType;
import model.Member;

/**
 * A class representing a boat interface.
 */
public class BoatView extends UserInterface {

  /**
   * An instance of a boat interface.

   * @param scan A scanner to get input from.
   * @param memberHandler A member handler.
   */
  public BoatView(Scanner scan, MemberHandler memberHandler) {
    super(scan, memberHandler);
  }

  /**
   * Prompts the user for a boat and returns the index of that boat.

   * @param member The member owning the boat.
   * @return int
   */
  public int promptForBoat(Member member) {
    printBoatDetails(member);
    int memberBoatsLength = member.getBoats().size();
    int userInput;
    do {
      System.out.println("\nChoose a boat.");
      System.out.print("Enter number: ");
      userInput = getInt();
    } while (userInput > memberBoatsLength || userInput == 0);
    return userInput - 1;
  }

  /**
   * Prompts the user for a boat's type and returns an integer representing that
   * type.

   * @return int
   */
  public BoatType promptForBoatType() {
    int userInput;
    BoatType[] types = BoatType.values();
    do {
      int index = 0;
      for (BoatType type : types) {
        System.out.println((index + 1) + ". " + type.label);
        index++;
      }
      System.out.print("Choose boat type: ");
      userInput = getInt();
    } while (userInput > types.length);
    return types[(userInput - 1)];
  }

  /**
   * Prompts the user for a boat's length.

   * @return int
   */
  public int promptForBoatLength() {
    System.out.print("Enter boat length: ");
    int userInput = getInt();
    return userInput;
  }

  /**
   * Prints the edit boat menu in the console and prompts for an action to be taken.

   * @return int
   */
  public int promptForEditBoatOptions() {
    int userInput;
    do {
      System.out.println("What do you want to edit?");
      System.out.println("1. Type");
      System.out.println("2. Length");
      System.out.println("0. Back");
      System.out.print("Choose an option: ");
      userInput = getInt();
    } while (userInput > 2);
    return userInput;
  }

  /**
   * Prints a register boat header.
   */
  public void printRegisterBoatHeader() {
    System.out.println("***************");
    System.out.println("REGISTER BOAT");
    System.out.println("***************");
  }

  /**
   * Prints an edit boat header.
   */
  public void printEditBoatHeader() {
    System.out.println("***************");
    System.out.println("EDIT BOAT");
    System.out.println("***************");
  }

  /**
   * Prints a delete boat header.
   */
  public void printDeleteBoatHeader() {
    System.out.println("***************");
    System.out.println("DELETE BOAT");
    System.out.println("***************");
  }
}

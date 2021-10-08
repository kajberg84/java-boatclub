package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Boat;
import model.Member;

/** 
 * A class representing a user interface.
 */
class UserInterface {
  private Scanner scan;

  /**
   * An instance of a user interface.

   * @param scan A scanner to get user input from.
   */
  public UserInterface(Scanner scan) {
    this.scan = scan;
  }

  protected int getInt() {
    int i = 0;
    do {
      if (scan.hasNextInt()) {
        i = scan.nextInt();
        scan.nextLine();
      } else {
        scan.nextLine();
        return 0;
      }
    } while (i < 0);
    return i;
  }

  protected String getString() {
    String str = scan.nextLine();
    return str;
  }

  /**
   * Prints the main menu in the console and prompts for an action to be taken.

   * @return Action
   */
  public Action promptForMainAction() {
    int userInput; 
    Action[] actions = Action.values();
    do {
      printMainMenuHeader();
      int index = 0;
      for (Action action : actions) {
        System.out.println((index + 1) + ". " + action.label);
        index++;
      }
      System.out.print("Choose an option: ");
      userInput = getInt();
    } while (!isValidInput(userInput, actions.length));
    return actions[(userInput - 1)];
  }

  protected boolean isValidInput(int input, int length) {
    boolean isValid = true;
    if (input < 1) {
      isValid = false;
    } else if (input > length) {
      isValid = false;
    }
    return isValid;
  }

  private void printMainMenuHeader() {
    System.out.println("\n***************");
    System.out.println("MAIN MENU");
    System.out.println("***************");
  }
  
  /**
   * Prints the members sub menu in the console and prompts for an action to be taken.

   * @return MemberAction
   */
  public MemberAction promptForMemberAction() {
    int userInput;
    MemberAction[] memberActions = MemberAction.values();
    do {
      printMemberMenuHeader();
      int index = 0;
      for (MemberAction memberAction : memberActions) {
        System.out.println((index + 1) + ". " + memberAction.label);
        index++;
      }
      System.out.print("Choose an option: ");
      userInput = getInt();
    } while (userInput > memberActions.length || userInput == 0);
    return memberActions[(userInput - 1)];
  }

  private void printMemberMenuHeader() {
    System.out.println("\n***************");
    System.out.println("MEMBER MENU");
    System.out.println("***************");
  }

  /**
   * Prints the boats sub menu in the console and prompts for an action to be taken.

   * @return BoatAction
   */
  public BoatAction promptForBoatAction() {
    int userInput;
    BoatAction[] boatActions = BoatAction.values();
    do {
      printBoatMenuHeader();
      int index = 0;
      for (BoatAction boatAction : boatActions) {
        System.out.println((index + 1) + ". " + boatAction.label);
        index++;
      }
      System.out.print("Choose an option: ");
      userInput = getInt();
    } while (userInput > boatActions.length || userInput == 0);
    return boatActions[(userInput - 1)];
  }

  private void printBoatMenuHeader() {
    System.out.println("\n***************");
    System.out.println("BOAT MENU");
    System.out.println("***************");
  }

  /**
   * Prompts the user for a member's ID.

   * @return String
   */
  public String promptForMemberId() {
    System.out.print("Enter member ID: ");
    String memberId = getString();
    return memberId;
  }

  protected void printBoatDetails(Member member) {
    ArrayList<Boat> boats = member.getBoats();
    System.out.println("Registered boats:");
    for (int i = 0; i < boats.size(); i++) {
      System.out.print((i + 1) + ". ");
      System.out.println("type: " + boats.get(i).getBoatType() + ", length: " + boats.get(i).getLength());
    }
  }
}

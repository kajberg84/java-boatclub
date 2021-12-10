package view;

import java.util.Scanner;
import view.actions.Action;
import view.actions.BoatAction;
import view.actions.MemberAction;

/**
 * Represents a menu view.
 */
public class MenuView extends View {

  public MenuView(Scanner scan) {
    super(scan);
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

  /**
   * Prints menu and prompts for action for an unauthenticated user.

   * @return The chosen action.
   */
  public Action promptForUnauthenticatedMainAction() {
    int userInput;
    do {
      printMainMenuHeader();
      System.out.println(("1. " + Action.MEMBERS.label));
      System.out.println(("2. " + Action.EXIT.label));
      System.out.print("Choose an option: ");
      userInput = getInt();
    } while (!isValidInput(userInput, 2));
    if (userInput == 1) {
      return Action.MEMBERS;
    }
    return Action.EXIT;
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
      int index = 1;
      for (MemberAction memberAction : memberActions) {
        System.out.println((index) + ". " + memberAction.label);
        index++;
      }
      System.out.print("Choose an option: ");
      userInput = getInt();
    } while (userInput > memberActions.length || userInput == 0);
    int menuChoice = userInput - 1;
    return memberActions[(menuChoice)];
  }

  private void printMemberMenuHeader() {
    System.out.println("\n***************");
    System.out.println("MEMBER MENU");
    System.out.println("***************");
  }

  /**
   * Prints the members sub menu for an unauthenticated user in the console and prompts for an action to be taken.

   * @return MemberAction
   */
  public MemberAction promptForUnauthenticatedMemberAction() {
    int userInput;
    do {
      printMemberMenuHeader();
      System.out.println("1. " + MemberAction.SEARCH.label);
      System.out.println("2. " + MemberAction.VIEWALL.label);
      System.out.println("3. " + MemberAction.VIEWONE.label);
      System.out.println("4. " + MemberAction.BACK.label);
      System.out.print("Choose an option: ");
      userInput = getInt();
    } while (userInput > 4 || userInput == 0);
  
    if (userInput == 1) {
      return MemberAction.SEARCH;
    } else if (userInput == 2) {
      return MemberAction.VIEWALL;
    } else if (userInput == 3) {
      return MemberAction.VIEWONE;
    }
    return MemberAction.BACK;
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
      int index = 1;
      for (BoatAction boatAction : boatActions) {
        System.out.println((index) + ". " + boatAction.label);
        index++;
      }
      System.out.print("Choose an option: ");
      userInput = getInt();
    } while (userInput > boatActions.length || userInput == 0);
    int menuChoice = userInput - 1;
    return boatActions[menuChoice];
  }

  private void printBoatMenuHeader() {
    System.out.println("\n***************");
    System.out.println("BOAT MENU");
    System.out.println("***************");
  }

  /**
   * Prints a good bye message.
   */
  public void printGoodBye() {
    System.out.println("\n***************");
    System.out.println("GOOD BYE!");
    System.out.println("***************");
  }
}

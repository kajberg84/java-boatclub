package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Boat;
import model.BoatType;
import model.Member;

/** 
 * A class representing a user interface.
 */
public class UserInterface {
  private Scanner scan;

  /**
   * An instance of a user interface.

   * @param scan A scanner to get user input from.
   */
  public UserInterface(Scanner scan) {
    this.scan = scan;
  }
  
  /**
   * Actions to choose from in the main menu.
   */
  public enum Action {
    MEMBERS,
    BOATS,
    EXIT,
    None
  }

  /** 
   * Actions to choose from in the members sub menu.
   */
  public enum MemberAction {
    ADD,
    EDIT,
    VIEWALL,
    VIEWONE,
    DELETE,
    BACK,
    None
  }

  /** 
   * Actions to choose from in the boats sub menu.
   */
  public enum BoatAction {
    ADD, 
    EDIT, 
    DELETE, 
    BACK, 
    None
  }

  /**
   * Returns an integer scanned from user input in the console.

   * @return int
   */
  public int getInt() {
    int i = 0;
    do {
      if (scan.hasNextInt()) {
        i = scan.nextInt();
        scan.nextLine();
      }
    } while (i < 0);
    return i;
  }
  
  /**
   * Returns a string scanned from user input in the console.

   * @return String
   */
  public String getString() {
    String str = scan.nextLine();
    return str;
  }
  
  /**
   * Prints a header in the console.

   * @param header The header text string.
   */
  public void printHeader(String header) {
    System.out.println("***************");
    System.out.println(header.toUpperCase());
    System.out.println("***************");
  }
  
  /**
   * Prints the main menu in the console and prompts for an action to be taken.

   * @return Action
   */
  public Action promptForAction() {
    printHeader("main menu");
    System.out.println("1. Handle members");
    System.out.println("2. Handle boats");
    System.out.println("0. Exit");
    System.out.print("Choose an option: ");

    int userInput = getInt();

    switch (userInput) {
      case 1:
        return Action.MEMBERS;
      case 2:
        return Action.BOATS;
      case 0:
        return Action.EXIT;
      default:
        break;
    }
    return Action.None;
  }

  /**
   * Prints the members sub menu in the console and prompts for an action to be taken.

   * @return MemberAction
   */
  public MemberAction promptForMemberAction() {
    printHeader("member menu");
    System.out.println("1. Add new member");
    System.out.println("2. Edit member details");
    System.out.println("3. View all members");
    System.out.println("4. View one member");
    System.out.println("5. Delete member");
    System.out.println("0. Go back to main menu");
    System.out.print("Choose an option: ");

    int userInput = getInt();

    switch (userInput) {
      case 1:
        return MemberAction.ADD;
      case 2:
        return MemberAction.EDIT;
      case 3:
        return MemberAction.VIEWALL;
      case 4:
        return MemberAction.VIEWONE;
      case 5:
        return MemberAction.DELETE;
      case 0:
        return MemberAction.BACK;
      default:
        break;
    }
    return MemberAction.None;
  }

  /**
   * Prompts the user for a member's name.

   * @return String
   */
  public String promptForMemberName() {
    System.out.print("Enter full member name: ");
    String name = getString();
    return name;
  }

  /**
   * Prompts the user for a member's social security number.

   * @return String
   */
  public String promptForSocialSecurityNumber() {
    System.out.print("Enter social security number: ");
    String number = getString();
    return number;
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
  
  /**
   * Prints in the console that no member was found.
   */
  public void printNoMemberFound() {
    System.out.println("No member found.\n");
  }

  /**
   * Prints the edit member menu in the console and prompts for an action to be taken.

   * @param name The name of the member to edit.
   * @return int
   */
  public int promptForEditMemberOptions(String name) {
    int userInput;
    do {
      System.out.println("What do you want to edit for " + name + "?");
      System.out.println("1. Name");
      System.out.println("2. Social security number");
      System.out.println("0. Back");
      System.out.print("Choose an option: ");
      userInput = getInt();
    } while (userInput > 2);
    return userInput;
  }
  
  /**
   * Prints the options for viewing all members in the console 
   * and prompts for an action to be taken.

   * @return int
   */
  public int promptForListOptions() {
    int userInput;
    do {
      System.out.println("What do you want to list?");
      System.out.println("1. Detailed list");
      System.out.println("2. Basic list");
      System.out.println("0. Back");
      System.out.print("Choose an option: ");
      userInput = getInt();
    } while (userInput > 2);
    return userInput;
  }
  

  /**
   * Prints a detailed view of a specific member in the console.

   * @param member The member to view.
   */
  public void printMemberDetailed(Member member) {
    if (member == null) {
      printNoMemberFound();
    } else {
      System.out.println("Name: " + member.getName());
      System.out.println("Social security number: " + member.getSocialSecurityNumber());
      System.out.println("Member ID: " + member.getId());
      if (member.getBoats().size() > 0) {
        printBoatDetails(member);
      } else {
        System.out.println("No registered boats.");
      }
      System.out.println();
    }
  }

  /**
   * Prints a basic view of a specific member in the console.

   * @param member The member to view.
   */
  public void printMemberBasic(Member member) {
    if (member == null) {
      printNoMemberFound();
    } else {
      System.out.println("Name: " + member.getName());
      System.out.println("Member ID: " + member.getId());
      System.out.println("Registered boats: " + member.getBoats().size() + "\n");
    }
  }

  /**
   * Prints the details for all boats registered to a member.

   * @param member The member whose boats to view.
   */
  private void printBoatDetails(Member member) {
    ArrayList<Boat> boats = member.getBoats();
    System.out.println("Registered boats:");
    for (int i = 0; i < boats.size(); i++) {
      System.out.print((i + 1) + ". ");
      System.out.println("type: " + boats.get(i).getBoatType() + ", length: " + boats.get(i).getLength());
    }
  }

  /**
   * Prints the boats sub menu in the console and prompts for an action to be taken.

   * @return BoatAction
   */
  public BoatAction promptForBoatAction() {
    printHeader("boat menu");
    System.out.println("1. Register boat");
    System.out.println("2. Edit boat");
    System.out.println("3. Delete boat");
    System.out.println("0. Back");
    System.out.print("Choose an option: ");

    int userInput = getInt();

    switch (userInput) {
      case 1:
        return BoatAction.ADD;
      case 2:
        return BoatAction.EDIT;
      case 3:
        return BoatAction.DELETE;
      case 0:
        return BoatAction.BACK;
      default:
        break;
    }
    return BoatAction.None;
  }

  /**
   * Prompts the user for a boat's type and returns an integer representing that type.

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
}

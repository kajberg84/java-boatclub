package view;

import java.util.Scanner;
import model.Member;

/**
 * A class representing a member view.
 */
public class MemberView extends UserInterface {

  /**
   * An instance of a member view.

   * @param scan A scanner to get input from.
   */
  public MemberView(Scanner scan) {
    super(scan);
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
   * Prints in the console that no member was found.
   */
  public void printNoMemberFound() {
    System.out.println("No member found.");
  }

  /**
   * Prints the edit member menu in the console and prompts for an action to be taken.

   * @param name The name of the member to edit.
   * @return int
   */
  public int promptForEditMemberOptions(String name) {
    int userInput;
    do {
      System.out.println("\nWhat do you want to edit for " + name + "?");
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
      System.out.println("\nWhat do you want to list?");
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
  public void printDetailedMember(Member member) {
    if (member == null) {
      printNoMemberFound();
    } else {
      System.out.println("\nName: " + member.getName());
      System.out.println("Social security number: " + member.getSocialSecurityNumber());
      System.out.println("Member ID: " + member.getId());
      if (member.getBoats().size() > 0) {
        printBoatDetails(member);
      } else {
        System.out.println("No registered boats.");
      }
    }
  }

  /**
   * Prints a basic view of a specific member in the console.

   * @param member The member to view.
   */
  public void printBasicMember(Member member) {
    if (member == null) {
      printNoMemberFound();
    } else {
      System.out.println("\nName: " + member.getName());
      System.out.println("Member ID: " + member.getId());
      System.out.println("Registered boats: " + member.getBoats().size());
    }
  }

  /**
   * Prints register member header.
   */
  public void printRegisterMemberHeader() {
    System.out.println("\n***************");
    System.out.println("REGISTER MEMBER");
    System.out.println("***************");
  }

  /**
   * Prints edit member header.
   */
  public void printEditMemberHeader() {
    System.out.println("\n***************");
    System.out.println("EDIT MEMBER");
    System.out.println("***************");
  }

  /**
   * Prints member details header.
   */
  public void printMemberDetailsHeader() {
    System.out.println("\n***************");
    System.out.println("MEMBER DETAILS");
    System.out.println("***************");
  }

  /**
   * Prints all members header.
   */
  public void printAllMembersHeader() {
    System.out.println("\n***************");
    System.out.println("REGISTERED MEMBERS");
    System.out.println("***************");
  }

  /**
   * Prints delete member header.
   */
  public void printDeleteMemberHeader() {
    System.out.println("\n***************");
    System.out.println("DELETE MEMBER");
    System.out.println("***************");
  }
}

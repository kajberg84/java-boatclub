package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.BoatType;
import model.Member;

public class BoatTypeSearchView {
  private Scanner scan;

  public BoatTypeSearchView(Scanner s) {
    scan = s;
  }

  /**
   * Prompts for a search string.

   * @return The input string.
   */
  public BoatType promptForSearchParameter() {
    System.out.println("\n**************************");
    System.out.println("SEARCH MEMBER BY BOAT TYPE");
    System.out.println("**************************");
    System.out.println("1. " + BoatType.SAILBOAT.label);
    System.out.println("2. " + BoatType.MOTORSAILER.label);
    System.out.println("3. " + BoatType.KAYAKCANOE.label);
    System.out.println("4. " + BoatType.OTHER.label);
    System.out.print("Choose boat type: ");
    int userInput;
    do {
      userInput = getInt();
    } while (userInput < 1 || userInput > 4);
    if (userInput == 1) {
      return BoatType.SAILBOAT;
    } else if (userInput == 2) {
      return BoatType.MOTORSAILER;
    } else if (userInput == 3) {
      return BoatType.KAYAKCANOE;
    }
    return BoatType.OTHER;
  }

  // private String getString() {
  //   String str = scan.nextLine();
  //   return str;
  // }

  private int getInt() {
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

  /**
   * Prints name and id of members in the console.

   * @param member The member to view.
   */
  public void printSearchResult(ArrayList<Member> members) {
    System.out.println("\n***************");
    System.out.println("SEARCH RESULT");
    System.out.println("***************");
    if (members.size() == 0) {
      System.out.println("\nNo members found");
    } else {
      for (Member m : members) {
        System.out.println("\nName: " + m.getName());
        System.out.println("Member ID: " + m.getId());
      }
    }
  }

}

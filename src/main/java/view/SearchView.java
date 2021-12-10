package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.BoatType;
import model.Member;

/**
 * Resoponsible for the search options view.
 */
public class SearchView extends View {

  /**
   * Enumerations for search options.
   */
  public enum SearchOption {
    NAME, BOAT
  }

  public SearchView(Scanner scan) {
    super(scan);
  }

  /**
   * Prompts for a search option.

   * @return A search option.
   */
  public SearchOption promptForSearchOption() {
    System.out.println("\n***************");
    System.out.println("SEARCH OPTIONS");
    System.out.println("***************");
    System.out.println("1. Search by name");
    System.out.println("2. Search by boat type");
    System.out.print("Choose an option: ");
    int i;
    do {
      i = getInt();
    } while (i < 1 || i > 2);
    if (i == 1) {
      return SearchOption.NAME;
    }
    return SearchOption.BOAT;
  }

  /**
   * Prompts for a search string.

   * @return The input string.
   */
  public String promptForNameSearchParameter() {
    System.out.println("\n***************");
    System.out.println("SEARCH MEMBER");
    System.out.println("***************");
    System.out.print("Search: ");
    String userInput = getString();
    return userInput;
  }

  /**
   * Prompts for a search string.

   * @return The input string.
   */
  public BoatType promptForBoatTypeSearchParameter() {
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

  /**
   * Prints name and id of members in the console.

   * @param members The members to view.
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

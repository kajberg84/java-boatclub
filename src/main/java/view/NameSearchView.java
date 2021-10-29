package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Member;

/**
 * Responsible for the name search view.
 */
public class NameSearchView extends View {

  public NameSearchView(Scanner scan) {
    super(scan);
  }

  /**
   * Prompts for a search string.

   * @return The input string.
   */
  public String promptForSearchParameter() {
    System.out.println("\n***************");
    System.out.println("SEARCH MEMBER");
    System.out.println("***************");
    System.out.print("Search: ");
    String userInput = getString();
    return userInput;
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

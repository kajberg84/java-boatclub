package view;

import java.util.Scanner;

/**
 * Resoponsible for the search options view.
 */
public class SearchOptionsView extends View {

  /**
   * Enumerations for search options.
   */
  public enum SearchOption {
    NAME, BOAT
  }

  /**
   * The search options view.

   * @param s A scanner object.
   */
  public SearchOptionsView(Scanner scan) {
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
}

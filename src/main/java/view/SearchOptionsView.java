package view;

import java.util.Scanner;

public class SearchOptionsView {
  private Scanner scan;

  public enum SearchOption {
    NAME, BOAT
  }

  public SearchOptionsView(Scanner s) {
    scan = s;
  }

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

}
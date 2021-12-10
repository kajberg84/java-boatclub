package view;

import java.util.Scanner;

/** 
 * A class representing a user interface.
 */
class View {
  private Scanner scan;

  /**
   * An instance of a user interface.

   * @param scan A scanner to get user input from.
   */
  public View(Scanner scan) {
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

  protected boolean isValidInput(int input, int length) {
    boolean isValid = true;
    if (input < 1) {
      isValid = false;
    } else if (input > length) {
      isValid = false;
    }
    return isValid;
  }
}

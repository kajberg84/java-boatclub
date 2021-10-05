package view;

import java.util.Scanner;
import controller.MemberHandler;
import model.BoatType;

public class BoatView extends UserInterface{

 public BoatView (Scanner scan, MemberHandler memberHandler) {
   super(scan, memberHandler);
 }


  /**
   * Prompts the user for a boat's type and returns an integer representing that
   * type.

   * 
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


}

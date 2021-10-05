package controller;

import java.util.Random;
import model.Id;

/** 
 * Responsible for handling an ID.
 */
public class IdHandler {  

  IdHandler() {
    
  }

  /**
   * Returns a random integer between 1 and 6.

   * @return int
   */
  private int getRandomNumber() {
    Random randomNumber = new Random();
    return randomNumber.nextInt(6) + 1;
  }

  /**
   * Returns an alphanumeric ID of up to 6 characters.

   * @return Id
   */
  public Id generateUniqueId() {
    StringBuilder builder = new StringBuilder();
    Random random = new Random();

    String upperCase =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerCase = upperCase.toLowerCase();
    String digits = "1234567890";
    String allChars = upperCase + lowerCase + digits;
    int length = getRandomNumber();

    for (int i = 0; i < length; i++) {
      builder.append(allChars.charAt(random.nextInt(allChars.length())));
    }
    model.Id newId = new Id(builder.toString());
    return newId;
  }
}

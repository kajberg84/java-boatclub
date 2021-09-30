package controller;

import java.util.Random;
import model.Id;

public class IdHandler {  

  IdHandler() {
    
  }

  private int getRandomNumber() {
    Random randomNumber = new Random();
    return randomNumber.nextInt(6) + 1;
  }

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

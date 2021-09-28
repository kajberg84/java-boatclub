package controller;
import java.util.Random;

import model.Id;

public class IdHandler {  
  private int length;

  IdHandler(int length) {
    this.length = length;
  }

  public Id generateUniqueId(){
    StringBuilder builder = new StringBuilder();
    Random random = new Random();

    String upperCase =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerCase = upperCase.toLowerCase();
    String digits = "1234567890";
    String allChars = upperCase + lowerCase + digits;

    for (int i = 0; i < this.length; i++) {
      builder.append(allChars.charAt(random.nextInt(allChars.length())));
    }
    model.Id newId = new Id(builder.toString());
    return newId;
  }
}

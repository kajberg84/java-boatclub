package controller;
import java.util.Random;

public class IdHandler {  
  
  IdHandler(){

  }

  public String generateUniqueId(){
    StringBuilder builder = new StringBuilder();
    Random random = new Random();

    String upperCase =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerCase = upperCase.toLowerCase();
    String digits = "1234567890";
    String allChars = upperCase + lowerCase + digits;
    int length = 6;

    for(int i = 0; i < length; i++){
      builder.append(allChars.charAt(random.nextInt(allChars.length())));
    }
    return builder.toString();
  }
}

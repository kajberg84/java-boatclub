package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Boat;
import model.Member;

public class UserInterface {
  Scanner scan = new Scanner(System.in);
  
  public enum Action {
    MEMBERS,
    BOATS,
    EXIT,
    None
  }

  public enum MemberAction {
    ADD,
    EDIT,
    VIEWALL,
    VIEWONE,
    DELETE,
    BACK,
    None
  }

  public enum BoatAction {
    ADD, EDIT, DELETE, BACK, None
  }

  // public void showMessage(String message) {
  //   System.out.println(message);
  // }

  public int getInt() {
    int i = 0;
    do {
      if (scan.hasNextInt()) {
        i = scan.nextInt();
        scan.nextLine();
      }
    } while (i < 0);
    return i;
  }
  
  public String getString() {
    String str = scan.nextLine();
    return str;
  }
  
  public void printHeader(String header) {
    System.out.println("***************");
    System.out.println(header.toUpperCase());
    System.out.println("***************");
  }
  
  public Action promptForAction() {
    printHeader("main menu");
    System.out.println("1. Handle members");
    System.out.println("2. Handle boats");
    System.out.println("0. Exit");
    System.out.print("Choose an option: ");

    int userInput = getInt();

    switch (userInput) {
      case 1:
        return Action.MEMBERS;
      case 2:
        return Action.BOATS;
      case 0:
        return Action.EXIT;
      default:
        break;
    }
    return Action.None;
  }

  public MemberAction promptForMemberAction() {
    printHeader("member menu");
    System.out.println("1. Add new member");
    System.out.println("2. Edit member details");
    System.out.println("3. View all members");
    System.out.println("4. View one member");
    System.out.println("5. Delete member");
    System.out.println("0. Go back to main menu");
    System.out.print("Choose an option: ");

    int userInput = getInt();

    switch (userInput) {
      case 1:
        return MemberAction.ADD;
      case 2:
        return MemberAction.EDIT;
      case 3:
        return MemberAction.VIEWALL;
      case 4:
        return MemberAction.VIEWONE;
      case 5:
        return MemberAction.DELETE;
      case 0:
        return MemberAction.BACK;
      default:
        break;
    }
    return MemberAction.None;
  }

  public String promptForMemberName() {
    System.out.print("Enter full member name: ");
    String name = getString();
    return name;
  }

  public String promptForSocialSecurityNumber() {
    System.out.print("Enter social security number: ");
    String number = getString();
    return number;
  }
  
  public String promptForMemberId() {
    System.out.print("Enter member ID: ");
    String memberId = getString();
    return memberId;
  }
  
  public void printNoMemberFound() {
    System.out.println("No member found.\n");
  }

  public int promptForEditMemberOptions(String name) {
    int userInput;
    do {
      System.out.println("What do you want to edit for " + name + "?");
      System.out.println("1. Name");
      System.out.println("2. Social security number");
      System.out.println("0. Back");
      userInput = getInt();
    } while (userInput > 2);
    return userInput;
  }
  
  public int promptForListOptions() {
    int userInput;
    do {
      System.out.println("What do you want to list?");
      System.out.println("1. Detailed list");
      System.out.println("2. Basic list");
      System.out.println("0. Back");
      userInput = getInt();
    } while (userInput > 2);
    return userInput;
  }
  

  public void printMemberDetailed(Member member) {
    if (member == null) {
      printNoMemberFound();
    } else {
      System.out.println("Name: " + member.getName());
      System.out.println("Social security number: " + member.getSocialSecurityNumber());
      System.out.println("Member ID: " + member.getId());
      if (member.getBoats().size() > 0) {
        printBoatDetails(member);
      } else {
        System.out.println("No registered boats.");
      }
      System.out.println();
    }
  }

  public void printMemberBasic(Member member) {
    if (member == null) {
      printNoMemberFound();
    } else {
      System.out.println("Name: " + member.getName());
      System.out.println("Member ID: " + member.getId());
      System.out.println("Registered boats: " + member.getBoats().size() + "\n");
    }
  }

  private void printBoatDetails(Member member) {
    ArrayList<Boat> boats = member.getBoats();
    System.out.println("Registered boats:");
    for (int i = 0; i < boats.size(); i++) {
      System.out.print("Boat " + (i + 1) + ". ");
      System.out.println("type: " + boats.get(i).getBoatType() + ", length: " + boats.get(i).getLength());
    }
  }

  public BoatAction promptForBoatAction() {
    printHeader("boat menu");
    System.out.println("1. Register boat");
    System.out.println("2. Edit boat");
    System.out.println("3. Delete boat");
    System.out.println("0. Back");
    System.out.print("Choose an option: ");

    int userInput = getInt();

    switch (userInput) {
      case 1:
        return BoatAction.ADD;
      case 2:
        return BoatAction.EDIT;
      case 3:
        return BoatAction.DELETE;
      case 0:
        return BoatAction.BACK;
      default:
        break;
    }
    return BoatAction.None;
  }

  public int promptForBoatType() {
    int userInput;
    do {
      System.out.println("1. Sailboat");
      System.out.println("2. Motorsailer");
      System.out.println("3. Kayak / Canoe");
      System.out.println("4. Other");
      System.out.println("0. Back");
      System.out.print("Choose boat type: ");
      userInput = getInt();
    } while (userInput > 4);
    return userInput;
  }

  public int promptForBoatLength() {
    System.out.print("Enter boat length: ");
    int userInput = getInt();
    return userInput;
  }


}

package view;

import java.util.Scanner;

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

  public Action promptForAction() {
    System.out.println("***************");
    System.out.println("MAIN MENU");
    System.out.println("***************");
    System.out.println("1. Handle members");
    System.out.println("2. Handle boats");
    System.out.println("0. Exit");
    System.out.print("Choose an option: ");

    int userInput = getInt();

    switch(userInput) {
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
    System.out.println("***************");
    System.out.println("MEMBERS MENU");
    System.out.println("***************");
    System.out.println("1. Add new member");
    System.out.println("2. Edit member details");
    System.out.println("3. View all members");
    System.out.println("4. View one member");
    System.out.println("5. Delete member");
    System.out.println("0. Go back to main menu");
    System.out.print("Choose an option: ");

    int userInput = getInt();

    switch(userInput) {
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

  public void printMember(Member member) {
    if (member == null) {
      System.out.println("***************");
      System.out.println("MEMBER DETAILS");
      System.out.println("***************");
      System.out.println("No member found.\n");
    } else {
      System.out.println("***************");
      System.out.println("MEMBER DETAILS");
      System.out.println("***************");
      System.out.println("Name: " + member.getName());
      System.out.println("Social security number: " + member.getSocialSecurityNumber());
      System.out.println("Member ID: " + member.getId() + "\n");
    }
  }
}

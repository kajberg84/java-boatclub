package controller;

import java.util.ArrayList;
import model.Member;
import model.MemberRegistry;
import view.MemberView;

/** 
 * Responsible for member operations.
 */
public class MemberHandler {
  MemberView ui;
  private MemberRegistry registry = new MemberRegistry();
  
  public MemberHandler(MemberView ui) {
    this.ui = ui;
  }

  /**
   * Registers a new member.
   */
  public void registerMember() {
    ui.printRegisterMemberHeader();
    String name = ui.promptForMemberName();
    String number = ui.promptForSocialSecurityNumber();
    createMember(name, number);
  }
  
  /**
   * Creates a new member.

   * @param name The name of the new member.
   * @param socialSecurityNumber The social security number of the new member.
   */
  private void createMember(String name, String socialSecurityNumber) {
    registry.addMember(name, socialSecurityNumber);
  }

  /**
   * Edits a member.
   */
  public void editMember() {
    ui.printEditMemberHeader();
    Member member = askForValidMember();
    int editOption = ui.promptForEditMemberOptions(member.getName());

    switch (editOption) {
      case 1: 
        editName(member);
        break;
      case 2:
        editSocialSecurityNumber(member);
        break;
      default: break;
    }
  }

  /**
   * Edits a member's name.

   * @param member The member to edit.
   */
  private void editName(Member member) {
    String name = ui.promptForMemberName();
    member.setName(name);
  }

  /**
   * Edits a member's social security number.

   * @param member The member to edit.
   */
  private void editSocialSecurityNumber(Member member) {
    String socialSecurityNumber = ui.promptForSocialSecurityNumber();
    member.setSocialSecurityNumber(socialSecurityNumber);
  }

  /**
   * Prints one member.
   */
  public void viewMember() {
    Member member = askForValidMember();
    ui.printMemberDetailsHeader();
    ui.printDetailedMember(member);
  }

  /**
   * Prints all members.
   */
  public void viewAllMembers() {
    int viewOption = ui.promptForListOptions();
    if (viewOption > 0) {
      ui.printAllMembersHeader();
      ArrayList<Member> members = getAllMembers();
      if (members.size() == 0) {
        ui.printNoMemberFound();
      }
      printMemberList(viewOption, members);
    }
  }

  /**
   * Prints a list of members based on selected print option.

   * @param viewOption The chosen print option.
   * @param members The members to print.
   */
  private void printMemberList(int viewOption, ArrayList<Member> members) {
    switch (viewOption) {
      case 1: 
        for (Member member : members) {
          ui.printDetailedMember(member);
        }
        break;
      case 2:
        for (Member member : members) {
          ui.printBasicMember(member);
        }
        break;
      default: break;
    }
  }

  /**
   * Returns a member by member ID.

   * @param memberId The ID of the member to get.
   * @return Member
   */
  public Member getMember(String memberId) {
    return registry.getMemberById(memberId);
  }

  /**
   * Returns all members.

   * @return ArrayList
   */
  public ArrayList<Member> getAllMembers() {
    return registry.getAllMembers();
  }
  
  /**
   * Deletes a member.
   */
  public void deleteMember() {
    ui.printDeleteMemberHeader();
    Member member = askForValidMember();
    registry.deleteMember(member);
  }

  /**
   * Asks for a member and returns it.

   * @return Member
   */
  public Member askForValidMember() {
    Member memberToEdit;
    do {
      String memberId = ui.promptForMemberId();
      memberToEdit = getMember(memberId);
    } while (memberToEdit == null);
    return memberToEdit;
  }
}

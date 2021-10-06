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

  private void editName(Member member) {
    String name = ui.promptForMemberName();
    member.setName(name);
  }

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
      ArrayList<Member> members = registry.getAllMembers();
      if (members.size() == 0) {
        ui.printNoMemberFound();
      }
      printMemberList(viewOption, members);
    }
  }

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
      memberToEdit = registry.getMemberById(memberId);
    } while (memberToEdit == null);
    return memberToEdit;
  }
}

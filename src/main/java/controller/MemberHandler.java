package controller;

public class MemberHandler {
  private IdHandler handler = new IdHandler();

  public void createMember(String name, String socialSecurityNumber){
    model.Id memberId = handler.generateUniqueId();
    model.Member newMember = new model.Member(name, socialSecurityNumber, memberId);
    System.out.println(newMember.getName());
    System.out.println(newMember.getSocialSecurityNumber());
    System.out.println(newMember.getId());
  }
}

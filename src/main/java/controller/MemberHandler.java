package controller;

public class MemberHandler {
  private IdHandler handler = new IdHandler();

  public void createMember(String name, int socialSecurityNumber){
    model.Id memberId = handler.generateUniqueId();
    model.Member newMember = new model.Member(name, socialSecurityNumber, memberId);
    System.out.println(newMember.getName());
  }
}

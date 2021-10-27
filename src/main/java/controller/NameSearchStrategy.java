package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Member;
import model.MemberRegistry;
import view.NameSearchView;

public class NameSearchStrategy implements SearchStrategy{
  private NameSearchView ui;
  private Scanner scan;

  public NameSearchStrategy(Scanner s) {
    scan = s;
    ui = new NameSearchView(scan);
  }

  @Override
  public void search(MemberRegistry memberRegistry) {
    String str = ui.promptForSearchString();
    ArrayList<Member> searchResult = new ArrayList<>();
    ArrayList<Member> members = memberRegistry.getAllMembers();
    for (Member m : members) {
      if (m.getName().contains(str)) {
        searchResult.add(m);
      }
    }
    ui.printSearchResult(searchResult);
  }
  
}

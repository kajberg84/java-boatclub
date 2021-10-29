package controller.search;

import java.util.ArrayList;
import java.util.Scanner;
import model.Member;
import model.MemberRegistry;
import view.NameSearchView;

/**
 * A class resonsible for searching for members by name.
 */
public class NameSearchStrategy implements SearchStrategy {
  private NameSearchView ui;

  public NameSearchStrategy(Scanner scan) {
    ui = new NameSearchView(scan);
  }

  @Override
  public void search(MemberRegistry memberRegistry) {
    String str = ui.promptForSearchParameter();
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

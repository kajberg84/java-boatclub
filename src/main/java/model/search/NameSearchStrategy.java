package model.search;

import java.util.ArrayList;
import java.util.Scanner;
import model.Member;
import model.MemberRegistry;
import view.NameSearchView;

/**
 * A class resonsible for searching for members by name.
 */
public class NameSearchStrategy implements MemberRegistry.SearchStrategy {
  private String nameToSearchFor;

  public NameSearchStrategy(String nameToSearchFor) {
    this.nameToSearchFor = nameToSearchFor;
  }

  @Override
  public boolean isSelected(Member member) {
    return member.getName().contains(nameToSearchFor);
  }

  // @Override
  // public void search(MemberRegistry memberRegistry) {
  // String str = ui.promptForSearchParameter();
  // ArrayList<Member> searchResult = new ArrayList<>();
  // ArrayList<Member> members = memberRegistry.getAllMembers();
  // for (Member m : members) {
  // if (m.getName().contains(str)) {
  // searchResult.add(m);
  // }
  // }
  // ui.printSearchResult(searchResult);
  // }
}

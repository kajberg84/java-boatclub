package model.search;

import model.Member;
import model.MemberRegistry;

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
}

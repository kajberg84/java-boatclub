package model.search;

import model.Boat;
import model.BoatType;
import model.Member;
import model.MemberRegistry;

/**
 * A class resonsible for searching for members by boat type.
 */
public class BoatTypeSearchStrategy implements MemberRegistry.SearchStrategy {

  private BoatType boatTypeToSearchFor;

  public BoatTypeSearchStrategy(BoatType boatTypeToSearchFor) {
    this.boatTypeToSearchFor = boatTypeToSearchFor;
  }

  @Override
  public boolean isSelected(Member member) {
    return hasBoatType(boatTypeToSearchFor, member);
  }

  // private BoatTypeSearchView ui;
  // private Scanner scan;

  // public BoatTypeSearchStrategy(Scanner s) {
  // scan = s;
  // ui = new BoatTypeSearchView(scan);
  // }

  // @Override
  // public void search(MemberRegistry memberRegistry) {
  // BoatType boatType = ui.promptForSearchParameter();
  // ArrayList<Member> members = memberRegistry.getAllMembers();
  // ArrayList<Member> searchResult = getUsersWithBoatType(boatType, members);
  // ui.printSearchResult(searchResult);
  // }

  // private ArrayList<Member> getUsersWithBoatType(BoatType boatType,
  // ArrayList<Member> members) {
  // ArrayList<Member> membersWithBoatType = new ArrayList<>();
  // for (Member m : members) {
  // if (hasBoatType(boatType, m)) {
  // membersWithBoatType.add(m);
  // }
  // }
  // return membersWithBoatType;
  // }

  private Boolean hasBoatType(BoatType boatType, Member member) {
    for (Boat boat : member.getBoats()) {
      if (boat.getBoatType().equals(boatType)) {
        return true;
      }
    }
    return false;
  }
}

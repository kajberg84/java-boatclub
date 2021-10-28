package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Boat;
import model.BoatType;
import model.Member;
import model.MemberRegistry;
import view.BoatTypeSearchView;

/**
 * A class resonsible for searching for members by boat type.
 */
public class BoatTypeSearchStrategy implements SearchStrategy {
  private BoatTypeSearchView ui;
  private Scanner scan;

  public BoatTypeSearchStrategy(Scanner s) {
    scan = s;
    ui = new BoatTypeSearchView(scan);
  }

  @Override
  public void search(MemberRegistry memberRegistry) {
    BoatType boatType = ui.promptForSearchParameter();
    ArrayList<Member> searchResult = new ArrayList<>();
    ArrayList<Member> members = memberRegistry.getAllMembers();
    for (Member m : members) {
      Boolean hasBoatType = false;
      for (Boat boat : m.getBoats()) {
        if (boat.getBoatType().equals(boatType)) {
          hasBoatType = true;
        }
      }
      if (hasBoatType) {
        searchResult.add(m);
      }
    }
    ui.printSearchResult(searchResult);
  }
}

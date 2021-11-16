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

  private Boolean hasBoatType(BoatType boatType, Member member) {
    for (Boat boat : member.getBoats()) {
      if (boat.getBoatType().equals(boatType)) {
        return true;
      }
    }
    return false;
  }
}

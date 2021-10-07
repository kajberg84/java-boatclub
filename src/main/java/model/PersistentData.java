package model;

import java.util.ArrayList;

/**
 * Responsible for adding persistent data to application.
 */
public class PersistentData implements Persistence {
  private MemberRegistry registry;

  public PersistentData(MemberRegistry registry) {
    this.registry = registry;
  }

  @Override
  public void load() {
    registry.createMemberWithId("Ellen Nu", "901224");
    registry.createMemberWithId("John Doe", "880101");
    registry.createMemberWithId("Jane Doe", "940606");
    ArrayList<Member> members = registry.getAllMembers();
    addStaticBoat(members.get(0), new Boat(12, BoatType.SAILBOAT));
    addStaticBoat(members.get(0), new Boat(6, BoatType.KAYAKCANOE));
    addStaticBoat(members.get(1), new Boat(10, BoatType.MOTORSAILER));
    addStaticBoat(members.get(2), new Boat(30, BoatType.OTHER));
  }

  private void addStaticBoat(Member member, Boat boat) {
    ArrayList<Boat> boats = member.getBoats();
    boats.add(boat);
    member.setBoats(boats);
  }
}

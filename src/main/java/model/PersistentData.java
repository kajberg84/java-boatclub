package model;

import controller.BoatHandler;
import java.util.ArrayList;

/**
 * Responsible for adding persistent data to application.
 */
public class PersistentData implements Persistence {
  private MemberRegistry registry;
  private BoatHandler boatHandler;

  public PersistentData(MemberRegistry registry, BoatHandler boatHandler) {
    this.registry = registry;
    this.boatHandler = boatHandler;
  }

  @Override
  public void load() {
    registry.addMember("Ellen Nu", "901224");
    registry.addMember("John Doe", "880101");
    registry.addMember("Jane Doe", "940606");
    ArrayList<Member> members = registry.getAllMembers();
    boatHandler.addStaticBoat(members.get(0), new Boat(12, BoatType.SAILBOAT));
    boatHandler.addStaticBoat(members.get(1), new Boat(6, BoatType.KAYAKCANOE));
    boatHandler.addStaticBoat(members.get(2), new Boat(30, BoatType.OTHER));
  }
}

package model;

import controller.MemberHandler;
import java.util.ArrayList;

/**
 * Responsible for handling persistent data.
 */
public class PersistentData {
  private MemberHandler memberHandler;

  public PersistentData(MemberHandler memberHandler) {
    this.memberHandler = memberHandler;
  }

  public void load() {
    memberHandler.createMember("Ellen Nu", "931224");
    memberHandler.createMember("John Doe", "870101");
    memberHandler.createMember("Jane Doe", "860606");
    ArrayList<Member> members = memberHandler.getAllMembers();
    memberHandler.addNewBoat(members.get(0).getId(), new Boat(12, BoatType.SAILBOAT));
    memberHandler.addNewBoat(members.get(0).getId(), new Boat(6, BoatType.KAYAKCANOE));
    memberHandler.addNewBoat(members.get(1).getId(), new Boat(10, BoatType.MOTORSAILER));
    memberHandler.addNewBoat(members.get(2).getId(), new Boat(15, BoatType.OTHER));
  }
}

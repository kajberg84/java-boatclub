package controller;

import model.Boat;
import model.BoatType;
import model.Member;
import view.BoatView;
import java.util.ArrayList;
/** 
 * Responsible for boat operations.
 */
public class BoatHandler {
  BoatView boatUi;

  public BoatHandler(BoatView boatUi) {
    this.boatUi = boatUi;
  }

  /**
   * Creates a new object of type Boat and returns it.

   * @param type The type of the boat that is created.
   * @param length The length of the boat that is created.
   * @return Boat
   */
  public Boat createBoat(BoatType type, int length) {
    return new Boat(length, type);
  }

  public void handleAddBoat() {
    // boatUi.printHeader("register boat");
    Member member = boatUi.askForValidMember();

    BoatType type = boatUi.promptForBoatType();
    int length = boatUi.promptForBoatLength();

    Boat boat = createBoat(type, length);
    addNewBoat(member, boat);
  }

  /**
   * Registers a new boat to a member.
   * 
   * @param memberId The ID of the member to register the boat to.
   * @param boat     The boat to register.
   */
  public void addNewBoat(Member member, Boat boat) {
    ArrayList<Boat> boatsToUpdate = member.getBoats();
    boatsToUpdate.add(boat);
    member.setBoats(boatsToUpdate);
  }

}

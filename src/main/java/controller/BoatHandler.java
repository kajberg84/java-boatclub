package controller;

import java.util.ArrayList;
import model.Boat;
import model.BoatType;
import model.Member;
import view.BoatView;

/** 
 * Responsible for boat operations.
 */
public class BoatHandler {
  BoatView boatUi;

  public BoatHandler(BoatView boatUi) {
    this.boatUi = boatUi;
  }

  /**
   * Registers a new boat to a member.
   */
  public void addNewBoat() {
    boatUi.printRegisterBoatHeader();
    Member member = boatUi.askForValidMember();
    Boat boat = promptForBoatDetails();
    ArrayList<Boat> boatsToUpdate = member.getBoats();
    boatsToUpdate.add(boat);
    member.setBoats(boatsToUpdate);
  }

  /**
   * Prompts for new boat details and returns a new boat.

   * @return Boat
   */
  private Boat promptForBoatDetails() {
    BoatType type = boatUi.promptForBoatType();
    int length = boatUi.promptForBoatLength();
    Boat boat = createBoat(type, length);
    return boat;
  }

  /**
   * Creates a new object of type Boat and returns it.

   * @param type The type of the boat that is created.
   * @param length The length of the boat that is created.
   * @return Boat
   */
  private Boat createBoat(BoatType type, int length) {
    return new Boat(length, type);
  }

  /**
   * Edits a boat.
   */
  public void editBoat() {
    boatUi.printEditBoatHeader();
    Member member = boatUi.askForValidMember();
    int boatIndex = boatUi.promptForBoat(member);
    int editOption = boatUi.promptForEditBoatOptions();

    switch (editOption) {
      case 1: 
        BoatType type = boatUi.promptForBoatType();
        editBoatType(member, boatIndex, type);
        break;
      case 2:
        int length = boatUi.promptForBoatLength();
        editBoatLength(member, boatIndex, length);
        break;
      default: break;
    }
  }

  /**
   * Edits a boat's type.

   * @param member The member owning the boat to edit.
   * @param boatIndex The index of the boat to edit.
   * @param type The new type of the boat.
   */
  private void editBoatType(Member member, int boatIndex, BoatType type) {
    ArrayList<Boat> boats = member.getBoats();
    Boat boatToEdit = boats.get(boatIndex);
    boatToEdit.setBoatType(type);
  }

  /**
  * Edits a boat's length.

  * @param member The member owning the boat to edit.
  * @param boatIndex The index of the boat to edit.
  * @param length The new length of the boat.
  */
  private void editBoatLength(Member member, int boatIndex, int length) {
    ArrayList<Boat> boats = member.getBoats();
    Boat boatToEdit = boats.get(boatIndex);
    boatToEdit.setLength(length);
  }

  /** 
   * Deletes a boat from a member.
   */
  public void deleteBoat() {
    boatUi.printDeleteBoatHeader();
    Member member = boatUi.askForValidMember();
    int boatIndex = boatUi.promptForBoat(member);
    ArrayList<Boat> boatsToUpdate = member.getBoats();
    boatsToUpdate.remove(boatIndex);
    member.setBoats(boatsToUpdate);
  }
}

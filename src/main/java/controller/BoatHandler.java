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
  BoatView ui;

  public BoatHandler(BoatView ui) {
    this.ui = ui;
  }

  /**
   * Registers a new boat to a member.
   */
  public void addNewBoat(Member member) {
    Boat boat = promptForBoatDetails();
    ArrayList<Boat> boatsToUpdate = member.getBoats();
    boatsToUpdate.add(boat);
    member.setBoats(boatsToUpdate);
  }

  private Boat promptForBoatDetails() {
    BoatType type = ui.promptForBoatType();
    int length = ui.promptForBoatLength();
    Boat boat = createBoat(type, length);
    return boat;
  }

  private Boat createBoat(BoatType type, int length) {
    return new Boat(length, type);
  }

  /**
   * Edits a boat.
   */
  public void editBoat(Member member) {
    Boat boat = ui.promptForBoat(member);
    int editOption = ui.promptForEditBoatOptions();

    switch (editOption) {
      case 1: 
        BoatType type = ui.promptForBoatType();
        editBoatType(boat, type);
        break;
      case 2:
        int length = ui.promptForBoatLength();
        editBoatLength(boat, length);
        break;
      default: break;
    }
  }

  private void editBoatType(Boat boat, BoatType type) {
    // ArrayList<Boat> boats = member.getBoats();
    // Boat boatToEdit = boats.get(boatIndex);
    // boatToEdit.setBoatType(type);
    boat.setBoatType(type);
  }

  private void editBoatLength(Boat boat, int length) {
    // ArrayList<Boat> boats = member.getBoats();
    // Boat boatToEdit = boats.get(boatIndex);
    // boatToEdit.setLength(length);
    boat.setLength(length);
  }

  /** 
   * Deletes a boat from a member.
   */
  public void deleteBoat(Member member) {
    Boat boat = ui.promptForBoat(member);
    member.deleteBoat(boat);
    // ArrayList<Boat> boatsToUpdate = member.getBoats();
    // boatsToUpdate.remove(boatIndex);
    // member.setBoats(boatsToUpdate);
  }
}

package controller;

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
    BoatType type = ui.promptForBoatType();
    int length = ui.promptForBoatLength();
    member.addBoat(type, length);
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
    boat.setBoatType(type);
  }

  private void editBoatLength(Boat boat, int length) {
    boat.setLength(length);
  }

  /** 
   * Deletes a boat from a member.
   */
  public void deleteBoat(Member member) {
    Boat boat = ui.promptForBoat(member);
    member.deleteBoat(boat);
  }
}

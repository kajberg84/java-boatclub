package controller;

import java.util.Scanner;
import model.MemberRegistry;
import view.BoatView;
import view.MemberView;

class Menu {
  protected Scanner scan = new Scanner(System.in, "UTF-8");
  protected MemberView memberUi = new MemberView(scan);
  protected BoatView boatUi = new BoatView(scan);
  protected BoatHandler boatHandler = new BoatHandler(boatUi);
  protected MemberRegistry registry;
  protected MemberHandler memberHandler;
  
  public Menu(MemberRegistry r) {
    registry = r;
    memberHandler = new MemberHandler(memberUi, registry);
  }

  public void showMainMenu() {
  }
}

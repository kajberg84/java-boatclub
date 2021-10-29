package controller.menus;

import java.util.Scanner;
import controller.BoatHandler;
import controller.MemberHandler;
import controller.search.BoatTypeSearchStrategy;
import controller.search.NameSearchStrategy;
import controller.search.SearchStrategy;
import model.MemberRegistry;
import view.BoatView;
import view.MemberView;
import view.SearchOptionsView;

public class Menu {
  protected Scanner scan = new Scanner(System.in, "UTF-8");
  protected MemberView memberUi = new MemberView(scan);
  protected BoatView boatUi = new BoatView(scan);
  protected BoatHandler boatHandler = new BoatHandler(boatUi);
  protected MemberRegistry registry;
  protected MemberHandler memberHandler;
  private SearchOptionsView searchUi = new SearchOptionsView(scan);
  private SearchStrategy search;

  public Menu(MemberRegistry r) {
    registry = r;
    memberHandler = new MemberHandler(memberUi, registry);
  }

  public void showMainMenu() {
  }

  protected void handleViewMember() {
    memberHandler.viewMember();
  }

  protected void handleViewAllMembers() {
    memberHandler.viewAllMembers();
  }

  protected void handleSearch() {
    SearchOptionsView.SearchOption option = searchUi.promptForSearchOption();
    switch (option) {
      case NAME:
        search = new NameSearchStrategy(scan);
        search.search(registry);
        break;
      case BOAT:
        search = new BoatTypeSearchStrategy(scan);
        search.search(registry);
        break;
      default:
        break;
    }
  }

  protected void exit() {
    scan.close();
    memberUi.printGoodBye();
  }
}

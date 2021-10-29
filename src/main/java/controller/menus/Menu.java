package controller.menus;

import controller.MemberHandler;
import controller.search.BoatTypeSearchStrategy;
import controller.search.NameSearchStrategy;
import controller.search.SearchStrategy;
import java.util.Scanner;
import model.MemberRegistry;
import view.MenuView;
import view.SearchOptionsView;
import view.SearchOptionsView.SearchOption;

/**
 * Represents a menu.
 */
public class Menu {
  protected Scanner scan = new Scanner(System.in, "UTF-8");
  protected MenuView menuUi = new MenuView(scan);
  protected MemberRegistry registry;
  protected MemberHandler memberHandler;
  private SearchOptionsView searchUi = new SearchOptionsView(scan);
  private SearchStrategy search;

  public Menu(MemberRegistry registry) {
    this.registry = registry;
    memberHandler = new MemberHandler(scan, registry);
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
    SearchOption option = searchUi.promptForSearchOption();
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
    menuUi.printGoodBye();
  }
}

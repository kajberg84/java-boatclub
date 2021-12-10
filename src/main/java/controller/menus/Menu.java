package controller.menus;

import controller.MemberHandler;
import java.util.Scanner;
import model.MemberRegistry;
import model.search.BoatTypeSearchStrategy;
import model.search.NameSearchStrategy;
import view.MenuView;
import view.SearchView;
import view.SearchView.SearchOption;

/**
 * Represents a menu.
 */
public class Menu {
  protected Scanner scan;
  protected MenuView menuUi;
  protected MemberRegistry registry;
  protected MemberHandler memberHandler;
  private SearchView searchUi;
  private MemberRegistry.SearchStrategy searchCriteria;

  /**
   * A menu object.

   * @param registry A member registry.
   * @param scan A scanner object. 
   */
  public Menu(MemberRegistry registry, Scanner scan) {
    this.registry = registry;
    this.scan = scan;
    menuUi = new MenuView(scan);
    searchUi = new SearchView(scan);
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
        searchCriteria = new NameSearchStrategy(searchUi.promptForNameSearchParameter());
        searchUi.printSearchResult(registry.search(searchCriteria));
        break;
      case BOAT:
        searchCriteria = new BoatTypeSearchStrategy(searchUi.promptForBoatTypeSearchParameter());
        searchUi.printSearchResult(registry.search(searchCriteria));
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

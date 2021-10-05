package controller;

/**
 * Responsible for starting the application.
 */
public class App {
  /**
   * Application starting point.

   * @param args command line arguments.
   */


  public static void main(String[] args) {
    // adapt to start the application in your way
    // model.Simple m = new model.Simple();
    // Simple c = new Simple();
    // view.Simple v = new view.Simple();

    // c.doSomethingSimple(m, v);

    // IdHandler handler = new IdHandler();
    // System.out.println(handler.generateUniqueId().getId());
    BoatClubHandler boatClubHandler = new BoatClubHandler();
    boatClubHandler.start();
  }
}

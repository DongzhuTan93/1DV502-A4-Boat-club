
package assignment4;

import assignment4.controller.Controller;
import assignment4.model.DatabaseModel;
import assignment4.view.MainView;
import assignment4.view.ReadWrite;
import java.io.FileNotFoundException;

/**
 * This is main point to start the application.
 */
public class App {
  /**
   * The application starting point.
   *
   * @param args Unused program arguments.
   * @throws FileNotFoundException Throw error.
   */
  public static void main(String[] args) {
    MainView mainView = new MainView();
    DatabaseModel dataBase = new DatabaseModel();
    ReadWrite loadedFile  = new ReadWrite();
    Controller controller = new Controller(dataBase, mainView, loadedFile);
    controller.mainMenu();
  }
}

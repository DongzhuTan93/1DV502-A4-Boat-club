package assignment4.controller;

import assignment4.model.DatabaseModel;
import assignment4.view.MainView;
import assignment4.view.ReadWrite;

/**
 * Main controller.
 */
public class Controller {
  private final assignment4.model.DatabaseModel dataBase;
  private final assignment4.view.MainView mainView;
  private final assignment4.view.ReadWrite loadedFile;

  /**
   * Constructor of the class controller.
   *
   * @param dataBase   Database, instace of class DataBase.
   * @param mainView   MainView, instance of class MainView.
   * @param loadedFile loadedFile, instance of class LoadedFile.
   */
  public Controller(DatabaseModel dataBase, MainView mainView, ReadWrite loadedFile) {
    this.dataBase = new DatabaseModel(); // Create isolated instance of DatabaseModel.
    this.mainView = new MainView(); // Create isolated instance of MainView.
    this.loadedFile = new ReadWrite(); // Create isolated instance of ReadWrite.
  }

  /**
   * Method of the main menu.
   */
  public void mainMenu() {
    loadedFile.fileReader(dataBase);
    boolean running = true;
    while (running) {
      MainView.MainMenu selction = mainView.theMainMenu();
      switch (selction) {
        case ADDMEMBER:
          mainView.addNewMember(dataBase);
          break;
        case SHOWALLMEMBERS:
          mainView.listAllMembers(dataBase);
          break;
        case SELECTAMEMBER:
          String id = mainView.slectMemberById(dataBase);
          mainView.selectMember(dataBase, id);
          subMenu(id);
          break;
        case EXIT:
          loadedFile.writeToFile(dataBase); // Save data before exiting.
          running = false;
          break;
        case NONE:
          // Instead of calling mainMenu again, continue the loop.
          break;
        default:
      }
    }
  }

  /**
   * Method of submenu.
   *
   * @param id Memebrs id.
   */
  public void subMenu(String id) {
    boolean running = true;
    while (running) {
      MainView.SubMenu selction = mainView.theSubMenu();
      switch (selction) {
        case DELETEMEMBER:
          mainView.deleteMember(dataBase, id);
          break;
        case SHWOALLBOATS:
          mainView.showAllBoats(dataBase, id);
          break;
        case SHOWBOATINFO:
          mainView.selectBoatToShow(dataBase, id);
          break;
        case ADDNEWBOAT:
          subBoatMenu(id);
          break;
        case EXIT:
          running = false;
          break;
        case NONE:
          // Instead of calling mainMenu again, continue the loop.
          break;
        default:
      }
    }
  }

  /**
   * Method for subBoatMenu.
   *
   * @param id Member id.
   */
  public void subBoatMenu(String id) {
    boolean running = true;
    while (running) {
      MainView.SubBoatMenu selction = mainView.theSubBoatMenu();
      switch (selction) {
        case ADDSAILBOAT:
          mainView.addSailerBoat(dataBase, id);
          break;
        case ADDMOTORBOAT:
          mainView.addMotorBoat(dataBase, id);
          break;
        case ADDMOTORSAILER:
          mainView.addMotorSailerBoat(dataBase, id);
          break;
        case ADDCANOE:
          mainView.addCanoeBoat(dataBase, id);
          break;
        case EXIT:
          running = false;
          break;
        case NONE:
          // Instead of calling mainMenu again, continue the loop.
          break;
        default:
      }
    }
  }

}

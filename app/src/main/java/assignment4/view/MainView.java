package assignment4.view;

import assignment4.model.BoatModel;
import assignment4.model.DatabaseModel;
import assignment4.model.MemberModel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Take care of view.
 */
public class MainView {
  private Scanner keyboardInput = new Scanner(System.in, StandardCharsets.UTF_8.name());
  // Initialize Scanner with explicit UTF-8 charset to ensure consistent behavior
  // across platforms.
  private String invalidIput = "Please enter a vaild alternative.";

  /**
   * Represents the alternatives of main menu.
   */
  public enum MainMenu {
    ADDMEMBER,
    SHOWALLMEMBERS,
    SELECTAMEMBER,
    NEXT,
    EXIT,
    NONE,
  }

  /**
   * Represents the alternatives of sub menu.
   */
  public enum SubMenu {
    DELETEMEMBER,
    SHWOALLBOATS,
    ADDNEWBOAT,
    SHOWBOATINFO,
    DELETEBOAT,
    EXIT,
    NONE,
  }

  /**
   * Represents the alternatives of sub boot menu.
   */
  public enum SubBoatMenu {
    ADDSAILBOAT,
    ADDMOTORBOAT,
    ADDMOTORSAILER,
    ADDCANOE,
    EXIT,
    NONE,
  }

  /**
   * Take the input from users interface.
   *
   * @return The menu input.
   */
  public String getStringInput() {
    return keyboardInput.nextLine();
  }

  /**
   * Print the head menu.
   */
  public MainMenu theMainMenu() {
    System.out.println("-------------------Welcome to the boat club!-------------------");
    System.out.println("");
    System.out.println("a.Add new member.");
    System.out.println("b.List all mebmers.");
    System.out.println("c.Select a member to edit.");
    System.out.println("q.Quit.");

    String input = getStringInput();

    if (input.equals("a")) {
      return MainMenu.ADDMEMBER;
    }
    if (input.equals("b")) {
      return MainMenu.SHOWALLMEMBERS;
    }
    if (input.equals("c")) {
      return MainMenu.SELECTAMEMBER;
    }
    if (input.equals("q")) {
      exitSystem();
      return MainMenu.EXIT;
    } else {
      System.out.println(invalidIput);
      return MainMenu.NONE;
    }
  }

  /**
   * Print the sub menu.
   * 
   */
  public SubMenu theSubMenu() {
    System.out.println("--------------------------------------");
    System.out.println("");
    System.out.println("a.Delete member.");
    System.out.println("b.Show member boats.");
    System.out.println("c.Show boat info.");
    System.out.println("d.Add new boat.");
    System.out.println("e.Delete boat.");
    System.out.println("q.Back to main menu.");

    String input = this.getStringInput();

    if (input.equals("a")) {
      return SubMenu.DELETEMEMBER;
    } else if (input.equals("b")) {
      return SubMenu.SHWOALLBOATS;
    } else if (input.equals("c")) {
      return SubMenu.SHOWBOATINFO;
    } else if (input.equals("d")) {
      return SubMenu.ADDNEWBOAT;
    } else if (input.equals("e")) {
      return SubMenu.DELETEBOAT;
    } else if (input.equals("q")) {
      return SubMenu.EXIT;
    } else {
      System.out.println(invalidIput);
      return SubMenu.NONE;
    }
  }

  /**
   * Print the sub boat menu.
   * 
   */
  public SubBoatMenu theSubBoatMenu() {
    System.out.println("--------------------------------------");
    System.out.println("");
    System.out.println("a.Add Sail boat.");
    System.out.println("b.Add Motor boat.");
    System.out.println("c.Add Motorsailer boat.");
    System.out.println("d.Add Canoe boat.");
    System.out.println("q.Back to pervious menu.");
    System.out.println("");

    String input = this.getStringInput();

    if (input.equals("a")) {
      return SubBoatMenu.ADDSAILBOAT;
    } else if (input.equals("b")) {
      return SubBoatMenu.ADDMOTORBOAT;
    } else if (input.equals("c")) {
      return SubBoatMenu.ADDMOTORSAILER;
    } else if (input.equals("d")) {
      return SubBoatMenu.ADDCANOE;
    } else if (input.equals("q")) {
      return SubBoatMenu.EXIT;
    } else {
      System.out.println(invalidIput);
      return SubBoatMenu.NONE;
    }
  }

  /**
   * Take the input name from the users.
   *
   */
  public void getNameInput() {
    System.out.print("Please enter your name to register the boat club: ");
  }

  /**
   * Take the input email from the users.
   *
   */
  public void getEmailInput() {
    System.out.print("Please enter your optional email, or press enter to skip it: ");
  }

  /**
   * Show member register successfully info.
   */
  public void showMemberAddedSuccessfully() {
    System.out.println("Member registration successful! ");
  }

  /**
   * Warning about invalid regist name.
   */
  public void invalidRegistName() {
    System.out.println("Please enter a valid name! ");
  }

  /**
   * Warning about valid email.
   */
  public void enterValidEmail() {
    System.out.println("Please enter a valid email adress!");
  }

  /**
   * Show users id.
   *
   * @param id The id for the users.
   */
  public void showMemberId(String id) {
    System.out.println("The members got an id which is: " + id);
  }

  /**
   * Warning about double emails.
   */
  public void doubleEmail() {
    System.out.println("\nThis email is already exist, please enter another email! ");
  }

  /**
   * Selecte current member.
   */
  public void selecteCurrentMember() {
    System.out.print("");
    System.out.print("Please enter the users id to selected the member: ");
    System.out.print("");
  }

  /**
   * Selecte current member.
   */
  public void showSelecteCurrentMember(String name) {
    System.out.print("");
    System.out.print("Member selected: " + name);
    System.out.print("");
  }

  /**
   * No member selected.
   */
  public void noSelectMember() {
    System.out.print("");
    System.out.print("Member not found!");
    System.out.print("");
  }

  /**
   * Selecte current members id.
   */
  public void selectCorrectId() {
    System.out.println("Please enter the correct id!");
  }

  /**
   * Enter boats name.
   */
  public void enterBoatsName() {
    System.out.print("Enter boat name:");
  }

  /**
   * Enter boats length.
   */
  public void enterBoatsLength() {
    System.out.print("Enter boat length:");
  }

  /**
   * Enter boats depth.
   */
  public void enterBoatsDepth() {
    System.out.print("Enter boat depth:");
  }

  /**
   * Enter boats engine power.
   */
  public void enterBoatsEnginepower() {
    System.out.print("Enter boat engine power:");
  }

  /**
   * Can't find the boat.
   */
  public void boatNotFound() {
    System.out.print("Oops! Can't find the boat.");
  }

  /**
   * The current member was deleted successfully.
   */
  public void deleteCurrentMemberSuccessful() {
    System.out.print("The current member was deleted successfully! ");
  }

  /**
   * Exit the system.
   */
  public void exitSystem() {
    System.out.println("");
    System.out.print("You are now sign out from the appliation. See you next time! ");
    System.out.println("");
  }

  /**
   * Method to add anew member.
   *
   * @param dataBase , an isntance of class DatabaseModel.
   */
  public void addNewMember(DatabaseModel dataBase) {
    String name;
    do {
      getNameInput();
      name = getStringInput().trim();
      if (name.trim().isEmpty()) {
        invalidRegistName();
      }
    } while (name.isEmpty());

    String mail;
    boolean isEmailValid;

    do {
      getEmailInput();
      mail = getStringInput().trim();
      if (mail.isEmpty()) {
        // If email is optional and empty, consider it valid.
        isEmailValid = true;
      } else {
        // Check if email is valid and not a duplicate.
        // Debug prints
        System.out.println("Validating email: " + mail);
        System.out.println("Is valid format: " + dataBase.isValidEmail(mail));
        System.out.println("Is duplicate: " + dataBase.isDoubleEmail(mail));

        if (!dataBase.isValidEmail(mail)) {
          enterValidEmail();
          isEmailValid = false;
        } else if (dataBase.isDoubleEmail(mail)) {
          doubleEmail();
          isEmailValid = false;
        } else {
          isEmailValid = true;
        }
      }
    } while (!isEmailValid);

    String id = dataBase.generateId();
    dataBase.addNewMember(name, mail, id);
    showMemberAddedSuccessfully();
    showMemberId(id);
  }

  /**
   * Method that list all users, show name, email, and id.
   *
   * @param dataBase An isntance of class DatabaseModel.
   */
  public void listAllMembers(DatabaseModel dataBase) {
    for (MemberModel member : dataBase.showAllMembers()) {
      System.out.println("-" + "Members name: " + member.getMemberName()
          + "\n" + "\t" + "ID: " + member.getMemberId());
    }
  }

  /**
   * Method to list all inforamtion of a member.
   *
   * @param dataBase An isntance of class DatabaseModel.
   */
  public void selectMember(DatabaseModel dataBase, String id) {
    System.out.println("slelectMember method called with ID: " + id);
    if (dataBase.selectMember(id) != null) {
      MemberModel member = dataBase.selectMember(id);
      System.out.println("Member name : " + member.getMemberName() + "\n "
          + "Member email : " + member.getEmailAdress() + "\n "
          + "Member ID : " + member.getMemberId());
      for (BoatModel boat : member.getBoats()) {
        System.out.println("\t " + "- " + boat.getBoatName() + "\n ");
      }
    } else {
      noSelectMember();
    }

  }

  /**
   * Method to delete the memeber.
   *
   * @param dataBase An isntance of class DatabaseModel.
   */
  public void deleteMember(DatabaseModel dataBase, String id) {
    dataBase.deleteMember(id);
    deleteCurrentMemberSuccessful();
  }

  /**
   * Method to remove the boat.
   *
   * @param data An isntance of class DatabaseModel.
   * @param id   String the id of the boat owner.
   */
  public void deleteBoat(DatabaseModel data, String id) {
    MemberModel member = data.selectMember(id);
    enterBoatsName();
    String name = getStringInput();
    for (BoatModel boat : member.getBoats()) {
      if (boat.getBoatName().equals(name)) {
        member.removedBoat(boat);
      } else {
        boatNotFound();
      }

    }
  }

  /**
   * Methodd to show all the boats that the member have.
   *
   * @param data An isntance of class DatabaseModel.
   * @param id   The selected members id.
   */
  public void showAllBoats(DatabaseModel data, String id) {
    if (data.showTotalBoats(id).isEmpty()) {
      boatNotFound();
    }
    System.out.println(data.showTotalBoats(id));
  }

  /**
   * A method to add a new canoe boat.
   *
   * @param data An isntance of class DatabaseModel.
   * @param id   The selected members id.
   */
  public void addCanoeBoat(DatabaseModel data, String id) {
    enterBoatsName();
    String name = getStringInput();
    enterBoatsLength();
    int length = keyboardInput.nextInt();
    keyboardInput.nextLine(); // Consume the newline character.
    data.addCanoeBoat(id, name, length);
  }

  /**
   * A method to add a new motor boat.
   *
   * @param data An isntance of class DatabaseModel.
   * @param id   The selected members id.
   */
  public void addMotorBoat(DatabaseModel data, String id) {
    enterBoatsName();
    final String name = getStringInput();
    enterBoatsLength();
    final int length = keyboardInput.nextInt();
    keyboardInput.nextLine();
    enterBoatsEnginepower();
    int power = keyboardInput.nextInt();
    keyboardInput.nextLine();
    data.addMotorBoat(id, name, length, power);
  }

  /**
   * A method to add a new motor sailer boat.
   *
   * @param data An isntance of class DatabaseModel.
   * @param id   The selected members id.
   */
  public void addMotorSailerBoat(DatabaseModel data, String id) {
    enterBoatsName();
    final String name = getStringInput();
    enterBoatsLength();
    final int length = keyboardInput.nextInt();
    keyboardInput.nextLine();
    enterBoatsDepth();
    final int depth = keyboardInput.nextInt();
    keyboardInput.nextLine();
    enterBoatsEnginepower();
    int power = keyboardInput.nextInt();
    keyboardInput.nextLine();
    data.addMotorSailerBoat(id, name, length, depth, power);
  }

  /**
   * A method to add a new sailer boat.
   *
   * @param data An isntance of class DatabaseModel.
   * @param id   The selected members id.
   */
  public void addSailerBoat(DatabaseModel data, String id) {
    enterBoatsName();
    final String name = getStringInput();
    enterBoatsLength();
    final int length = keyboardInput.nextInt();
    keyboardInput.nextLine();
    enterBoatsDepth();
    int depth = keyboardInput.nextInt();
    keyboardInput.nextLine();
    data.addSailerBoat(id, name, length, depth);
  }

  /**
   * A method to add a new motor boat.
   *
   * @param data An isntance of class DatabaseModel.
   * @param id   The selected members id.
   */
  public void selectBoatToShow(DatabaseModel data, String id) {
    for (MemberModel member : data.showAllMembers()) {
      if (member.getMemberId().equals(id)) {
        enterBoatsName();
        String name = getStringInput();
        for (BoatModel boat : member.getBoats()) {
          if (boat.getBoatName().equals(name)) {
            System.out.println(boat.toString());
          } else {
            boatNotFound();
          }
        }
      }
    }
  }

  /**
   * A method that select the member by the id.
   *
   * @param dataBase An isntance of class DatabaseModel.
   * @return Members id.
   */
  public String slectMemberById(DatabaseModel dataBase) {
    selecteCurrentMember();
    String id = getStringInput();
    if (!dataBase.memFound(id)) {
      noSelectMember();
      id = getStringInput();
    }
    return id;
  }

}

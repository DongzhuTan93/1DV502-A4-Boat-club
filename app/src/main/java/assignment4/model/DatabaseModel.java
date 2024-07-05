package assignment4.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * DatabaseModel class.
 */
public class DatabaseModel {
  private ArrayList<MemberModel> memberModels = new ArrayList<>();
  private Random random = new Random();

  /**
   * Method to add new member.
   *
   * @param name Members name.
   * @param mail Members email.
   * @param id   Members id.
   */
  public void addNewMember(String name, String mail, String id) {
    memberModels.add(new MemberModel(name, mail, id));
  }

  public Iterable<MemberModel> showAllMembers() {
    return Collections.unmodifiableList(memberModels);
  }

  /**
   * Method to delete the member.
   *
   * @param id Member id.
   */
  public void deleteMember(String id) {
    for (int i = 0; i < memberModels.size(); i++) {
      if (memberModels.get(i).getMemberId().equals(id)) {
        memberModels.remove(memberModels.get(i));
      }
    }
  }

  public boolean isIterableEmpty(Iterable<?> iterable) {
    return iterable == null || !iterable.iterator().hasNext();
  }

  /**
   * Method to select a member.
   *
   * @param id The members id.
   * @return null if no member selected.
   */
  public MemberModel selectMember(String id) {
    for (MemberModel member : showAllMembers()) {
      if (member.getMemberId().equals(id)) {
        return member;
      }
    }
    return null;
  }

  /**
   * Take and verify the users current input email.
   *
   * @return true if the email is valid, false otherwise.
   */
  public boolean isValidEmail(String email) {
    String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    return Pattern.matches(regex, email);
  }

  /**
   * Generate a unique id for each member.
   */
  public String generateId() {
    String id;
    do {
      id = generateRandomId();
    } while (!uniqueId(id));
    return id;
  }

  /**
   * Generate a random 6-character alphanumeric ID with at least one letter and
   * one number.
   */
  private String generateRandomId() {
    StringBuilder builder = new StringBuilder();
    String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String digits = "0123456789";

    // Ensure at least one letter.
    builder.append(letters.charAt(random.nextInt(letters.length())));

    // Ensure at least one digit.
    builder.append(digits.charAt(random.nextInt(digits.length())));

    // Fill the remaining 4 characters with random letters or digits.
    String characters = letters + digits;
    for (int i = 0; i < 4; i++) {
      builder.append(characters.charAt(random.nextInt(characters.length())));
    }

    // Shuffle the characters to avoid predictable patterns.
    return shuffleString(builder.toString());
  }

  /**
   * Shuffle the characters of a string.
   */
  private String shuffleString(String input) {
    List<Character> characters = new ArrayList<>();
    for (char c : input.toCharArray()) {
      characters.add(c);
    }
    Collections.shuffle(characters);
    StringBuilder result = new StringBuilder();
    for (char c : characters) {
      result.append(c);
    }
    return result.toString();
  }

  /**
   * Delete the currently boat.
   *
   * @param member The currently selected member.
   */
  public void deleteBoat(MemberModel member) {
    for (BoatModel boat : member.getBoats()) {
      member.removedBoat(boat);
    }
  }

  /**
   * Show all boats of this member.
   */
  public String showTotalBoats(String id) {
    StringBuilder theString = new StringBuilder();
    for (MemberModel member : showAllMembers()) {
      if (member.getMemberId().equals(id)) {
        for (BoatModel boat : member.getBoats()) {
          theString.append(boat.toString()).append("\n");
        }
        return theString.toString().trim();
      }
    }
    return null;
  }

  /**
   * Method to check if the user id is unique.
   *
   * @param id Ihe member ID.
   * @return False if it is found, else true.
   */
  public boolean uniqueId(String id) {
    if (memberModels.isEmpty()) {
      return true;
    }

    for (MemberModel member : memberModels) {
      if (member.getMemberId().equals(id)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Method to check if the user is already in the system.
   *
   * @param id The member ID.
   * @return True if it is found, else false.
   */
  public boolean memFound(String id) {
    for (MemberModel member : memberModels) {
      if (member.getMemberId().equals(id)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Check users double email.
   */
  public boolean isDoubleEmail(String email) {
    for (MemberModel registerMember : memberModels) {
      if (email.equals(registerMember.getEmailAdress())) {
        return true;
      }
    }
    return false;
  }

  /**
   * Methosd to add canoe boat to a selected member.
   *
   * @param id     The selected member id.
   * @param name   Boat name.
   * @param length Boat length.
   */
  public void addCanoeBoat(String id, String name, int length) {
    MemberModel member = selectMember(id);
    Canoeboat canoe = new Canoeboat(name, length);
    member.addBoat(canoe);
  }

  /**
   * Methosd to add sailer boat to a selected member.
   *
   * @param id     The selected members id.
   * @param name   Boat name.
   * @param length Boat length.
   * @param depth  Boat depth.
   */
  public void addSailerBoat(String id, String name, int length, int depth) {
    MemberModel member = selectMember(id);
    Sailboat sailBoat = new Sailboat(name, length, depth);
    member.addBoat(sailBoat);
  }

  /**
   * Methosd to add motor sailer boat to a selected member.
   *
   * @param id     The selected members id.
   * @param name   Boats name.
   * @param length Boats length.
   * @param depth  Boast depth.
   * @param power  Boats engine power.
   */
  public void addMotorSailerBoat(String id, String name, int length, int depth, int power) {
    MemberModel member = selectMember(id);
    Motorsailer motorSailBoat = new Motorsailer(name, length, depth, power);
    member.addBoat(motorSailBoat);
  }

  /**
   * Methosd to add motor boat to a selected member.
   *
   * @param id     The selected members id.
   * @param name   Boats name.
   * @param length Boats length.
   * @param power  Boats engine power.
   */
  public void addMotorBoat(String id, String name, int length, int power) {
    MemberModel member = selectMember(id);
    Motorboat motorBoat = new Motorboat(name, length, power);
    member.addBoat(motorBoat);
  }

  /**
   * Method to prepare the data before write it to the file.
   *
   * @return String, the data as String.
   */
  public String writeToFile() {
    StringBuilder bld = new StringBuilder();
    for (MemberModel member : memberModels) {
      bld.append(member.toString() + "\n");
      for (BoatModel b : member.getBoats()) {
        bld.append(b.toString() + "\n");
      }
    }
    return bld.toString();
  }

}

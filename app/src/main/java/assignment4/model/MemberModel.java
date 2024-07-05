package assignment4.model;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;

/**
 * MemberModel class.
 */
public class MemberModel {
  ArrayList<BoatModel> boats = new ArrayList<>();
  private String name;
  private String emailAdress;
  private String id;

  /**
   * The constructor of the class.
   *
   * @param name        The members name.
   * @param emailAdress The members email adress.
   * @param id          The members id.
   */
  public MemberModel(String name, String emailAdress, String id) {
    setMemberName(name);
    setEmailAdress(emailAdress);
    setMemberId(id);
  }

  public String getMemberName() {
    return name;
  }

  /**
   * Set the members name.
   *
   * @param name The members name.
   */
  private void setMemberName(String name) {
    this.name = name;
  }

  public String getEmailAdress() {
    return emailAdress;
  }

  /**
   * Validate the input email address.
   *
   * @param emailAdress The members email adress.
   */
  private void setEmailAdress(String emailAdress) {
    this.emailAdress = emailAdress;
  }

  public String getMemberId() {
    return id;
  }

  private void setMemberId(String id) {
    this.id = id;
  }

  public void addBoat(BoatModel boat) {
    boats.add(boat);
  }

  /**
   * Method provides read only of the elemnt of boats array lsit.
   *
   * @return Iterable BoatsModel, list of boats.
   */
  @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "We want this.")
  public Iterable<BoatModel> getBoats() {
    return boats;
  }

  public void removedBoat(BoatModel boat) {
    boats.remove(boat);
  }

  public String toString() {
    return "MEMBER:" + this.getMemberName() + ":" + this.getMemberName() + ":" + this.getMemberId();
  }

}

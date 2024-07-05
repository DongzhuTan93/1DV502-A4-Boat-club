package assignment4.model;

/**
 * BoatsModel class.
 */
public abstract class BoatModel {
  private String name;
  private int length;

  /**
   * The constructor of the class.
   *
   * @param name   The name of the boats.
   * @param length The length of the boat.
   */
  protected BoatModel(String name, int length) {
    setBoatName(name);
    setBoatLength(length);
  }

  public String getBoatName() {
    return name;
  }

  private void setBoatName(String name) {
    this.name = name;
  }

  public int getBoatlength() {
    return length;
  }

  private void setBoatLength(int length) {
    this.length = length;
  }

  public abstract String toString();

}

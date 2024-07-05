package assignment4.model;

/**
 * BoatsModel class.
 */
public class Canoeboat extends BoatModel {
  /**
   * The constructor of the class.
   *
   * @param name   The name of the boats.
   * @param length The length of the boat.
   */
  public Canoeboat(String name, int length) {
    super(name, length);

  }

  @Override
  public String toString() {
    return "BOAT:" + super.getBoatName() + ":" + "canoe" + ":" + this.getBoatlength();
  }
}

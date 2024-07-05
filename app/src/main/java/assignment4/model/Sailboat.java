package assignment4.model;

/**
 * Sailboat class.
 */
public class Sailboat extends BoatModel {
  private int depth;

  /**
   * The constructor of the class.
   *
   * @param name   The name of the boats.
   * @param length The length of the boat.
   * @param depth  The depth of the boat.
   */
  public Sailboat(String name, int length, int depth) {
    super(name, length);
    setBoatDepth(depth);
  }

  public int getBoatDepth() {
    return depth;
  }

  private void setBoatDepth(int depth) {
    this.depth = depth;
  }

  @Override
  public String toString() {
    return "BOAT:" + super.getBoatName() + ":" + "sailboat" + ":" + this.getBoatlength()
        + ":" + this.getBoatDepth();
  }

}

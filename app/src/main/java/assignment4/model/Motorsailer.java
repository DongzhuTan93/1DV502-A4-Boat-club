package assignment4.model;

/**
 * Motorsailer boat class.
 */
public class Motorsailer extends BoatModel {
  private int depth;
  private int enginePower;

  /**
   * The constructor of the class.
   *
   * @param name        The name of the boats.
   * @param length      The length of the boat.
   * @param depth       The depth of the boat.
   * @param enginePower The engine power of the boat.
   */
  public Motorsailer(String name, int length, int depth, int enginePower) {
    super(name, length);
    setBoatDepth(depth);
    setBoatenginePower(enginePower);
  }

  public int getBoatDepth() {
    return depth;
  }

  private void setBoatDepth(int depth) {
    this.depth = depth;
  }

  public int getBoatenginePower() {
    return enginePower;
  }

  private void setBoatenginePower(int enginePower) {
    this.enginePower = enginePower;
  }

  @Override
  public String toString() {
    return "BOAT:" + super.getBoatName() + ":" + "motorsailer" + ":" + this.getBoatlength() + ":"
        + this.getBoatenginePower();
  }

}

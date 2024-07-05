package assignment4.model;

/**
 * Motorboat class.
 */
public class Motorboat extends BoatModel {
  private int enginePower;

  /**
   * The constructor of the class.
   *
   * @param name        The name of the boats.
   * @param length      The length of the boat.
   * @param enginePower The engine power of the boat.
   */
  public Motorboat(String name, int length, int enginePower) {
    super(name, length);
    setBoatenginePower(enginePower);
  }

  public int getBoatenginePower() {
    return enginePower;
  }

  private void setBoatenginePower(int enginePower) {
    this.enginePower = enginePower;
  }

  @Override
  public String toString() {
    return "BOAT:" + super.getBoatName() + ":" + "motorboat" + ":" + this.getBoatlength() + ":"
        + this.getBoatenginePower();
  }

}

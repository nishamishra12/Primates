package jungleprimatesanctuary;

/**
 * Class for Saki Species extends Monkey class.
 */
public class Saki extends Monkey {

  public Saki(String name, String size, String sex, int age, double weight, String favFood,
              int foodReq, int spaceReq) {
    super(name, size, sex, age, weight, favFood, foodReq, spaceReq);
  }

  /**
   * * Get the species of each individual monkey.
   *
   * @return the species of the monkey.
   */
  @Override
  public String getSpecies() {
    return "Saki";
  }
}

package jungleprimatesanctuary;

/**
 * Class for Drill Species extends Monkey class
 */
public class Drill extends Monkey {

  /**
   * Constructs an object of Drill species class with different parameters of the monkey.
   * @param name This parameter takes the name of the monkey
   * @param size This parameter takes the size of the monkey
   * @param sex This parameter takes the sex of the monkey
   * @param age This parameter takes the age
   * @param weight
   * @param favFood
   * @param foodReq
   * @param spaceReq
   */
  public Drill(String name, String size, String sex, int age, double weight, String favFood, int foodReq
          , int spaceReq) {
    super(name, size, sex, age, weight, favFood, foodReq, spaceReq);
  }

  /**
   * * Get the species of each individual monkey.
   *
   * @return the species of the monkey.
   */
  @Override
  public String getSpecies() {
    return "Drill";
  }
}

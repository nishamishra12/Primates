package jungleprimatesanctuary;

/**
 * Class for Guereza Species extends Monkey class.
 */
public class Guereza extends Monkey {

  /**
   * Constructs an object of Guereza species class with different parameters of the monkey.
   *
   * @param name     This parameter takes the name of the monkey
   * @param size     This parameter takes the size of the monkey
   * @param sex      This parameter takes the sex of the monkey
   * @param age      This parameter takes the age of the monkey
   * @param weight   This parameter takes the weight of the monkey
   * @param favFood  This parameter takes the favorite food of the monkey
   * @param foodReq  This parameter takes the food requirement of the monkey
   * @param spaceReq This parameter takes the space requirement of the monkey
   */
  public Guereza(String name, String size, String sex, int age, double weight,
                 String favFood, int foodReq, int spaceReq) {
    super(name, size, sex, age, weight, favFood, foodReq, spaceReq);
  }

  /**
   * * Get the species of each individual monkey.
   *
   * @return the species of the monkey.
   */
  @Override
  public String getSpecies() {
    return "Guereza";
  }
}

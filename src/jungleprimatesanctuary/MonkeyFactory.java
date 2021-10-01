package jungleprimatesanctuary;

public class MonkeyFactory {

  /**
   * Factory method to check the species type depending on the species class
   * @param name this parameter takes name of the monkey
   * @param size this parameter takes the size of the monkey
   * @param sex this parameter takes the sex of the monkey
   * @param age this parameter takes the age of the monkey
   * @param weight this parameter takes the weight of the monkey
   * @param favFood this parameter takes the favorite food of the monkey
   * @param foodReq this parameter takes the food requirement of the monkey
   * @param spaceReq this parameter takes the space requirement of the monkey
   * @param speciesType this parameter takes the species type of the monkey
   * @return object of species type.
   */
  public static Primate createMonkey(String name, String size, String sex, int age, double weight
          , String favFood, int foodReq, int spaceReq, String speciesType) {

    switch (speciesType) {
      case "Drill":
        return new Drill(name, size, sex, age, weight, favFood, foodReq, spaceReq);
      case "Guereza":
        return new Guereza(name, size, sex, age, weight, favFood, foodReq, spaceReq);
      case "Howler":
        return new Howler(name, size, sex, age, weight, favFood, foodReq, spaceReq);
      case "Saki":
        return new Saki(name, size, sex, age, weight, favFood, foodReq, spaceReq);
      case "Spider":
        return new Spider(name, size, sex, age, weight, favFood, foodReq, spaceReq);
      case "Squirrel":
        return new Squirrel(name, size, sex, age, weight, favFood, foodReq, spaceReq);
      case "Tamarin":
        return new Tamarin(name, size, sex, age, weight, favFood, foodReq, spaceReq);
      case "Mangabey":
        return new Mangabey(name, size, sex, age, weight, favFood, foodReq, spaceReq);
      default:
        throw new IllegalStateException("Unexpected value of the monkey: " + speciesType);
    }
  }
}

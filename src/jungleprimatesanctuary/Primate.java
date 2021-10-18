package jungleprimatesanctuary;

/**
 * A Primate interface represents the primates or monkeys residing in a sanctuary.
 * Classes that implement this interface will vary depending
 * upon the species of the primate.
 */
public interface Primate {

  String getName();

  /**
   * * Get the size of each individual monkey.
   *
   * @return the monkey size.
   */
  String getSize();

  /**
   * * Get the sex of each individual monkey.
   *
   * @return the monkey sex.
   */
  String getSex();

  /**
   * * Get the age of each individual monkey.
   *
   * @return the monkey age.
   */
  int getAge();

  /**
   * * Get the weight of each individual monkey.
   *
   * @return the monkey weight.
   */
  double getWeight();

  /**
   * * Get the favorite food of each individual monkey.
   *
   * @return the monkey favorite food.
   */
  String getFavFood();

  /**
   * * Get the species of each individual monkey.
   *
   * @return the species of the monkey.
   */
  String getSpecies();

  /**
   * * Get the space requirement of each individual monkey.
   *
   * @return the space requirement of the monkey.
   */
  int getSpaceReq();

  /**
   * * Get the food requirement of each individual monkey.
   *
   * @return the space requirement of the monkey.
   */
  int getFoodReq();

  /**
   * * Get the housing of each individual monkey.
   *
   * @return housing type.
   */
  String getHousing();

  /**
   * * Set the housing of each individual monkey.
   */
  void setHousing(String housing);

  /**
   * * Get the housing of each individual monkey.
   *
   * @return housing type.
   */
  int getHousingNo();

  /**
   * * Set the housing of each individual monkey.
   */
  void setHousingNo(int housingNo);
}
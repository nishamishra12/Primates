package JunglePrimateSanctuary;

public interface Primate {

  /**
   * * Create a new primate object.
   *
   * @return the primate
   */
  Primate getNewPrimate();

  /**
   * * Get the name of each individual monkey.
   *
   * @return the monkey Name.
   */
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
   * * Get the favroite food of each individual monkey.
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
   * * Get the space requirement of each individual monkey.
   *
   * @return the space requirement of the monkey.
   */
  int getFoodReq();

  /**
   * * Get the medicalCondition of each individual monkey.
   *
   * @return the medical condition of the monkey.
   */
  boolean getMedicalCondition();

  /**
   * * Set the medicalCondition of each individual monkey.
   *
   * @return void.
   */
  void setHealthy(boolean healthy);

  /**
   * * Set the medicalCondition of each individual monkey.
   *
   * @return void.
   */
  String getHousing();

  void setHousing(String housing);

  int getHousingNo();

  void setHousingNo(int housingNo);
}
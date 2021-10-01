package jungleprimatesanctuary;

public interface Primate {

  public String getName();

  /**
   * * Get the size of each individual monkey.
   * @return the monkey size.
   */
  public String getSize();

  /**
   * * Get the sex of each individual monkey.
   * @return the monkey sex.
   */
  public String getSex();

  /**
   * * Get the age of each individual monkey.
   * @return the monkey age.
   */
  public int getAge();

  /**
   * * Get the weight of each individual monkey.
   * @return the monkey weight.
   */
  public double getWeight();

  /**
   * * Get the favorite food of each individual monkey.
   * @return the monkey favorite food.
   */
  public String getFavFood();

  /**
   * * Get the species of each individual monkey.
   * @return the species of the monkey.
   */
  public String getSpecies();

  /**
   * * Get the space requirement of each individual monkey.
   * @return the space requirement of the monkey.
   */
  public int getSpaceReq();

  /**
   * * Get the food requirement of each individual monkey.
   * @return the space requirement of the monkey.
   */
  public int getFoodReq();

  /**
   * * Get the housing of each individual monkey.
   * @return housing type.
   */
 public String getHousing();

  /**
   * * Set the housing of each individual monkey.
   */
  public void setHousing(String housing);

  /**
   * * Get the housing of each individual monkey.
   * @return housing type.
   */
  public int getHousingNo();

  /**
   * * Set the housing of each individual monkey.
   */
  public void setHousingNo(int housingNo);
}
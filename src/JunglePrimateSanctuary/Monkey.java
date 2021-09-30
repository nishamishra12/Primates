package JunglePrimateSanctuary;

/**
 * Abstract base class for implementations of {@link Primate}. This class
 * contains all the method definitions that are common to the concrete
 * implementations of the {@link Primate} interface. A new implementation of
 * the interface has the option of extending this class, or directly
 * implementing all the methods.
 */
abstract class Monkey implements Primate {

  private final String name;
  private final String size;
  private final String sex;
  private final int age;
  private final double weight;
  private final String favFood;
  private final int foodReq;
  private final int spaceReq;
  private boolean isHealthy;
  private String housing;
  private int housingNo;

  public Monkey(String name, String size, String sex, int age, double weight
          , String favFood, int foodReq, int spaceReq, boolean isHealthy
          , String housing, int housingNo) {
    this.name = name;
    this.size = size;
    this.age = age;
    this.sex = sex;
    this.weight = weight;
    this.favFood = favFood;
    this.foodReq = foodReq;
    this.spaceReq = spaceReq;
    this.isHealthy = isHealthy;
    this.housing = housing;
    this.housingNo = housingNo;
  }

  /**
   * * Create a new primate object.
   *
   * @return the primate
   */
  @Override
  public Primate getNewPrimate() {
    return this;
  }

  /**
   * * Get the name of each individual monkey.
   *
   * @return the monkey Name.
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * * Get the size of each individual monkey.
   *
   * @return the monkey size.
   */
  @Override
  public String getSize() {
    return this.size;
  }

  /**
   * * Get the sex of each individual monkey.
   *
   * @return the monkey sex.
   */
  @Override
  public String getSex() {
    return this.sex;
  }

  /**
   * * Get the age of each individual monkey.
   *
   * @return the monkey age.
   */
  @Override
  public int getAge() {
    return this.age;
  }

  /**
   * * Get the weight of each individual monkey.
   *
   * @return the monkey weight.
   */
  @Override
  public double getWeight() {
    return this.weight;
  }

  /**
   * * Get the favroite food of each individual monkey.
   *
   * @return the monkey favorite food.
   */
  @Override
  public String getFavFood() {
    return this.favFood;
  }

  /**
   * * Get the space requirement of each individual monkey.
   *
   * @return the space requirement of the monkey.
   */
  @Override
  public int getSpaceReq() {
    return this.spaceReq;
  }

  /**
   * * Get the medicalCondition of each individual monkey.
   *
   * @return the medical condition of the monkey.
   */
  @Override
  public boolean getMedicalCondition() {
    return this.isHealthy;
  }

  /**
   * * Set the medicalCondition of each individual monkey.
   *
   * @return void.
   */
  @Override
  public void setHealthy(boolean healthy) {
    isHealthy = healthy;
  }

  @Override
  public String getHousing() {
    return housing;
  }

  @Override
  public void setHousing(String housing) {
    this.housing = housing;
  }

  public int getHousingNo() {
    return housingNo;
  }

  public void setHousingNo(int housingNo) {
    this.housingNo = housingNo;
  }

  /**
   * * Get the space requirement of each individual monkey.
   *
   * @return the space requirement of the monkey.
   */
  public int getFoodReq() {
    return foodReq;
  }
}

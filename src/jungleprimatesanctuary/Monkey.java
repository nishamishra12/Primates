package jungleprimatesanctuary;

/**
 * Abstract base class for implementations of {@link Primate}. This class
 * contains all the method definitions that are common to the concrete
 * implementations of the {@link Primate} interface. A new implementation of
 * the interface has the option of extending this class, or directly
 * implementing all the methods.
 */
public abstract class Monkey implements Primate {

  private final String name;
  private final String size;
  private final String sex;
  private final int age;
  private final double weight;
  private final String favFood;
  private final int foodReq;
  private final int spaceReq;
  private String housing;
  private int housingNo;

  /**
   * Constructs a primate class in terms of different parameters of a monkey.
   * @param name this parameter takes the name of the monkey
   * @param size this parameter takes the size of the monkey
   * @param sex this parameter takes the sex of the monkey
   * @param age this parameter takes the age of the monkey
   * @param weight this parameter takes the weight of the monkey
   * @param favFood this parameter takes the favorite food of the monkey
   * @param foodReq this parameter takes the food requirement of the monkey
   * @param spaceReq this parameter takes the space requirement of the monkey
   */
  public Monkey(String name, String size, String sex, int age, double weight
          , String favFood, int foodReq, int spaceReq) {
    this.name = name;
    this.size = size;
    this.age = age;
    this.sex = sex;
    this.weight = weight;
    this.favFood = favFood;
    this.foodReq = foodReq;
    this.spaceReq = spaceReq;
  }

  /**
   *
   * {@inheritDoc}
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   *
   * {@inheritDoc}
   */
  @Override
  public String getSize() {
    return this.size;
  }

  /**
   *
   * {@inheritDoc}
   */
  @Override
  public String getSex() {
    return this.sex;
  }

  /**
   *
   * {@inheritDoc}
   */
  @Override
  public int getAge() {
    return this.age;
  }

  /**
   *
   * {@inheritDoc}
   */
  @Override
  public double getWeight() {
    return this.weight;
  }

  /**
   *
   * {@inheritDoc}
   */
  @Override
  public String getFavFood() {
    return this.favFood;
  }

  /**
   *
   * {@inheritDoc}
   */
  @Override
  public int getSpaceReq() {
    return this.spaceReq;
  }

  /**
   *
   * {@inheritDoc}
   */
  @Override
  public String getHousing() {
    return housing;
  }

  /**
   *
   * {@inheritDoc}
   */
  @Override
  public void setHousing(String housing) {
    this.housing = housing;
  }

  /**
   *
   * {@inheritDoc}
   */
  public int getHousingNo() {
    return housingNo;
  }

  /**
   *
   * {@inheritDoc}
   */
  public void setHousingNo(int housingNo) {
    this.housingNo = housingNo;
  }

  /**
   *
   * {@inheritDoc}
   */
  public int getFoodReq() {
    return foodReq;
  }
}

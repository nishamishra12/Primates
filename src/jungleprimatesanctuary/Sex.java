package jungleprimatesanctuary;

/**
 * This is an enumeration for gender of monkey.
 */
public enum Sex {
  MALE("MALE"),
  FEMALE("FEMALE");

  private final String sex;

  private Sex(String sex) {
    this.sex = sex;
  }

  public String getSex() {
    return sex;
  }
}



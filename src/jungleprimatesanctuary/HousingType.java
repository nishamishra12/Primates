package jungleprimatesanctuary;

/**
 * This is an enumeration for housing type of monkey.
 */
public enum HousingType {
  ISOLATION("Isolation"),
  ENCLOSURE("Enclosure");

  private final String housingType;

  HousingType(String housingType) {
    this.housingType = housingType;
  }

  public String gethousingType() {
    return housingType;
  }
}

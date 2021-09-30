package JunglePrimateSanctuary;

public enum HousingType {
  Isolation("Isolation"),
  Enclosure("Enclosure");

  private final String housingType;

  HousingType(String housingType) {
    this.housingType = housingType;
  }

  public String gethousingType() {
    return housingType;
  }
}

package jungleprimatesanctuary;

/**
 * This is an enumeration for size of monkey.
 */
public enum Size {
  SMALL("SMALL", 1, 100),
  MEDIUM("MEDIUM", 5, 250),
  LARGE("LARGE", 10, 500);

  private final String sizeDescription;
  private final int spaceRequirement;
  private final int foodQuantity;

  Size(String sizeDescription, int spaceRequirement, int foodQuantity) {
    this.sizeDescription = sizeDescription;
    this.spaceRequirement = spaceRequirement;
    this.foodQuantity = foodQuantity;
  }

  public String getSizeDescription() {
    return sizeDescription;
  }

  public int getSpaceRequirement() {
    return spaceRequirement;
  }

  public int getFoodQuantity() {
    return foodQuantity;
  }
}
